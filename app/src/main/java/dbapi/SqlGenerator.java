package dbapi;

import dbapi.data.Table;

import java.io.*;
import java.util.List;

public class SqlGenerator {

    public void writeDatabaseFile(List<Table> tables) throws FileNotFoundException {
        /*
        "CREATE SEQUENCE public.hibernate_sequence;" +
        "\n\n" + "CREATE TABLE " + tableName.keySet().stream().toList().get(0) + " (\n" +
        columns.keySet().stream().toList().get(0) + " " + uuid.get("type") + " " + uuid.get("nullable") + ",\n" +
        columns.keySet().stream().toList().get(1) + " " + scenarioID.get("type") + " " + scenarioID.get("nullable") + ",\n" +
        columns.keySet().stream().toList().get(2) + " " + providerUUID.get("type") + " " + providerUUID.get("nullable") +  ",\n" +
        columns.keySet().stream().toList().get(3) + " " + consumerUUID.get("type") + " " + consumerUUID.get("nullable") +  ",\n" +
        columns.keySet().stream().toList().get(4) + " " + createdBy.get("type") + " " + createdBy.get("nullable") +  ",\n" +
        columns.keySet().stream().toList().get(5) + " " + createdAt.get("type") + " with time zone " + createdAt.get("nullable") +  ",\n" +
        "CONSTRAINT " + connections.keySet().stream().toList().get(1) + " PRIMARY KEY (" + connections.get("primaryKey") + ")\n" +
        ");";
        */
        try (FileWriter databaseWriter = new FileWriter("V1__init.sql")) {
            String table = "";
            String columnName = "";
            String columnType = "";
            String columnNullable = "";
            String saveAsPrimaryKey = "";

            databaseWriter.write("CREATE SEQUENCE public.hibernate_sequence;");

            // Loops through all the tables
            for (int tableNames = 0; tableNames < tables.size(); tableNames++) {
                table = "\n\nCREATE TABLE " + tables.get(tableNames).getName() + " (\n";
                databaseWriter.write(table);

                // Loops through the columns of the tables
                for (int amountOfColumns = 0; amountOfColumns < tables.get(tableNames).getColumns().size(); amountOfColumns++) {
                    columnName = tables.get(tableNames).getColumns().get(amountOfColumns).getName();
                    if (amountOfColumns == 0){
                        saveAsPrimaryKey = columnName;
                    }
                    columnType = " " + tables.get(tableNames).getColumns().get(amountOfColumns).getType();
                    columnNullable = " " + tables.get(tableNames).getColumns().get(amountOfColumns).isNullable();
                    databaseWriter.write("  " + columnName + columnType + columnNullable + "\n");
                }
                databaseWriter.write("  CONSTRAINT " + tables.get(tableNames).getPrimaryKey() + " PRIMARY KEY (" + saveAsPrimaryKey + ")\n);");
            }
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

}
