package dbapi;

import dbapi.data.Table;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class RepositoryGenerator {
    public void writeRepositoryFile(List<Table> tables){
        /*
        "package se.bnearit.connectionitem.service;" +
        "\n\n" +
        "import java.util." + uuid.get("type") + ";\n" +
        "import org.springframework.data.repository.CrudRepository;\n" +
        "import se.bnearit.connectionitem.model." + entity.keySet().stream().toList().get(0) + ";" +
        "\n\n" +
        "\n" +
        "  Interface to interact with the database table for {@link Connection}\n" +
        " \n" +
        "  @author andreas.everos\n" +
        " \n" +
        "public interface ConnectionRepository extends CrudRepository<" + entity.keySet().stream().toList().get(0) + "," + uuid.get("type") + "> {\n}";
        */

        try (FileWriter repositoryWriter = new FileWriter("ConnectionRepository.Java")){
            repositoryWriter.write("package se.bnearit.connectionitem.service;\n\n" +
                    "import java.util.UUID;\n" +
                    "import org.springframework.data.repository.CrudRepository;\n" +
                    "import se.bnearit.connectionitem.model." + tables.get(0).getEntity() + ";\n\n" +
                    "/**\n" +
                    " * Interface to interact with the database table for {@link " + tables.get(0).getEntity() + "}\n" +
                    " *\n" +
                    " * @author andreas.everos\n" +
                    " */\n" +
                    "public interface ConnectionRepository extends CrudRepository<" + tables.get(0).getEntity() + ", UUID> {\n}");

            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
