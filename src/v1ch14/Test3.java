package v1ch14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.*;

public class Test3 {
    public static void main(String[] args) {
        IntStream.of(120, 410, 85, 32, 314, 12)
                .filter(x -> x < 300)
                .map(x -> x + 11)
                .limit(3)
                .forEach(System.out::println);

        System.out.println("------------------------------------------------------------------------------------------");

        List<String> list = Arrays.asList("afasd00", "fasdfasd");
        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);
        //stream.filter(s -> s.contains("Stream API"));
        //stream.forEach(System.out::println);

        System.out.println("------------------------------------------------------------------------------------------");
        long timeStart = System.currentTimeMillis();
        ////////////////////////////////////////////

        IntStream.range(0, 10).forEach(System.out::println);

        ////////////////////////////////////////////
        long timeEnd = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (timeEnd - timeStart));

        System.out.println("------------------------------------------------------------------------------------------");
        int s = IntStream.range(0, 10)
                        //.parallel()
                        .map(x -> x * 10)
                        .sum();
        System.out.println(s);

        System.out.println("------------------------------------------------------------------------------------------");
        final List<Integer> ints = new ArrayList<>();
        IntStream.range(0, 1000000)
                //.parallel()
                .forEach(i -> ints.add(i));
        System.out.println(ints.size());

        System.out.println("------------------------------------------------------------------------------------------");
        String str = Math.random() > 0.5 ? "I'm feeling lucky" : null;
        Stream.ofNullable(str)
                .forEach(System.out::println);

        System.out.println("------------------------------------------------------------------------------------------");
        Stream.iterate(2l, x -> x*10)
                .limit(10)
                .forEach(System.out::println);

        Stream.iterate(2, x -> x < 100, x -> x + 6)
                .forEach(System.out::println);

        Collection col = Stream.concat( Stream.of(1, 2, 3),
                                        Stream.of(4, 5, 6))
                                        .collect(Collectors.toList());

        System.out.println(col.toString());

        System.out.println("------------------------------------------------------------------------------------------");
        IntStream.range(0, 10).mapToObj(x->String.valueOf(x) + " ").forEach(System.out::print);
        System.out.println();
        IntStream.rangeClosed(0, 10).mapToObj(x->String.valueOf(x) + " ").forEach(System.out::print);
        System.out.println();

        System.out.println("------------------------------------------------------------------------------------------");
        IntStream.range(0, 100000000)
                .sorted()
                .limit(3)
                .forEach(System.out::println);

        IntStream.concat(
                IntStream.range(0, 10000),
                IntStream.of(-1, -2))
                .sorted()
                .limit(3)
                .forEach(System.out::println);

        System.out.println("------------------------------------------------------------------------------------------");
        Stream.of(2, 1, 8, 1, 3, 2)
                .distinct()
                .forEach(System.out::println);

        IntStream.concat(
                IntStream.rangeClosed(2, 5),
                IntStream.range(0, 4))
                .distinct()
                .forEach(System.out::print);



    }
}
