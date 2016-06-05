package com.itpatterns.game.tictactoe;

import java.util.Date;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Simulation {
	
	public Board board;
	public ComputerPlayer playerX;
	public ComputerPlayer playerO;
	public String logs = "";

	public Date start;
	public Date end;
	
	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

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
	
	public void init(){
		this.start = new Date();
	}
	
	public void destroy(){
		this.end = new Date();
		System.out.println("Delay :" + (end.getTime() - start.getTime())+ " ms");
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
				x=playerO.randomPosition(board.lenght);
				y=playerO.randomPosition(board.lenght);
				positionBusy = playerO.checkBusy(this, x,y);
				
			}
			logs+=playerO.move(x, y);
			board.checkGameOver();
			logs += board.print();
			System.out.println(board.print());//TODO: sistemare con lo5j anche per GUI
			if (board.gameOver)
				break;
			positionBusy=true;
			while(positionBusy){
				x=playerX.randomPosition(board.lenght);
				y=playerX.randomPosition(board.lenght);
				positionBusy = playerX.checkBusy(this, x,y);
			}
			logs+=playerX.move(x, y);
			board.checkGameOver();
			logs += board.print();
			System.out.println(board.print());//TODO: sistemare con lo5j anche per GUI
			if (board.gameOver)
				break;
		}
	}
	
	public static void main(String[] args){
		@SuppressWarnings("resource")
		AbstractApplicationContext    context = 	
	             new ClassPathXmlApplicationContext("Simulation.xml");

		Simulation sim = (Simulation)context.getBean("sim");
		sim.randomPlay();
		System.out.println(sim.logs);
		System.out.println("Won X: "+sim.board.xWinner);
		System.out.println("Won O: "+sim.board.oWinner);
		System.out.println("Stalemate: "+sim.board.stalemate);
		System.out.println("Moves: "+sim.board.moves);
		context.registerShutdownHook();
	}
	
}
