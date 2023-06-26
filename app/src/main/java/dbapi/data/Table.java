package dbapi.data;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private String name;
    private List<Column> columns;
    private String primaryKey;



    private Table(String name, List<Column> columns, String primaryKey) {
        this.name = name;
        this.columns = columns;
        this.primaryKey = primaryKey;
    }

    public String getName() {
        return name;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public String getPrimaryKey() { return primaryKey; }


    public static class Builder {
        private String name;
        private List<Column> columns = new ArrayList<>();
        private String primaryKey;

        public Builder Builder() {
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder addColumn(Column column) {
            this.columns.add(column);
            return this;
        }

        public Builder primaryKey(String primaryKey) {
            this.primaryKey = primaryKey;
            return this;
        }

        public Table build() {
            return new Table(this.name, this.columns, this.primaryKey);
        }
    }
}
