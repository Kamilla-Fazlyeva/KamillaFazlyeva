package hwjdi;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import hwjdi.entities.MetalsAndColors;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Map;

import static hwjdi.enums.DatasetPath.DATASET_PATH;

public class MetalsAndColorsDataProvider {

    @DataProvider
    public Object[][] testData() throws FileNotFoundException {

        JsonElement element = new JsonParser().parse(new FileReader(
                DATASET_PATH.getValue()));

        Type mapType = new TypeToken<Map<String, MetalsAndColors>>(){}.getType();
        Map<String, MetalsAndColors> jsonData = new Gson().fromJson(element, mapType);
        Object[][] testData = new Object[jsonData.size()][1];
        int i = 0;
        for (String entry : jsonData.keySet()) {
            testData[i++][0] = jsonData.get(entry);
        }
        return testData;
    }
}
