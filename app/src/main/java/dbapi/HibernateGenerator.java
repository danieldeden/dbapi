package dbapi;

import dbapi.data.Column;
import dbapi.data.Table;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class HibernateGenerator {

    public void writeHibernateFile(String javaPackage, String javaFullPath, Table table){
        try (FileWriter hibernateWriter = new FileWriter(javaFullPath + "/model/" + table.getName() + ".java")) {

            // Start
            String writeHibernate =
                    "package " + javaPackage + ".model;" +
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
                    "@Table(name = \"" + table.getName() + "\")\n" +
                    "@SuppressWarnings(\"NullAway\")\n" +
                    "public class " + table.getName() + " {" +
                    "\n\n" +
                    "   @Id\n";

            hibernateWriter.write(writeHibernate);


            // Annotations and variables
            for (Column columns : table.getColumns()) {
                String generated = "";
                String columnType = columns.getType();
                String columnLob = "";
                if (Objects.equals(columns.getGenerated(), "onCreate")) {
                    generated = "   @CreationTimestamp\n";
                }
                if (Objects.equals(columnType, "TEXT")){
                    columnType = "String";
                    columnLob = "   @Lob\n";
                }
                else if (Objects.equals(columnType, "TIMESTAMP")){
                    columnType = "OffsetDateTime";
                }
                String columnAnnotation = generated + columnLob + "   @Column(name = \"" + columns.getName() + "\", nullable = " + columns.isNullable() + ")\n";
                String columnVariable = "   private " + columnType + " " + columns.getName() + ";\n\n";
                hibernateWriter.write(columnAnnotation + columnVariable);
            }


            // Constructors
            hibernateWriter.write("   public " + table.getName() + "() {\n   }" +
                    "\n\n" +
                    "   @SuppressWarnings(\"MissingJavadocMethod\")\n" +
                    "   public " + table.getName() + "(");

            var filteredColumns = table.getColumns().stream().filter(x -> x.getGenerated() == null).toList();
            for (Column columns : filteredColumns){
                var columnType = "UUID";
                if ("TEXT".equals(columns.getType())) {
                    columnType = "String";
                }
                if ("TIMESTAMP".equals(columns.getType())) {
                    columnType = "OffsetDateTime";
                }
                if (filteredColumns.indexOf(columns) == filteredColumns.size() - 1){
                    hibernateWriter.write(columnType + " " + columns.getName() + ") {\n");         // Ska createdAt vara med????
                }
                else {
                    hibernateWriter.write(columnType + " " + columns.getName() + ", ");
                }
            }


            // Variables
            for (Column columns : filteredColumns) {
                hibernateWriter.write("      this." + columns.getName() + " = " + columns.getName() + ";\n");
            }
            hibernateWriter.write("   }\n");


            // Getters and Setters
            for (Column columns : table.getColumns()){
                String columnType = columns.getType();
                if (Objects.equals(columnType, "TEXT")){
                    columnType = "String";
                }
                else if (Objects.equals(columnType, "TIMESTAMP")){
                    columnType = "OffsetDateTime";
                }

                hibernateWriter.write("\n   public " + columnType +
                        " get" + columns.getName().substring(0, 1).toUpperCase() + columns.getName().substring(1) + "() {\n" +
                        "      return " + columns.getName() + ";\n   }\n");

                if (!Objects.equals(table.getPrimaryKey(), columns.getName())){
                    hibernateWriter.write("\n   public void" +
                            " set" + columns.getName().substring(0, 1).toUpperCase() + columns.getName().substring(1) + "(" + columnType + " " + columns.getName() + ") {\n" +
                            "      this." + columns.getName() + " = " + columns.getName() + ";\n   }\n");
                }
            }

            hibernateWriter.write("}\n");
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
