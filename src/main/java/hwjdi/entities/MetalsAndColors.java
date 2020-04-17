package hwjdi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class MetalsAndColors {

    private int[] summary;
    private String[] elements;
    private String color;
    private String metal;
    private String[] vegetables;

}
