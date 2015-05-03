package no.vestein.raspberry.game;

import java.io.IOException;
import java.util.Arrays;

public class Board implements IButtonListener {
	
	private static Board instance = null;
	
	private char[][] board;
	private int height = 30;
	private int length = 60;
	private int playerx = 10;
	private int playery = 10;
	private long lastTime = System.currentTimeMillis();
	
	public static Board getInstance() {
		if (instance == null) {
			instance = new Board();
		}
		return instance;
	}
	
	private Board() {
		board = new char[height][length];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < length; j++) {
				board[i][j] = ' ';
			}
		}
		board[playery][playerx] = '$';
	}
	
	public void printBoard() {
		try {
			Runtime.getRuntime().exec("clear");
			System.out.println("");
			System.out.println("");
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("");
			System.out.println("Something went wrong.");
		}
		char[] line = new char[length];
		Arrays.fill(line, '-');
		System.out.println(String.valueOf(line));
		System.out.println(boardToString(board));
//		for (int i = 0; i < height; i++) {
//			System.out.println(String.valueOf(board[i]));
////			for (int j = 0; j < length; j++) {
////				System.out.print(board[i][j]);
////			}
////			System.out.println("");
//		}
	}
	
	private String boardToString(char[][] board) {
		String sBoard = "";
		
		for (int i = 0; i < board.length; i++) {
			sBoard += String.valueOf(board[i]);
			sBoard += "\n";
		}
		char[] line = new char[length];
		Arrays.fill(line, '-');
		sBoard += String.valueOf(line);
		
		return sBoard;
	}

	public void buttonPressed(int x, int y) {
		long currentTime = System.currentTimeMillis();
		if (currentTime - lastTime > 200) {
			if (playerx + x < 0 || playerx + x >= length || playery + y < 0 || playery + y >= height) return;
			board[playery][playerx] = ' ';
			playerx += x;
			playery += y;
			board[playery][playerx] =  '$';
			printBoard();
			lastTime = System.currentTimeMillis();
		}
	}

}
