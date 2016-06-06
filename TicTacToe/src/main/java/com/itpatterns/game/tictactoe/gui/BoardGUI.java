package com.itpatterns.game.tictactoe.gui;


import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.itpatterns.game.tictactoe.Simulation;

 
/*
 * FileChooserDemo.java uses these files:
 *   images/Open16.gif
 *   images/Save16.gif
 */
public class BoardGUI extends JPanel
                             implements ActionListener, MouseListener {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 3435272260622015235L;
	
	static private final String newline = "\n";
    JButton playButton, resetButton;
    JTextArea log;
    JScrollPane logScrollPane;
    
    public BoardGUI() {
        super(new BorderLayout());
 
        //Create the log first, because the action listeners
        //need to refer to it.
        log = new JTextArea(5,80);
        log.setMargin(new Insets(5,5,5,5));
        log.setEditable(false);
        logScrollPane = new JScrollPane(log);
 
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
        playButton = new JButton("Play",
                                 createImageIcon("images/Open16.gif"));
        playButton.addActionListener(this);
 
        //Create the save button.  We use the image from the JLF
        //Graphics Repository (but we extracted it from the jar).
        resetButton = new JButton("Reset",
                                 createImageIcon("images/Save16.gif"));
        resetButton.addActionListener(this);
 
        //For layout purposes, put the buttons in a separate panel
        JPanel buttonPanel = new JPanel(); //use FlowLayout
        buttonPanel.add(playButton);
        buttonPanel.add(resetButton);
 
        //Add the buttons and the log to this panel.
        add(buttonPanel, BorderLayout.PAGE_START);
        add(logScrollPane, BorderLayout.CENTER);
    }
    

 
    public void actionPerformed(ActionEvent e) {
 
        //Handle open button action.
        if (e.getSource() == playButton) {
        	Simulation sim = new Simulation();
        	sim.randomPlay();
    		log.append("Win X: "+sim.board.xWinner + "\n");
    		log.append("Win O: "+sim.board.oWinner + "\n");
    		log.append("Stalemate: "+sim.board.stalemate + "\n");
        	
        } else if (e.getSource() == resetButton) {
/*        	logScrollPane.remove(log);
        	log =  new JTextArea(5,80);
        	logScrollPane.add(log);
            logScrollPane.updateUI();*/
        }
    }
 
    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = BoardGUI.class.getResource(path);
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
        JFrame frame = new JFrame("TicTacToe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Add content to the window.
        BoardGUI gui = new BoardGUI();
        frame.add(gui);
       /* GridLayout gridL = new GridLayout(Board.LENGH, Board.LENGH);
        JPanel gridPanel = new JPanel(gridL);
        gridPanel.addMouseListener(gui);
        frame.add(gridPanel);*/
 
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



	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		log.append(String.valueOf(e.getX()));
		log.append(String.valueOf(e.getX()));
	
	}



	
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
