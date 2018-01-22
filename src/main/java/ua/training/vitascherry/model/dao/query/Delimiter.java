package ua.training.vitascherry.model.dao.query;

public class Delimiter {

    private final StringBuilder builder;

    public Delimiter(String query) {
        this.builder = new StringBuilder(query);
    }

    public Delimiter limit(int limit) {
        builder.append(' ').append("LIMIT").append(' ').append(limit);
        return this;
    }

    public Delimiter offset(int offset) {
        builder.append(' ').append("OFFSET").append(' ').append(offset);
        return this;
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
