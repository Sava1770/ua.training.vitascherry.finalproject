package ua.training.vitascherry.controller.command;

import java.util.Map;

public abstract class GetCommandMap {

    private static class GetCommandMapHolder {
        private static final Map<String, Command> HOLDER_INSTANCE =
            CommandFactory.getInstance().createGetCommands();
    }

    public static Map<String, Command> getInstance(){
        return GetCommandMapHolder.HOLDER_INSTANCE;
    }
}
