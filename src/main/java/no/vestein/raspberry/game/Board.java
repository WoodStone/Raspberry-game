package no.vestein.raspberry.game;

import java.util.ArrayList;
import java.util.List;

public class Board {
	
	private static Board instance = null;
	
	public final int height = 30;
	public final int width = 60;
	
	private char[][] map;
	private int playerx = 10;
	private int playery = 10;
	
	private List<BoardListener> listeners = new ArrayList<>();
	
	public static Board getInstance() {
		if (instance == null) {
			instance = new Board();
		}
		return instance;
	}
	
	private Board() {
		map = new char[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				map[i][j] = ' ';
			}
		}
		map[playery][playerx] = '$';
	}
	
	public void init() {
		updateListeners();
	}
	
	public char[][] getMap() {
		return map;
	}
	
	public void movePlayer(int dirx, int diry) {
		if (playerx + dirx < 0 || playerx + dirx >= width || playery + diry < 0 || playery + diry >= height) return;
		map[playery][playerx] = ' ';
		playerx += dirx;
		playery += diry;
		map[playery][playerx] =  '$';
		updateListeners();
	}
	
	public void updateListeners() {
		for (BoardListener listener : listeners) {
			listener.boardChanged();
		}
	}
	
	public void addListener(BoardListener listener) {
		if (listeners.contains(listener)) return;
		listeners.add(listener);
	}
	
	public void removeListener(BoardListener listener) {
		if (!listeners.contains(listener)) return;
		listeners.remove(listener);
	}

}
