package no.vestein.raspberry.game.command;

import no.vestein.raspberry.game.Renderer;

import java.util.List;

/**
 * Created by Vestein Dahl on 18.05.2015.
 */
public class CommandRender extends CommandBase {

    private Renderer renderer;

    public CommandRender(Renderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public String getName() {
        return "render";
    }

    @Override
    public String getUsage() {
        return null;
    }

    @Override
    public void processCommand(List<String> strings) {
        renderer.boardChanged();
    }
}
