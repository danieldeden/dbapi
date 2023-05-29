/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package dbapi;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) throws FileNotFoundException {
        Yaml yaml = new Yaml();
        InputStream input = new FileInputStream("input.yaml");
        Map<String, Object> obj = (Map) yaml.load(input);
        Map<String, Object> schemas = (Map) obj.get("schemas");
        System.out.println(schemas.keySet());
        List<String> l = (List) obj.get("test2");
        System.out.println(obj);
        System.out.println(l.get(0));
        System.out.println(l.get(1));

        Yaml yaml2 = new Yaml(new Constructor(Customer.class));
        InputStream input2 = new FileInputStream("input1.yaml");
        Customer obj2 = (Customer) yaml2.load(input2);
        System.out.println(obj2.name);

    }
}