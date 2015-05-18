package no.vestein.raspberry.game;

import java.util.ArrayList;
import java.util.List;

public class ButtonController implements ButtonListener {

    private List<Button> buttons;

    public ButtonController() {
        buttons = new ArrayList<>();
    }

    public void addButton(Button button) {
        if (buttons.contains(button)) return;
        buttons.add(button);
        button.addListener(this);
    }

    public void addButtons(Button ... buttons) {
        for (Button button : buttons) {
            addButton(button);
        }
    }

    public void removeButton(Button button) {
        if (buttons.contains(button)) return;
        buttons.remove(button);
        button.removeListener(this);
    }

    @Override
    public void buttonPressed(int dirx, int diry) {
        Board.getInstance().movePlayer(dirx, diry);
    }

}
