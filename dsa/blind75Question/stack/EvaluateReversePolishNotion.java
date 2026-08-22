package dsa.blind75Question.stack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


/*
LC 150
You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

Evaluate the expression. Return an integer that represents the value of the expression.

Note that:

The valid operators are '+', '-', '*', and '/'.
Each operand may be an integer or another expression.
The division between two integers always truncates toward zero.
There will not be any division by zero.
The input represents a valid arithmetic expression in a reverse polish notation.
The answer and all the intermediate calculations can be represented in a 32-bit integer.


Example 1:

Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:

Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22


Constraints:

1 <= tokens.length <= 104
tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
 */
public class EvaluateReversePolishNotion {


    public static int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        Set<String> operator = new HashSet<>(Arrays.asList("+", "/", "*", "-"));

        for (String token : tokens) {

            if (operator.contains(token)) { //opertor
                int first = stack.pop();
                int sec = stack.pop();
                stack.push(eval(first, sec, token));
            } else
                stack.push(Integer.valueOf(token));

        }
        return stack.pop();
    }

    private static int eval(int i, int j, String oper) {
        if (oper.equals("+"))
            return i + j;
        if (oper.equals("-"))
            return j - i;
        if (oper.equals("/"))
            return j/i;
        if (oper.equals("*"))
            return i * j;
        return 0;
    }
}