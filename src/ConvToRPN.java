import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ConvToRPN {
    public static final HashMap<Character, Integer> priorities = new HashMap<>();

    static {
        priorities.put('(', 0);
        priorities.put('+', 1);
        priorities.put('-', 1);
        priorities.put(')', 1);
        priorities.put('*', 2);
        priorities.put('/', 2);
        priorities.put('%', 2);
        priorities.put('^', 3);
    }

    public static String convert(String input) {
        StringBuilder output = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        // TODO: negative numbers

        boolean readingNum = false;
        int currNum = 0;
        for (int i = 0; i < input.length(); i++) {
            char operator = input.charAt(i);

            if (Character.isDigit(operator)) {
                readingNum = true;
                currNum *= 10;
                currNum += operator - '0';
            } else {
                if(readingNum){
                    output.append(currNum).append(" ");
                    currNum = 0;
                    readingNum = false;
                }

                if (operator == '(')
                    stack.push(operator);
                else if (operator == ')'){
                    while (stack.peek() != '(')
                        output.append(stack.pop()).append(' ');
                    stack.pop();
                }
                else if (priorities.containsKey(operator)) {
                    int priority = priorities.get(operator);

                    if (!stack.empty()) {
                        char stackOpt = stack.peek();
                        int stackOptPr = priorities.get(stackOpt);

                        while (priority <= stackOptPr) {
                            output.append(stack.pop()).append(" ");

                            if (stack.empty())
                                break;

                            stackOpt = stack.peek();
                            stackOptPr = priorities.get(stackOpt);
                        }
                    }

                    stack.push(operator);
                }
            }
        }

        if(readingNum){
            output.append(currNum).append(" ");
            currNum = 0;
            readingNum = false;
        }

        while (!stack.empty())
            output.append(stack.pop()).append(' ');

        return output.toString();
    }
}
