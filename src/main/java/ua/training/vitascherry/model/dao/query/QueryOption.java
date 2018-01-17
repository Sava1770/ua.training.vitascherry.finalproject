package ua.training.vitascherry.model.dao.query;

import java.util.LinkedHashMap;
import java.util.Map;

public enum QueryOption {
    LIMIT,
    OFFSET;

    public static Map<QueryOption, String> create(int limit, int offset) {
        Map<QueryOption, String> options = new LinkedHashMap<>(2);
        options.put(QueryOption.LIMIT, String.valueOf(limit));
        options.put(QueryOption.OFFSET, String.valueOf(offset));
        return options;
    }
}
