package hwjdi.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
public class MetalsAndColors {

    private int[] summary;
    private String[] elements;
    private String color;
    private String metals;
    private String[] vegetables;

    @Override
    public String toString() {
        return String.format("Summary: %s\nElements: %s\nColor: %s\nMetal: %s\nVegetables: %s",
                Arrays.stream(summary).sum(),
        Arrays.toString(elements), color, metals,
                Arrays.toString(vegetables));
    }
}
