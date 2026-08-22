package dsa.blind75Question.simple;

import dsa.blind75Question.stack.EvaluateReversePolishNotion;

public class Main {

    public static void main(String[] args) {
//        System.out.println(FirstBadVersion.firstBadVersion(3));
//        System.out.println(RomanToInteger.romanToInt("MCMXCIV"));
        System.out.println(EvaluateReversePolishNotion.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }

}
