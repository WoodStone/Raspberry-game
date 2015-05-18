package no.vestein.raspberry.game.command;

import no.vestein.raspberry.game.Board;

import java.util.List;

/**
 * Created by Vestein Dahl on 18.05.2015.
 */
public class CommandMove extends CommandBase {

    @Override
    public String getName() {
        return "move";
    }

    @Override
    public String getUsage() {
        return null;
    }

    @Override
    public void processCommand(List<String> strings) {
        if (strings.isEmpty() || strings.size() < 2) return;
        Board board = Board.getInstance();
        int x = Integer.parseInt(strings.get(0));
        int y = Integer.parseInt(strings.get(1));

        board.movePlayer(x - board.getPlayerx(), y - board.getPlayery());

    }
}
