package v1ch14;

import java.util.Comparator;
import java.util.Random;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class ComparatorTest implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        int random1, random2;
        Random rn = new Random();
        random1 = rn.nextInt(o1+100);
        random2 = rn.nextInt(o2+100);
        if(random1 == random2) {
            return 0;
        } else if (random1 > random2) {
            return -1;
        } else {
            return 1;
        }

    }

    @Override
    public Comparator<Integer> reversed() {
        return null;
    }

    @Override
    public Comparator<Integer> thenComparing(Comparator<? super Integer> other) {
        return null;
    }

    @Override
    public <U> Comparator<Integer> thenComparing(Function<? super Integer, ? extends U> keyExtractor, Comparator<? super U> keyComparator) {
        return null;
    }

    @Override
    public <U extends Comparable<? super U>> Comparator<Integer> thenComparing(Function<? super Integer, ? extends U> keyExtractor) {
        return null;
    }

    @Override
    public Comparator<Integer> thenComparingInt(ToIntFunction<? super Integer> keyExtractor) {
        return null;
    }

    @Override
    public Comparator<Integer> thenComparingLong(ToLongFunction<? super Integer> keyExtractor) {
        return null;
    }

    @Override
    public Comparator<Integer> thenComparingDouble(ToDoubleFunction<? super Integer> keyExtractor) {
        return null;
    }

}
