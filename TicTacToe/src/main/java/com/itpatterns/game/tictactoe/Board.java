package com.itpatterns.game.tictactoe;

public class Board {
	public static int LENGH = 3;
	String[][] grid = new String[LENGH][LENGH];
	String xWin = "XXX";
	String oWin = "OOO";
	public boolean xWinner = false;
	public boolean oWinner = false;
	public boolean stalemate = false;	
	boolean gameOver = false;
	public static String FREE_POSITION = " ";
	int moves = 0;
	
	public Board(){
		for (int i = 0; i < LENGH; i++){
			for (int j = 0; j < LENGH; j++)
				grid[i][j] = FREE_POSITION;
		}
	}
	
	public boolean checkTris(String tris){
		if (tris.equals(xWin)){
			xWinner = true;
			return true;
		}else if (tris.equals(oWin)){
			oWinner = true;
			return true;
		}
		return false;
	}
	
	public void checkGameOver(){	
		String dig1Tris = "";
		String dig2Tris = "";

		if(moves <= 9){
				gameOver = checkCols();
				if(!gameOver)
					gameOver = checkRows();
				if(!gameOver){
					//controllo una diagonale
					dig1Tris=grid[0][0]+grid[1][1]+grid[2][2];
					gameOver = checkTris(dig1Tris);
				}
				if (!gameOver){			
					//controllo l'altra diagonale
					dig2Tris=grid[0][2]+grid[1][1]+grid[2][0];
					gameOver = checkTris(dig2Tris); 
				}
		}else{
			gameOver = true;
			stalemate = true;
		}
	}

	private boolean checkRows() {
		String rowTris = "";
		//controllo le righe
				for (int j=0; j < LENGH; j++){
					for (int i=0; i < LENGH; i++){ 
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
				for (int i=0; i < LENGH; i++){ 
					for (int j=0; j < LENGH; j++){
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
		for (int i = 0; i < LENGH; i++ ){
			strBuf.append(grid[i][0] + "|");
			strBuf.append(grid[i][1] + "|");
			strBuf.append(grid[i][2]);
			strBuf.append("\n");
			strBuf.append("-----\n");
			
		}
		return strBuf.toString();
	}
}
