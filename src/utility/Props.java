package utility;

import java.io.FileReader;
import java.util.Properties;

public class Props {
    public static String getProperty(String key) {
        FileReader reader;
        Properties properties = new Properties();
        try {
            reader = new FileReader("app.properties");
            properties.load(reader);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return properties.getProperty(key);
    }
}
