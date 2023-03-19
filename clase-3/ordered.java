import java.util.Arrays;
import java.util.stream.Collectors;

public class ordered {
    public static void main(String[] args) {

        Integer[] arr = {34, 56, 12};
        boolean ascending = false;

        if (ascending) {
            Arrays.sort(arr);
            System.out.println("Vector en orden ascendente: " + Arrays.asList(arr));
        } else {
            Arrays.sort(arr, new DescendingComparator());
            System.out.println("Vector in descending order: " + Arrays.stream(arr).map(String::valueOf).collect(Collectors.joining(", ")));
        }
    }
}

class DescendingComparator implements java.util.Comparator<Integer> {
    public int compare(Integer a, Integer b) {
        return b - a;
    }
}
