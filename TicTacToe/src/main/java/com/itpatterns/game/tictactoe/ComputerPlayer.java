package com.itpatterns.game.tictactoe;

public class ComputerPlayer extends Player {
	
	public ComputerPlayer() {
		super();
		
	}

	public ComputerPlayer(Enum<PlayerType> type, Board board) {
		super(type, board);
		
	}

	public int randomPosition(int max){
		return (0 + (int)(Math.random()*100)%max);
	}

	boolean checkBusy(Simulation simulation, int x, int y) {
		
		if(simulation.board.grid[x][y].equals(Board.FREE_POSITION))
			return false;
		else if (simulation.board.grid[x][y].equals("X"))
			return true;
		else if (simulation.board.grid[x][y].equals("O"))
			return true;
		else
			return false;
	}

}
