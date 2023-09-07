package v1ch14;

public class Test7 {
    public static void main(String[] args) {
        System.out.println("---------------------------------------");

        String text = "viktor.shumik@intellias.com, vshumick@gmail.com";
        String[] array = text.split(",");
        for(String value:array) {
            System.out.println(value + " ");
        }

        String s = "rekor-one-test-1650378651629|RekorOneTest";

        System.out.println(s.substring(s.indexOf("|") + 1));

    }
}
