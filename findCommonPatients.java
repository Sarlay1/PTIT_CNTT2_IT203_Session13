import java.util.ArrayList;
import java.util.List;

public class findCommonPatients {

    public static <T> List<T> findCommonPatients(List<T> listA, List<T> listB) {
        List<T> result = new ArrayList<>();

        for (T item : listA) {
            if (listB.contains(item)) {
                result.add(item);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        List<Integer> a1 = List.of(101, 102, 105);
        List<Integer> b1 = List.of(102, 105, 108);
        System.out.println(findCommonPatients(a1, b1));

        List<String> a2 = List.of("DN01", "DN02", "DN03");
        List<String> b2 = List.of("DN02", "DN04");
        System.out.println(findCommonPatients(a2, b2));
    }
}