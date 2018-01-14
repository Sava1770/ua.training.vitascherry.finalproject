package ua.training.vitascherry.model.dao.util;

import java.util.Map;

public class UniqueValueMapper {
    public static <K, T> T extractUniqueValue(Map<K, T> values, K key, T value) {
        return values.putIfAbsent(key, value);
    }
}
