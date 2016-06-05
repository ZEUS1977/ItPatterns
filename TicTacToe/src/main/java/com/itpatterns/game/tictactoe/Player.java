package com.itpatterns.game.tictactoe;


public class Player {
  Enum<PlayerType> type;
  Board board;
  
  public Enum<PlayerType> getType() {
	return type;
}

public void setType(Enum<PlayerType> type) {
	this.type = type;
}

public Board getBoard() {
	return board;
}

public void setBoard(Board board) {
	this.board = board;
}

public Player (Enum<PlayerType> type, Board board){
	  this.type = type;
	  this.board = board;
  }

  public Player() {
	// TODO Auto-generated constructor stub
}

public String move(int x, int y) {
	  String ret = "Move on :" + x  + "," + y;
	  if(type.equals(PlayerType.O)){
		  this.board.grid[x][y] = "O";
		  ret+=" O\n";
	  }else if (type.equals(PlayerType.X)){
		  this.board.grid[x][y] = "X";
		  ret+=" X\n";
	  }
	 
	  board.moves++;
	  return ret;
  } 
}
