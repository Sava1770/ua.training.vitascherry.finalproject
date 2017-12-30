package ua.training.vitascherry.model.dao.util;

import java.util.Map;

public class EntityMapper {
    public static <K, T> T extractUniqueValue(Map<K, T> values, K key, T value) {
        values.putIfAbsent(key, value);
        return values.get(key);
    }
}
