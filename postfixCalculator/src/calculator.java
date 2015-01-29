/**
 * Created by lrraymond13 on 12/7/14.
 *Written by Lindsey Raymond
 * NYU ID Number: N10905714
 * Creates a Console that opens for user to type in infix expressions
 * It will also instantiate a converter to convert infix to postfix
 * Calc class will also have a method that evaluates postfix string
 */


import java.util.Stack;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class calculator {

    public static void main(String[] args) throws RuntimeException{
        Scanner userinput = new Scanner(System.in);

        System.out.println("Type your infix expression");
        String infix = userinput.nextLine();
        if (infix.length() < 1) {
            throw new  RuntimeException("Need more input");
        }
        converter calcConverter = new converter(infix);
        String postfix = calcConverter.toPostFix();
        System.out.println("Converted to postfix: "+postfix);

        double finalResult = PostFixEvaluator(postfix);

        System.out.println("answer is "+finalResult);

    }

    public static double PostFixEvaluator(String postfix) {
        //create stack to evaluate

        String[] inputArr = postfix.split(" ");
//        for (String e: inputArr) {
//            System.out.println("array element is "+e);
//        }
        Stack<String> opStack = new Stack<String>();

        for(int i=0; i< inputArr.length; i++) {
            String element = inputArr[i];
//            System.out.println("element is " + element);
            //check for spaces and ignore them
            if (element.length() < 1) {
                continue;
            } else if (converter.isNumeric(element)) {
                opStack.push(element);
            } else if (isOperator(element)) {
                double operand1 = 0;
                double operand2 = 0;
                try {
                    operand2 = converter.convertNumeric(opStack.pop());
                    operand1 = converter.convertNumeric(opStack.pop());
                }
                catch (RuntimeException e) {
                    System.out.println("Illegal postfix expression entered");
                }

                double result = 0;

                switch (element.charAt(0)) {
                    case '+': {
                        result = operand1 + operand2;
                        break;
                    }
                    case '-': {
                        result = operand1 - operand2;
                        break;
                    }
                    case '*': {
                        result = operand1 * operand2;
                        break;
                    }
                    case '/': {
                        result = operand1 / operand2;
                        break;
                    }
                    case '^': {
                        result = Math.pow(operand1, operand2);
                        break;
                    }
                    default: {
                        throw new RuntimeException("invalid operator value");
                    }
                }
                opStack.push(Double.toString(result));
            } else {
                continue;
            }
        }

    //After done with iterating through input, evaluate the remaining stuff on stack
    double finalResult = converter.convertNumeric(opStack.pop());
    return finalResult;
    }


    private static boolean isOperator(String input) {
        char[] operators = {'*','/', '+', '-', '^'};
        for (int i=0; i < operators.length; i++) {
            if (operators[i] == input.charAt(0)) {
                return true;
            }
        }
        return false;
    }


}
