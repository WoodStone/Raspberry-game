package no.vestein.raspberry.game;

import java.io.IOException;
import java.util.Arrays;

public class Renderer implements BoardListener {
	
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
		System.out.println(boardToString(board));
	}
	
	private String boardToString(Board board) {
		char[][] map = board.getMap();
		String sBoard = "";
		char[] line = new char[board.width + 2];
		Arrays.fill(line, '-');
		
		sBoard += String.valueOf(line);
		for (int i = 0; i < board.height; i++) {
			sBoard += "|";
			sBoard += String.valueOf(map[i]);
			sBoard += "|";
			sBoard += "\n";
		}
		sBoard += String.valueOf(line);
		
		return sBoard;
	}

	@Override
	public void boardChanged() {
		print();
	}
	
}
