import util.ExpressionParser;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
	    //Scanner in = new Scanner(System.in);
        String original = "\\a.\\b.a b c (\\d.e \\f.g) h";
        String input = "\\a. \\ b . a b c  \n (\\  d  .  e   \\f . g)  h   ";
        String expected = "(\\a.(\\b.((((a b) c) (\\d.(e (\\f.g)))) h)))";
        String output = ExpressionParser.parse(input).toString();
        System.out.println(output);
        System.out.println(output.equals(expected));
    }
}
