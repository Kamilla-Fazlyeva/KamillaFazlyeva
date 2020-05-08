package hwapi.utils;

import lombok.SneakyThrows;
import java.util.Properties;

public class TestProperties {

    @SneakyThrows
    public static Properties getProperties() {
        Properties properties = new Properties();
        String propertyPath = "hwapi/test.properties";
        properties.load(TestProperties.class.getClassLoader().getResourceAsStream(propertyPath));
        return properties;
    }
}
