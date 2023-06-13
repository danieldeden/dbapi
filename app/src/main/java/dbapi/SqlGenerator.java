package dbapi;

import java.io.*;
import java.util.Map;

public class SqlGenerator {

    public void writeDatabaseFile(Map<String, Object> tableName,
                                  Map<String, Object> connections,
                                  Map<String, Object> columns,
                                  Map<String, Object> uuid,
                                  Map<String, Object> scenarioID,
                                  Map<String, Object> providerUUID,
                                  Map<String, Object> consumerUUID,
                                  Map<String, Object> createdBy,
                                  Map<String, Object> createdAt) throws FileNotFoundException {

        String writeDatabase =
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

        try (FileWriter databaseWriter = new FileWriter("V1__init.sql")) {
            databaseWriter.write(writeDatabase);
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

}
