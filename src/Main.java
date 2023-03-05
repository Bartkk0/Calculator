import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
//        System.out.println(RPNCalculator.Calculate("2 2 + 2 2 * 2 / -"));

//        System.out.println(ConvToRPN.convert("2 + 2 - 2 * 2 / 2"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            System.out.print("> ");
            String in = br.readLine();
            String rpn = ConvToRPN.convert(in);
            System.out.println(rpn);
            System.out.println(RPNCalculator.calculate(rpn));
        }
    }
}
