package hwapi.service;

import static hwapi.utils.TestProperties.getProperties;

public class URI {

    public static final String BASE_URI = getProperties().getProperty("URI");
    public static final String CHECK_TEXT = "/checkText";
    public static final String CHECK_TEXTS = "/checkTexts";
}
