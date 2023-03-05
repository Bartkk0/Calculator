import java.util.Scanner;
import java.util.Stack;

public class RPNCalculator {
    public static long calculate(String input) {
        Scanner scanner = new Scanner(input);
        Stack<Integer> stack = new Stack<>();

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                stack.push(scanner.nextInt());

            } else if (scanner.hasNext()) {
                char operator = scanner.next().charAt(0);

                int b = stack.pop();
                int a = stack.pop();
                int result = 0;

                switch (operator) {
                    case ' ':
                        break;
                    case '+':
                        result = a + b;
                        break;
                    case '-':
                        result = a - b;
                        break;
                    case '*':
                        result = a * b;
                        break;
                    case '/':
                        result = a / b;
                        break;
                    case '^':
                        result = (int) Math.pow(a, b);
                        break;
                    case '%':
                        result = a % b;
                        break;
                }

                stack.push(result);
            }
        }
        return stack.pop();
    }
}
