package com.itpatterns.game.tictactoe;

import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Simulation {
	
	public Board board;
	public ComputerPlayer playerX;
	public ComputerPlayer playerO;
	public String logs = "";

	
	
	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public ComputerPlayer getPlayerX() {
		return playerX;
	}

	public void setPlayerX(ComputerPlayer pX) {
		this.playerX = pX;
	}

	public ComputerPlayer getPlayerO() {
		return playerO;
	}

	public void setPlayerO(ComputerPlayer pO) {
		this.playerO = pO;
	}

	public String getLogs() {
		return logs;
	}

	public void setLogs(String logs) {
		this.logs = logs;
	}

	public Simulation(){
		
	}
	
	public Simulation(Board board, ComputerPlayer playerX, ComputerPlayer playerO){
		this.board = board;
		this.playerX = playerX;
		this.playerO = playerO;
		
	}

	public void randomPlay() {
		boolean positionBusy= true;
		int x=-1;
		int y=-1;
		while (!board.gameOver){
			
			positionBusy=true;
			while(positionBusy){
				x=playerO.randomPosition();
				y=playerO.randomPosition();
				positionBusy = playerO.checkBusy(this, x,y);
				
			}
			logs+=playerO.move(x, y);
			board.checkGameOver();
			logs += board.print();
			if (board.gameOver)
				break;
			positionBusy=true;
			while(positionBusy){
				x=playerX.randomPosition();
				y=playerX.randomPosition();
				positionBusy = playerX.checkBusy(this, x,y);
			}
			logs+=playerX.move(x, y);
			board.checkGameOver();
			logs += board.print();
		}
	}
	
	public static void main(String[] args){
		@SuppressWarnings("resource")
		ApplicationContext   context = 	
	             new ClassPathXmlApplicationContext("Simulation.xml");

		Simulation sim = (Simulation)context.getBean("sim");
		sim.randomPlay();
		System.out.println(sim.logs);
		System.out.println("Win X: "+sim.board.xWinner);
		System.out.println("Win O: "+sim.board.oWinner);
		System.out.println("Stalemate: "+sim.board.stalemate);
	}
	
}
