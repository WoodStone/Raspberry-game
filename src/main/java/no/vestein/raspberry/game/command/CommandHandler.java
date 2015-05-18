package no.vestein.raspberry.game.command;

import java.util.*;

/**
 * Created by Vestein Dahl on 18.05.2015.
 */
public class CommandHandler {

    private Map<String, CommandBase> commandMap = new HashMap<>();
    private static CommandHandler instance = new CommandHandler();

    public static CommandHandler getInstance() {
        return instance;
    }

    private CommandHandler() {

    }

    public void registerCommand(CommandBase command) {
        if (commandMap.containsKey(command.getName())) return;
        commandMap.put(command.getName(), command);
    }

    public void checkInput(String[] input) {
        List<String> command = Arrays.asList(input);
        for (String name : commandMap.keySet()) {
            if (command.get(0).toLowerCase().equals(name)) {
                List<String> args = new ArrayList<>();
                if (command.size() > 1) {
                    args = command.subList(1, command.size());
                }
                commandMap.get(name).processCommand(args);
                return;
            }
        }
        System.out.println("Unknown command");
    }

}
