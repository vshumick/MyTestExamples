package v1ch14;

public class Test12 {

    public static void main(String[] args) {
        String str = "A roza upala na lapu Azora";
        System.out.println(invertString(str));
    }
    public static String invertString(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
