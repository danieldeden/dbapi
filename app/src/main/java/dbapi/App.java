/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package dbapi;

import dbapi.data.Table;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) throws IOException {

        Yaml yaml = new Yaml();
        InputStream input = new FileInputStream("input.yaml");

        Map<String, Object> obj = (Map) yaml.load(input);

        /*
        Map<String, Object> schemas = (Map) obj.get("schemas");
        Map<String, Object> entity = (Map) schemas.get("entity");
        Map<String, Object> tableName = (Map) schemas.get("tables");
        Map<String, Object> connections = (Map) tableName.get("Connection");
        Map<String, Object> columns = (Map) connections.get("columns");
        Map<String, Object> uuid = (Map) columns.get("uuid");
        Map<String, Object> scenarioID = (Map) columns.get("scenarioID");
        Map<String, Object> providerUUID = (Map) columns.get("providerUUID");
        Map<String, Object> consumerUUID = (Map) columns.get("consumerUUID");
        Map<String, Object> createdBy = (Map) columns.get("createdBy");
        Map<String, Object> createdAt = (Map) columns.get("createdAt");
        */

        String javaPackage = (String) obj.get("javaPackage");
        /*
        String javaPackagePath = javaPackage.replace(".", "/");
        String javaSrcPath = (String) obj.get("javaSrcPath");
        String javaFullPath = javaSrcPath + "/" + javaPackagePath;
        */
        SchemaParser sp = new SchemaParser();
        List<Table> tables = sp.parse(obj);

        SqlGenerator sqlGenerator = new SqlGenerator();

        RepositoryGenerator repositoryGenerator = new RepositoryGenerator();

        HibernateGenerator hibernateGenerator = new HibernateGenerator();

        sqlGenerator.writeDatabaseFile(tables);

        for (Table table : tables) {
            repositoryGenerator.writeRepositoryFile(javaPackage, table);
            hibernateGenerator.writeHibernateFile(table);
        }

        /*
        System.out.println(schemas.keySet());
        System.out.println(tableName.keySet());
        Map<String, Object> con = (Map) tableName.get(tableName.keySet().stream().toList().get(0));
        System.out.println(con);
        System.out.println(tableName.keySet().stream().toList().get(0));
        System.out.println(tableName.keySet().stream().toList().get(1));
        List<String> l = (List) obj.get("test2");
        System.out.println(obj);
        System.out.println(l.get(0));
        System.out.println(l.get(1));

        Yaml yaml2 = new Yaml(new Constructor(Customer.class));
        InputStream input2 = new FileInputStream("input1.yaml");
        Customer obj2 = (Customer) yaml2.load(input2);
        System.out.println(obj2.name);
        System.out.println(obj2.age);
         */
    }
}
