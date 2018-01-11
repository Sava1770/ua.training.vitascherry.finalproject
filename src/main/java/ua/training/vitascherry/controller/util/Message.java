package ua.training.vitascherry.controller.util;

import java.util.Locale;
import java.util.ResourceBundle;

public interface Message {
    ResourceBundle messages = ResourceBundle.getBundle("messages",
    //new Locale("uk_UA"));
    //new Locale("ru_RU"));
    Locale.ENGLISH);

    String INVALID_CREDENTIALS = messages.getString("invalid.credentials");
    String NOT_UNIQUE_EMAIL = messages.getString("email.not.unique");
    String ENTITY_NOT_CREATED = messages.getString("entity.not.created");
}
