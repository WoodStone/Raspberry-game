package no.vestein.raspberry.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    private static Board instance = new Board();

    public final int height = 30;
    public final int width = 60;

    private char[][] map;
    private int playerx = Util.randInt(width - 1);
    private int playery = Util.randInt(height - 1);

    private List<BoardListener> listeners = new ArrayList<>();

    public static Board getInstance() {
        return instance;
    }

    private Board() {
        map = new char[height][width];
        for (char[] row : map) {
            Arrays.fill(row, ' ');
        }
        map[playery][playerx] = '$';
    }

    public void init() {
        updateListeners();
    }

    public char[][] getMap() {
        return map;
    }

    public int getPlayerx() {
        return playerx;
    }

    public int getPlayery() {
        return playery;
    }

    public void movePlayer(int dirx, int diry) {
        try {
            map[playery + diry][playerx + dirx] = '$';
        } catch (ArrayIndexOutOfBoundsException e) {
            return;
        }
        map[playery][playerx] = ' ';
        playerx += dirx;
        playery += diry;
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
