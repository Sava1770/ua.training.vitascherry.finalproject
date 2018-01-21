package ua.training.vitascherry.controller.command;

import java.util.Map;

public abstract class PostCommandsHolder {

    private static volatile Map<String, Command> commandMap;

    public static Map<String, Command> getInstance(){
        if (commandMap == null) {
            synchronized (PostCommandsHolder.class){
                if (commandMap == null){
                    commandMap = CommandFactory.getInstance().createPostCommands();
                }
            }
        }
        return commandMap;
    }
}
