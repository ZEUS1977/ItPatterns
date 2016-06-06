package com.itpatterns.game.tictactoe;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Simulation {
	
	private static final Logger logger = LogManager.getLogger();
	
	public Board board;
	public ComputerPlayer playerX;
	public ComputerPlayer playerO;

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

	public Simulation(){
		
	}
	
	public void init(){
		this.start = new Date();
	}
	
	public void destroy(){
		this.end = new Date();
		logger.info("Delay :" + (end.getTime() - start.getTime())+ " ms");
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
			playerO.move(x, y);
			logger.info("Moves O: "+x+","+y);
			board.checkGameOver();
			logger.info(board.print());
			if (board.gameOver)
				break;
			positionBusy=true;
			while(positionBusy){
				x=playerX.randomPosition(board.lenght);
				y=playerX.randomPosition(board.lenght);
				positionBusy = playerX.checkBusy(this, x,y);
			}
			logger.info("Moves O: "+x+","+y);
			board.checkGameOver();
			logger.info(board.print());
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
		logger.info("Won X: "+sim.board.xWinner);
		logger.info("Won O: "+sim.board.oWinner);
		logger.info("Stalemate: "+sim.board.stalemate);
		logger.info("Moves: "+sim.board.moves);
		context.registerShutdownHook();
	}
	
}
