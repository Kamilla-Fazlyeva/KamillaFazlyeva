package hwjdi.entities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UserProperties extends Properties{

    protected static UserProperties properties;

    public static UserProperties getUserProperties() {

        if (properties == null) {

            properties = new UserProperties();

            try (InputStream input = new FileInputStream("src/main/resources/hwjdi/config.properties")) {
                properties.load(input);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties;
    }
}
