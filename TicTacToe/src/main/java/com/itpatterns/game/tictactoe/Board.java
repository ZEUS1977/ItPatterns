package com.itpatterns.game.tictactoe;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Board {
	
	private static final Logger logger = LogManager.getLogger();
	
	public int lenght;
	public String[][] grid; 
	public boolean xWinner = false;
	public boolean oWinner = false;
	public boolean stalemate = false;	
	boolean gameOver = false;
	public static String FREE_POSITION = " ";
	public int moves = 0;
	
	public Board(){
		
	}
	
	public void init(){
		logger.info("INIT Lenght: "+lenght);
		this.grid = new String[this.lenght][this.lenght];
		for (int i = 0; i < this.lenght; i++){
			for (int j = 0; j < this.lenght; j++)
				grid[i][j] = FREE_POSITION;
		}
	}
	
	
	public int getLenght() {
		return lenght;
	}

	public void setLenght(int lenght) {
		this.lenght = lenght;
	}

	public  boolean checkString(String regex, String input){
		  Pattern pattern = Pattern.compile(regex);
		  Matcher matcher = pattern.matcher(input);

		  if (matcher.matches())
		    return true;
		  else
		    return false;
	}
	
	public boolean checkWinner(PlayerType pType, String tuple){
		if(checkString("["+pType.toString()+"]{"+lenght+"}", tuple))
			return true;
		else
			return false;
		
	}
	
	public boolean checkTris(String tuple){
		if (checkWinner(PlayerType.X, tuple)){
			logger.info("Winner is X");
			xWinner = true;
			return true;
		}else if (checkWinner(PlayerType.O, tuple)){
			logger.info("Winner is O");
			oWinner = true;
			return true;
		}
		return false;
	}
	
	public void checkGameOver(){	
		String dig1Tris = "";
		String dig2Tris = "";

		if(moves <= lenght*lenght){
				logger.info("Check columns");
				gameOver = checkCols();
				if(!gameOver){
					logger.info("Check rows");
					gameOver = checkRows();
				}
				if(!gameOver){
					logger.info("Check first diagonal");
					//controllo una diagonale
					//creandola prima con indici tutti uguali
					for (int i=0; i <lenght; i++)
						dig1Tris+=grid[i][i];
					gameOver = checkTris(dig1Tris);
				}
				if (!gameOver){		
					logger.info("Check second diagonal");
					//controllo l'altra diagonale
					for(int j=0; j < lenght; j++)
						dig2Tris+=grid[j][lenght-j-1];
					gameOver = checkTris(dig2Tris); 
				}
		  if(moves == lenght*lenght && !gameOver){
			logger.info("Stalemate");
			gameOver = true;
			stalemate = true;
		  }
		}
	}

	private boolean checkRows() {
		String rowTris = "";
		//controllo le righe
				for (int j=0; j < lenght; j++){
					for (int i=0; i < lenght; i++){ 
						rowTris+=grid[i][j];
					}
					if (checkTris(rowTris)){						
						return true;
					}else{
						rowTris = "";
					}
				}
		return false;
	}

	private boolean checkCols() {
		
		String colTris = "";
		//controllo le colonne
				for (int i=0; i < lenght; i++){ 
					for (int j=0; j < lenght; j++){
						colTris+=grid[i][j];
					}
					if (checkTris(colTris)){						
						return true;
					}else{
						colTris = "";
					}
				}
		return false;
	}

	public String print() {
		StringBuffer strBuf = new StringBuffer();
		strBuf.append("\n-------\n");	
		for (int i = 0; i < lenght; i++ ){
			for (int j=0; j < lenght; j++){
				if (j==0)
					strBuf.append("|"+grid[i][j]  + "|");
				else
					strBuf.append(grid[i][j] + "|");
			}			
			strBuf.append("\n-------\n");			
		}
		return strBuf.toString();
	}
}
