package dbapi.data;

public class Column {
    private String name;
    private String type;
    private String generated;
    private boolean nullable;

    private Column(String name, String type, String generated, boolean nullable) {
        this.name = name;
        this.type = type;
        if (generated == null || "".equals(generated)) {
            this.generated = null;
        } else {
            this.generated = generated;
        }
        this.nullable = nullable;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getGenerated() {
        return generated;
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
        private String generated;
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

        public Builder generated(String generated) {
            this.generated = generated;
            return this;
        }

        public Builder nullable(boolean nullable) {
            this.nullable = nullable;
            return this;
        }

        public Column build() {
            return new Column(this.name, this.type, this.generated, this.nullable);
        }
    }
}
