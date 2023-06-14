package dbapi.data;

public class Column {
    private String name;
    private String type;
    private boolean nullable;

    private Column(String name, String type, boolean nullable) {
        this.name = name;
        this.type = type;
        this.nullable = nullable;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public boolean isNullable() {
        return nullable;
    }

    @Override
    public String toString() {
        return "Column{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", nullable=" + nullable +
                '}';
    }

    public static class Builder {
        private String name;
        private String type;
        private boolean nullable;

        public Builder Builder() {
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder nullable(boolean nullable) {
            this.nullable = nullable;
            return this;
        }

        public Column build() {
            return new Column(this.name, this.type, this.nullable);
        }
    }
}
