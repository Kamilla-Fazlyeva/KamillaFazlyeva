package hw4.builder;

import java.util.List;

public class MetalAndColorData {

    private List<String> summary;
    private List<String> elements;
    private String colors;
    private String metals;
    private List<String> vegetables;

    public MetalAndColorData(List<String> summary, List<String> elements, String colors,
                              String metals, List<String> vegetables) {
        this.summary = summary;
        this.elements = elements;
        this.colors = colors;
        this.metals = metals;
        this.vegetables = vegetables;
    }

    public List<String> getSummary() {
        return summary;
    }

    public List<String> getElements() {
        return elements;
    }

    public String getColors() {
        return colors;
    }

    public String getMetals() {
        return metals;
    }

    public List<String> getVegetables() {
        return vegetables;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private List<String> summary;
        private List<String> elements;
        private String colors;
        private String metals;
        private List<String> vegetables;

        private MetalAndColorData metalAndColorData;

        public Builder() {
        }

        public Builder setSummary(List<String> summary) {
            this.summary = summary;
            return this;
        }

        public Builder setElements(List<String> elements) {
            this.elements = elements;
            return this;
        }

        public Builder setColors(String colors) {
            this.colors = colors;
            return this;
        }

        public Builder setMetals(String metals) {
            this.metals = metals;
            return this;
        }

        public Builder setVegetables(List<String> vegetables) {
            this.vegetables = vegetables;
            return this;
        }

        public MetalAndColorData build() {
            return new MetalAndColorData(summary, elements, colors, metals, vegetables);
        }
    }
}
