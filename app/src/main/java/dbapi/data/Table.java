package dbapi.data;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private String name;
    private List<Column> columns;

    private Table(String name, List<Column> columns) {
        this.name = name;
        this.columns = columns;
    }

    public String getName() {
        return name;
    }

    public List<Column> getColumns() {
        return columns;
    }

    @Override
    public String toString() {
        return "Table{" +
                "name='" + name + '\'' +
                ", columns=" + columns +
                '}';
    }

    public static class Builder {
        private String name;
        private List<Column> columns = new ArrayList<>();

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

        public Table build() {
            return new Table(this.name, this.columns);
        }
    }
}
