package no.vestein.raspberry.game;

import java.util.ArrayList;
import java.util.List;

public class Board {
	
	private static Board instance = null;
	
	private char[][] map;
	private int height = 30;
	private int length = 60;
	private int playerx = 10;
	private int playery = 10;
	
	private List<IBoardListener> listeners = new ArrayList<>();
	
	public static Board getInstance() {
		if (instance == null) {
			instance = new Board();
		}
		return instance;
	}
	
	private Board() {
		map = new char[height][length];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < length; j++) {
				map[i][j] = ' ';
			}
		}
		map[playery][playerx] = '$';
	}
	
	public void init() {
		boardChanged();
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getLength() {
		return length;
	}
	
	public char[][] getMap() {
		return map;
	}
	
	public void movePlayer(int dirx, int diry) {
		if (playerx + dirx < 0 || playerx + dirx >= length || playery + diry < 0 || playery + diry >= height) return;
		map[playery][playerx] = ' ';
		playerx += dirx;
		playery += diry;
		map[playery][playerx] =  '$';
		boardChanged();
	}
	
	public void boardChanged() {
		for (IBoardListener listener : listeners) {
			listener.boardChanged();
		}
	}
	
	public void addListener(IBoardListener listener) {
		if (listeners.contains(listener)) return;
		listeners.add(listener);
	}
	
	public void removeListener(IBoardListener listener) {
		if (listeners.contains(listener)) return;
		listeners.remove(listener);
	}

}
