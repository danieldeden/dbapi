package dbapi;

import dbapi.data.Column;
import dbapi.data.Table;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class HibernateGenerator {

    public void writeHibernateFile(Table table){
        try (FileWriter hibernateWriter = new FileWriter(table.getName() + ".java")) {

            // Start
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
                    "@Table(name = \"" + table.getName() + "\")\n" +
                    "@SuppressWarnings(\"NullAway\")\n" +
                    "public class " + table.getName() + " {" +
                    "\n\n" +
                    "   @Id\n";

            hibernateWriter.write(writeHibernate);


            // Annotations and variables
            for (Column columns : table.getColumns()) {
                String columnType = columns.getType();
                String columnLob = "";
                String columnTime = "";
                if (Objects.equals(columnType, "TEXT")){            // Ska man ha så här????
                    columnType = "String";
                    columnLob = "   @Lob\n";
                }
                else if (Objects.equals(columnType, "TIMESTAMP")){
                    columnType = "OffsetDateTime";
                    columnTime = "   @CreationTimestamp\n";
                }
                String columnAnnotation = columnLob + columnTime + "   @Column(name = \"" + columns.getName() + "\", nullable = " + columns.isNullable() + ")\n";
                String columnVariable = "   private " + columnType + " " + columns.getName() + ";\n\n";
                hibernateWriter.write(columnAnnotation + columnVariable);
            }


            // Constructors
            hibernateWriter.write("   public " + table.getName() + "() {\n   }" +
                    "\n\n" +
                    "   @SuppressWarnings(\"MissingJavadocMethod\")\n" +
                    "   public " + table.getName() + "(");

            for (Column columns : table.getColumns()){
                if (table.getColumns().indexOf(columns) == table.getColumns().size() - 1){
                    hibernateWriter.write(columns.getType() + " " + columns.getName() + ") {\n");         // Ska createdAt vara med????
                }
                else {
                    hibernateWriter.write(columns.getType() + " " + columns.getName() + ", ");
                }
            }


            // Variables
            for (Column columns : table.getColumns()) {
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
