/**
 * Created by lrraymond13 on 12/6/14.
 * Written by Lindsey Raymond
 * NYU ID Number: N10905714
 * Takes an infix expressession and converts to postfix using a stack
 * Returns a string version of postfix expression
 */
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.lang.Character;

public class converter {

    public String infix;
    public Stack<String> calcStack = new Stack<String>();
    public static char[] operators = {'*', '/', '+', '-', '(', ')', '^'};

    public converter(String infix) {

        this.infix = infix;
    }


    public String toPostFix() {
        //Tokenize input string
        List<String> parsed = parse(this.infix.toCharArray());
        StringBuffer output = new StringBuffer(parsed.size());

//        for (String element : parsed) {
//            System.out.print(element + " ");
//        }

        //create a stack and convert to postfix
        for (String element : parsed) {
            //if a number then append to the output
            if (isNumeric(element)) {
                output.append(" " + element);
            } else if (checkOperator(element)) {
                while (!calcStack.empty() && !lowerPrecedence(calcStack.peek().charAt(0), element.charAt(0))) {
                    //stack not empty operator on stack does not have lower precedence,
                    //elements are popped off the stack
                    output.append(" " + calcStack.pop());
                }

                //if a ')' is found, pop until we find the matching '('
                //'(' has the lowest precedence when in the stack, but highest in the input
                //we do not append parenthesis to the output
                if (element.charAt(0) == ')') {
                    //pop until find the matching ')'
                    String next = calcStack.pop();
                    while (next.charAt(0) != '(') {
                        output.append(" " + next);
                        next = calcStack.pop();
                    }
                }
                //Otherwise, push the operator onto the stack
                else {
                    calcStack.push(element);
                }
            }
            //if there is a space in the input ignore it
            else if (isSpace(element.charAt(0))) {
                continue;
            }

        }
        //At end, when all input is parsed, pop off items from stack and append to output
        while (!calcStack.empty()) {
            output.append(" " + calcStack.pop());
        }
        return output.toString();

    }

    //Expression Parser
    private List<String> parse(char[] input) {
        List<String> parsed = new ArrayList<String>();
        for (int i = 0; i < input.length; i++) {
            char c = input[i];
            if (Character.isDigit(c)) {
                String number = input[i] + "";
                for (int j = i + 1; j < input.length; ++j) {
                    if (Character.isDigit(input[j]) || input[j] == '.') {
                        number += input[j];
                        i = j;
                    } else {
                        break;
                    }
                }
                parsed.add(number);
            } else if (checkOperator(c + "")) {
                parsed.add(c + "");
            }
        }
        return parsed;
    }

    private boolean checkOperator(String input) {
        for (int i = 0; i < operators.length; i++) {
            if (operators[i] == input.charAt(0)) {
                return true;
            }
        }
        return false;
    }

    private boolean lowerPrecedence(char op1, char op2) {
        //Test if operator 1 has a lower precedence than op2 (op1 in stack)
        //Assume we are testing op1 in stack and op2 not
        // '(' has lowest precedence (same as + and -) in stack, but highest in input
        switch (op1) {
            case '+':
            case '-': {
                return !(op2 == '+' || op2 == '-');
            }
            case '/':
            case '*': {
                return (op2 == '^' || op2 == '(');
            }
            case '^': {
                return op2 == '(';
            }
            case '(':
                return true;
            default: {
                return false;
            }
        }
    }

    public static boolean isSpace(char op) {
        return (op == ' ');
    }

    public static boolean isNumeric(String op) {
        try {
            double d = convertNumeric(op);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    public static double convertNumeric(String op) throws NumberFormatException {
        return Double.parseDouble(op);
    }
}