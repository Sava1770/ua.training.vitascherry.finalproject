package ua.training.vitascherry.controller.command;

import ua.training.vitascherry.controller.command.impl.HttpCommandFactory;

import java.util.Map;

public abstract class CommandFactory {

    private static volatile CommandFactory commandFactory;

    public abstract Map<String, Command> createGetCommands();

    public abstract Map<String, Command> createPostCommands();

    public static CommandFactory getInstance(){
        if (commandFactory == null) {
            synchronized (CommandFactory.class){
                if (commandFactory == null){
                    commandFactory = new HttpCommandFactory();
                }
            }
        }
        return commandFactory;
    }
}
