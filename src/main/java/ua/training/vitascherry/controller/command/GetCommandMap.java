package ua.training.vitascherry.controller.command;

import java.util.Map;

public abstract class GetCommandMap {

    private static volatile Map<String, Command> commandMap;

    public static Map<String, Command> getInstance(){
        if (commandMap == null) {
            synchronized (GetCommandMap.class){
                if (commandMap == null){
                    commandMap = CommandFactory.getInstance().createGetCommands();
                }
            }
        }
        return commandMap;
    }
}
