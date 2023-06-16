package dbapi;

import dbapi.data.Column;
import dbapi.data.Table;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public class SchemaParser {
    public List<Table> parse(Map<String, Object> obj) {
        Map<String, Object> schemasNode = (Map) obj.get("schemas");
        Map<String, Object> tablesNode = (Map) schemasNode.get("tables");
        List<Table> tables = new ArrayList<>();
        for (String tableName : tablesNode.keySet()) {
            Table.Builder tableBuilder = new Table.Builder();
            tableBuilder.name(tableName);
            Map<String, Object> tableNode = (Map) tablesNode.get(tableName);
            Map<String, Object> columnsNode = (Map) tableNode.get("columns");
            for (String columnName : columnsNode.keySet()) {
                Map<String, Object> columnNode = (Map) columnsNode.get(columnName);
                Column.Builder columnBuilder = new Column.Builder();
                columnBuilder.name(columnName);
                columnBuilder.type((String) columnNode.get("type"));
                columnBuilder.nullable(Boolean.parseBoolean((String) columnNode.get("nullable")));
                Column column = columnBuilder.build();
                tableBuilder.addColumn(column);
            }
            tableBuilder.primaryKey((String) tableNode.keySet().stream().toList().get(1));
            tables.add(tableBuilder.build());
        }
        return tables;
    }
}
