package ua.training.vitascherry.model.dao.query;

import java.util.Map;

public class QueryBuilder {

    private StringBuilder builder;
    private Map<QueryOption, String> options;

    public QueryBuilder(String query, Map<QueryOption, String> options) {
        builder = new StringBuilder(query);
        this.options = options;
    }

    public String build() {
        options.forEach((option, value) -> builder.append(' ').append(option.name()).append(' ').append(value));
        return builder.toString();
    }
}
