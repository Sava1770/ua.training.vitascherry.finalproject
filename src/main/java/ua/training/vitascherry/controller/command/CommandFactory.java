package ua.training.vitascherry.controller.command;

import ua.training.vitascherry.controller.command.impl.HttpCommandFactory;

import java.util.Map;

public abstract class CommandFactory {

    public abstract Map<String, Command> createGetCommands();

    public abstract Map<String, Command> createPostCommands();

    private static class CommandFactoryHolder {
        private static final CommandFactory HOLDER_INSTANCE = new HttpCommandFactory();
    }

    public static CommandFactory getInstance(){
        return CommandFactoryHolder.HOLDER_INSTANCE;
    }
}
