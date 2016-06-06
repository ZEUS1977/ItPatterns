package com.itpatterns.game.tictactoe.gui;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import com.itpatterns.game.tictactoe.Simulation;

public class TicTacToe extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1679339825378039217L;
	private JButton simulate;
	private JTextArea log;
	
	public TicTacToe() {

        initUI();
    }

    public final void initUI() {

        simulate = new JButton("Simulate");
        simulate.addActionListener((ActionListener) this);
       
        
        log = new JTextArea();
        log.setEditable(false);
        log.setPreferredSize(new Dimension(500, 500));

        JScrollPane scroll = new JScrollPane();
        JPanel draw = new JPanel();
        draw.setLayout(new GridBagLayout());
        draw.add(simulate,0);
        draw.add(log,1);
        scroll.add(draw);
        add(scroll);
        pack();
        setTitle("TicTacToe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {

                TicTacToe ex = new TicTacToe();
                ex.setVisible(true);
            }
        });
    }

	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(simulate)){
			Simulation sim = new Simulation();
        	sim.randomPlay();
    		log.append("Win X: "+sim.board.xWinner + "\n");
    		log.append("Win O: "+sim.board.oWinner + "\n");
    		log.append("Stalemate: "+sim.board.stalemate + "\n");
		}
		
	}
}