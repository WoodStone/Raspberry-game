package no.vestein.raspberry.game;

import java.io.IOException;
import java.util.Arrays;

public class Renderer implements IBoardListener {
	
	private Board board;
	
	public Renderer(Board board) {
		this.board = board;
	}

	private void print() {
		try {
			Runtime.getRuntime().exec("clear");
			System.out.println("");
			System.out.println("");
		} catch (IOException e) {
			System.out.println("");
			System.out.println("Something went wrong.");
		}
		char[] line = new char[board.getLength()];
		Arrays.fill(line, '-');
		System.out.println(String.valueOf(line));
		System.out.println(boardToString(board));
	}
	
	private String boardToString(Board board) {
		char[][] map = board.getMap();
		String sBoard = "";
		
		for (int i = 0; i < board.getHeight(); i++) {
			sBoard += String.valueOf(map[i]);
			sBoard += "\n";
		}
		char[] line = new char[board.getLength()];
		Arrays.fill(line, '-');
		sBoard += String.valueOf(line);
		
		return sBoard;
	}

	@Override
	public void boardChanged() {
		print();
	}
	
}
