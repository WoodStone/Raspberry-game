package no.vestein.raspberry.game;

import java.io.Console;

import com.pi4j.io.gpio.GpioFactory;
import no.vestein.raspberry.game.command.CommandHandler;
import no.vestein.raspberry.game.command.CommandMove;
import no.vestein.raspberry.game.command.CommandQuit;
import no.vestein.raspberry.game.command.CommandRender;


public class Main {

    public static void main(String[] args) throws InterruptedException {

        Board board = Board.getInstance();
        Renderer renderer = new Renderer(board);
        board.addListener(renderer);

        ButtonController buttonController = new ButtonController();
        buttonController.addButtons(Button.values());

        CommandHandler commandHandler = CommandHandler.getInstance();
        commandHandler.registerCommand(new CommandQuit());
        commandHandler.registerCommand(new CommandRender(renderer));
        commandHandler.registerCommand(new CommandMove());

        board.init();

        while (true) {
            Console console = System.console();
            String[] input = console.readLine().split(" ");

            commandHandler.checkInput(input);
//			if (input[0].equals("")) {
//                break;
//          }
        }

//        shutdown();
    }

    public static void shutdown() {
        GpioFactory.getInstance().shutdown();
        System.exit(0);
    }

}
