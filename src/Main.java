import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> list = stream.sorted(order)
                .collect(Collectors.toList());
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else
            minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
    }

    public static <T> void findEvenNumber(
            Stream<? extends T> stream,
            Predicate<? super T> even) {
        List<T> number = new ArrayList<>();
        stream.limit(10)
                .filter(even)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        System.out.println("Здача 1");
        List<Integer> integerList = Arrays.asList(555, -4, 83, -1, 10, 1000000, 0);
        List<Integer> integers = new ArrayList<>();

        Comparator<Integer> order = Integer::compare;
        BiConsumer<Integer, Integer> minMaxConsumer = (i, j) -> System.out.println("min=" + i + ", max= " + j);

        findMinMax(integerList.stream(), order, minMaxConsumer);
        findMinMax(integers.stream(), order, minMaxConsumer);

        System.out.println("Здача 2");
        Predicate<Integer> even = (n -> (n % 2 == 0));
        Stream<Integer> number = Stream.generate(() -> new Random().nextInt(100));
        findEvenNumber(number, even);
    }
}
