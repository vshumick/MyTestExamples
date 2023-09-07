package v1ch14;

import java.util.Scanner;

public class Test11 {

        public static void main(String[] args) {
            String input;
            Scanner in = new Scanner(System.in);
            System.out.print("Enter any string: ");
            input = in.nextLine();
            StringBuilder input1 = new StringBuilder();
            input1.append(input);
            input1 = input1.reverse();
            System.out.println(input1);
        }

}
