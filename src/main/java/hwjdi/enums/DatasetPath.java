package hwjdi.enums;

public enum DatasetPath {

    DATASET_PATH("src/test/resources/hwjdi/JDI_ex8_metalsColorsDataSet.json");

    final String value;

    DatasetPath(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
