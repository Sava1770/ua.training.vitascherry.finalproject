package ua.training.vitascherry.model.dao.util;

import java.util.Map;

public class GenericDaoUtil {
    public static <K, T> T getUniqueValue(Map<K, T> values, K key, T value) {
        values.putIfAbsent(key, value);
        return values.get(key);
    }
}
