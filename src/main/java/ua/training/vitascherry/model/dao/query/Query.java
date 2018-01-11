package ua.training.vitascherry.model.dao.query;

import java.util.Locale;
import java.util.ResourceBundle;

interface Query {
    ResourceBundle queries = ResourceBundle.getBundle("queries",
            //new Locale("uk_UA"));
            //new Locale("ru_RU"));
            Locale.ENGLISH);
}
