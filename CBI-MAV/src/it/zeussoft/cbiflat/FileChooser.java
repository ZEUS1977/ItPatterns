package it.zeussoft.cbiflat;
 
import it.zeussoft.cbiflat.mav.TracciatoClient;
import it.zeussoft.cbiflat.mav.beans.Result;
import it.zeussoft.cbiflat.mav.beans.input.ExcelFixedFormat;
import it.zeussoft.cbiflat.mav.beans.product.ProdottoTracciato;
import it.zeussoft.cbiflat.mav.excelreader.BeansPopulator;
import it.zeussoft.cbiflat.mav.excelreader.ExcelFileReader;
import it.zeussoft.cbiflat.mav.factory.TracciatoFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Vector;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import org.apache.poi.hssf.usermodel.HSSFCell;

import com.blackbear.flatworm.FileCreator;
 
/*
 * FileChooserDemo.java uses these files:
 *   images/Open16.gif
 *   images/Save16.gif
 */
public class FileChooser extends JPanel
                             implements ActionListener {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 3435272260622015235L;
	
	static private final String newline = "\n";
    JButton openButton, saveButton;
    JTextArea log;
    JFileChooser fc;
 
    public FileChooser() {
        super(new BorderLayout());
 
        //Create the log first, because the action listeners
        //need to refer to it.
        log = new JTextArea(5,80);
        log.setMargin(new Insets(5,5,5,5));
        log.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(log);
 
        //Create a file chooser
        fc = new JFileChooser();
 
        //Uncomment one of the following lines to try a different
        //file selection mode.  The first allows just directories
        //to be selected (and, at least in the Java look and feel,
        //shown).  The second allows both files and directories
        //to be selected.  If you leave these lines commented out,
        //then the default mode (FILES_ONLY) will be used.
        //
        //fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
 
        //Create the open button.  We use the image from the JLF
        //Graphics Repository (but we extracted it from the jar).
        openButton = new JButton("Open a Excel...",
                                 createImageIcon("images/Open16.gif"));
        openButton.addActionListener(this);
 
        //Create the save button.  We use the image from the JLF
        //Graphics Repository (but we extracted it from the jar).
        saveButton = new JButton("Save CBI...",
                                 createImageIcon("images/Save16.gif"));
        saveButton.addActionListener(this);
 
        //For layout purposes, put the buttons in a separate panel
        JPanel buttonPanel = new JPanel(); //use FlowLayout
        buttonPanel.add(openButton);
        buttonPanel.add(saveButton);
 
        //Add the buttons and the log to this panel.
        add(buttonPanel, BorderLayout.PAGE_START);
        add(logScrollPane, BorderLayout.CENTER);
    }
    
    public void readAndPopulate(String input){
    	
    	Vector<Vector<HSSFCell>> dataHolder = null;
		try{
			dataHolder = ExcelFileReader.readExcel(input);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		ExcelFileReader.printCellDataToConsole(dataHolder);
		
		
		Vector<ExcelFixedFormat> rows = BeansPopulator.excelBeansPopulate(input,dataHolder);
		
		TracciatoFactory tf = new TracciatoFactory();
		ProdottoTracciato tracciato = new ProdottoTracciato();
		FileCreator file = null;
		
		file = TracciatoClient.openFile(TracciatoClient.CONF_FILE, TracciatoClient.OUT_FILE);
		
		Result res = tf.populateTracciato(rows, tracciato, file);
		tf.writeTracciato(tracciato,file);

		TracciatoClient.closeFile(file);
		log.append("File CBI created." + newline);
		log.append("Rows: " + res.getRows() + " Total: " + res.getTot() + newline);
		
		
	}
 
    public void actionPerformed(ActionEvent e) {
 
        //Handle open button action.
        if (e.getSource() == openButton) {
            int returnVal = fc.showOpenDialog(FileChooser.this);
 
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                //This is where a real application would open the file.
                log.append("Opening: " + file.getAbsolutePath() + "." + newline);
                readAndPopulate(file.getAbsolutePath());
            } else {
                log.append("Open command cancelled by user." + newline);
            }
            log.setCaretPosition(log.getDocument().getLength());
 
        //Handle save button action.
        } else if (e.getSource() == saveButton) {
            int returnVal = fc.showSaveDialog(FileChooser.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                try{
                	Files.copy(new File(TracciatoClient.OUT_FILE).toPath(),
                			file.toPath(), StandardCopyOption.REPLACE_EXISTING);
                }catch (Exception ex){
                	log.append(e.toString());
                }
                //This is where a real application would save the file.
                log.append("Saving: " + file.getName() + "." + newline);
            } else {
                log.append("Save command cancelled by user." + newline);
            }
            log.setCaretPosition(log.getDocument().getLength());
        }
    }
 
    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = FileChooser.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("FileChooserDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Add content to the window.
        frame.add(new FileChooser());
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE); 
                createAndShowGUI();
            }
        });
    }
}
