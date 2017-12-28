package ua.training.vitascherry.model.utils;

import java.util.Map;

public class GenericUtils {
    public static <K, T> T getUniqueValue(Map<K, T> values, K key, T value) {
        values.putIfAbsent(key, value);
        return values.get(key);
    }
}
