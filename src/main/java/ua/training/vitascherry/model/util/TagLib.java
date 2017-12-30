package ua.training.vitascherry.model.util;

import java.util.Collection;

public class TagLib {
    public static <T> boolean contains(Collection<T> entities, T entity) {
        return entities.contains(entity);
    }
}
