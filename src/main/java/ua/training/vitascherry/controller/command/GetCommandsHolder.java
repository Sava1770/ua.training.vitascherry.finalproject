package ua.training.vitascherry.controller.command;

import java.util.Map;

public abstract class GetCommandsHolder {

    private static volatile Map<String, Command> commandMap;

    public static Map<String, Command> getInstance(){
        if (commandMap == null) {
            synchronized (GetCommandsHolder.class){
                if (commandMap == null){
                    commandMap = CommandFactory.getInstance().createGetCommands();
                }
            }
        }
        return commandMap;
    }
}
