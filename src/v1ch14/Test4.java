package v1ch14;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test4 {
    public static void main(String[] args) {
        System.out.println("------------------------------------------------------------------------------------------");
        Stream.of(0, 3, 0, 0, 5)
                .peek(x -> System.out.println(x + "!!!!!!!!"))
                .distinct()
                .peek(x -> System.out.format("after distinct: %d%n", x))
                .map(x -> x * x)
                //.forEach(x -> System.out.format("after map: %d%n", x))
                .forEach(System.out::println)
                //.collect(Collectors.toList())
                ;

        System.out.println("------------------------------------------------------------------------------------------");
        Stream.of(1, 2, 3, 4, 2, 5)
                .takeWhile(x -> x < 3)
                .forEach(System.out::println);

        System.out.println("------------------------------------------------------------------------------------------");
        DoubleStream.of(0.1, Math.PI)
                .boxed()
                .map(Object::getClass)
                .forEach(System.out::println);

        System.out.println("------------------------------------------------------------------------------------------");
        Stream.of(120, 410, 85, 32, 314, 12)
                .forEach(x -> System.out.format("%s, ", x));
        System.out.println();

        System.out.println("------------------------------------------------------------------------------------------");
        long count = IntStream.range(0, 10)
                .flatMap(x -> IntStream.range(0, x))
                .count();
        System.out.println(count);

        System.out.println("------------------------------------------------------------------------------------------");
        List<String> list = Stream.of("a", "b", "c", "d")
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        System.out.println(list.toString());

        System.out.println("------------------------------------------------------------------------------------------");
        String[] elements = Stream.of("a", "b", "c", "d")
                .toArray(String[]::new);
        Arrays.toString(elements);

        System.out.println("------------------------------------------------------------------------------------------");
        int sum = Stream.of(1, 2, 3, 4, 5)
                .reduce(10, (acc, x) -> acc + x);
        System.out.println(sum);

        System.out.println("------------------------------------------------------------------------------------------");
        Optional<Integer> result = Stream.<Integer>empty()
                .reduce((acc, x) -> acc + x);
        System.out.println(result.isPresent());

        Optional<Integer> summ = Stream.of(1, 2, 3, 4, 5)
                .reduce((acc, x) -> acc + x);
        System.out.println(summ.get());

        System.out.println("------------------------------------------------------------------------------------------");
        int min = Stream.of(20, 11, 45, 78, 13)
                .min(Integer::compare).get();
        System.out.println(min);

        int max = Stream.of(20, 11, 45, 78, 13)
                .max(Integer::compare).get();
        System.out.println(max);

        System.out.println("------------------------------------------------------------------------------------------");
        Set<Integer> set = Stream.of(1, 2, 3, 4, 5, 0)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println(set.toString());

        System.out.println("------------------------------------------------------------------------------------------");
        Map<Integer, Integer> map1 = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.toMap(
                        Function.identity(),
                        Function.identity()
                ));
        System.out.println(Arrays.asList(map1));

        Map<Character, String> map2 = Stream.of(50, 54, 55)
                .collect(Collectors.toMap(
                        i -> (char) i.intValue(),
                        i -> String.format("<%d>", i)
                ));
        System.out.println(Arrays.asList(map2));

        System.out.println("------------------------------------------------------------------------------------------");
        String s1 = Stream.of("a", "b", "c", "d")
                .collect(Collectors.joining());
        System.out.println(s1);

        String s2 = Stream.of("a", "b", "c", "d")
                .collect(Collectors.joining(", "));
        System.out.println(s2);




    }
}
