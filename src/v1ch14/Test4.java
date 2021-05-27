package v1ch14;

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


    }
}
