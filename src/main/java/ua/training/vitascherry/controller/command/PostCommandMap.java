package ua.training.vitascherry.controller.command;

import java.util.Map;

public abstract class PostCommandMap {

    private static class PostCommandMapHolder {
        private static final Map<String, Command> HOLDER_INSTANCE =
            CommandFactory.getInstance().createPostCommands();
    }

    public static Map<String, Command> getInstance(){
        return PostCommandMapHolder.HOLDER_INSTANCE;
    }
}
