package v1ch14;

import java.util.Set;
import java.util.TreeSet;

public class Test1 {
    public static void main(String[] args) {

        Set set = new TreeSet();
        for (int i=0; i<100; i++){
            //System.out.println(Math.random());
            set.add(Math.random());
        }

        //System.out.println(set.toString());
        set.stream().forEach(System.out::println);
    }
}
