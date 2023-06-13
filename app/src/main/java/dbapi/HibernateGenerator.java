package dbapi;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class HibernateGenerator {

    public void writeHibernateFile(Map<String, Object> tableName,
                                   Map<String, Object> columns,
                                   Map<String, Object> uuid,
                                   Map<String, Object> scenarioID,
                                   Map<String, Object> providerUUID,
                                   Map<String, Object> consumerUUID,
                                   Map<String, Object> createdBy,
                                   Map<String, Object> createdAt,
                                   Map<String, Object> entity){

        String writeHibernate =
                "package se.bnearit.connectionitem.model;" +
                "\n\n" +
                "import java.time.OffsetDateTime;\n" +
                "import java.util.UUID;\n" +
                "import javax.persistence.Column;\n" +
                "import javax.persistence.Entity;\n" +
                "import javax.persistence.Id;\n" +
                "import javax.persistence.Lob;\n" +
                "import javax.persistence.Table;\n" +
                "import org.hibernate.annotations.CreationTimestamp;" +
                "\n\n" +
                "/**\n" +
                " * Model representing the connection in the database.\n" +
                " *\n" +
                " * @author andreas.everos\n" +
                " */\n" +
                "@Entity\n" +
                "@Table(name = \"" + tableName.keySet().stream().toList().get(0) + "\")\n" +
                "@SuppressWarnings(\"NullAway\")\n" +
                "public class " + entity.keySet().stream().toList().get(0) + " {" +
                "\n\n" +
                "   @Id\n" +
                "   @Column(name = \"" + columns.keySet().stream().toList().get(0) + "\", ";



                //tableName.keySet().stream().toList().get(0);

        try (FileWriter hibernateWriter = new FileWriter("Connection.java")) {
            hibernateWriter.write(writeHibernate);
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
