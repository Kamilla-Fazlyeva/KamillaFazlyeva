package hw4.utils;

import java.util.ArrayList;
import java.util.List;

public class SummarySum {

    public SummarySum() {

    }

    public String summarySum(List<String> numbers) {
        List<Integer> ints = new ArrayList<>();
        for (String number : numbers) {
            ints.add(Integer.parseInt(number));
        }
        return String.valueOf(ints.stream().mapToInt(Integer::intValue).sum());
    }
}
