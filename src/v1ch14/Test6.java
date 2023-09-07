package v1ch14;

import java.util.*;
import java.util.stream.Collectors;

public class Test6 {
    public static void main(String[] args) {
        UUID uuid;
        String s = "a189f3f2-a38e-47d6-b1a9-622955112ea5,19e75879-4717-410a-b5ec-452aa75d302e,a2543731-20df-4285-8dd4-a4f8f7a0b1f4";
        List<String> myList = new ArrayList<String>(Arrays.asList(s.split(",")));
        System.out.println(myList);

        String s2 = "a189f3f2-a38e-47d6-b1a9-622955112ea5,19e75879-4717-410a-b5ec-452aa75d302e,a2543731-20df-4285-8dd4-a4f8f7a0b1f4,a189f3f2-a38e-47d6-b1a9-622955112ea5";
        List<String> lst = List.of(s2.split(","));
        System.out.println(lst);

        /*Set<String> set = new HashSet<>(lst);
        System.out.println(String.valueOf(set));*/

        //String string = "1, 2, 3, 4";
        Set<UUID> set2 = Arrays.asList(s2.split(",")).stream().map(x -> UUID.fromString(x)).collect(Collectors.toSet());


        System.out.println("-----------------------------");
        System.out.println(String.valueOf(set2));
        System.out.println("-----------------------------");

        String str = (String) set2.stream().map(x -> x.toString()).collect(Collectors.joining("_"));
        System.out.println(str);
    }

}
