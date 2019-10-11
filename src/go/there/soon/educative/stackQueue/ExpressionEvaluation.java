package go.there.soon.educative.stackQueue;

import java.util.Stack;

public class ExpressionEvaluation {
    public static void main(String [] args) {
        double number = evaluate("3+2.45/8");
        System.out.println(number);
    }

    public static double evaluate(String expression){
        Stack<Double> numbers = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for(int i = 0; i < expression.length();) {
            char ch = expression.charAt(i);

            if(isOperator(ch)) {
                ops.push(ch);
                i++;
            } else {
                String numberStr = "";
                while(i < expression.length() && !isOperator(expression.charAt(i))) {
                    numberStr += expression.charAt(i);
                    i++;
                }

                double number = Double.valueOf(numberStr);

                if(!ops.isEmpty()) {
                    if(ops.peek() == '*' || ops.peek() == '/') {
                        if(numbers.isEmpty())
                            return -1;

                        double top  = numbers.pop();

                        if(ops.peek() == '*') {
                            numbers.push(top * number);
                        } else {
                            numbers.push(top / number);
                        }

                        ops.pop();
                    } else {
                        numbers.push(number);
                    }
                } else {
                    numbers.push(number);
                }
            }
        }

        while(!numbers.isEmpty() && !ops.isEmpty()) {
            char ch = ops.pop();

            if(numbers.isEmpty())
                return -1;

            double d1 = numbers.pop();

            if(numbers.isEmpty())
                return -1;

            double d2 = numbers.pop();


            if(ch == '+') {
                numbers.push(d1+d2);
            } else if(ch == '-') {
                numbers.push(d2-d2);
            } else if(ch == '*') {
                numbers.push(d1*d2);
            } else {
                numbers.push(d2/d1);
            }
        }

        return (numbers.size() != 1) ? -1 : numbers.pop();
    }

    public static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }
}
