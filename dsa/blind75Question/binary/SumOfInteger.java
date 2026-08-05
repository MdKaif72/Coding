package dsa.blind75Question.binary;

/*
Given two integers a and b, return the sum of the two integers without using the operators + and -.



Example 1:

Input: a = 1, b = 2
Output: 3
Example 2:

Input: a = 2, b = 3
Output: 5'

Findings

By doing xor we get the result what we want abd by and&<<1 we are getting the carry
 */

public class SumOfInteger {

    public static int getSum(int a, int b) {
        int xor=a^b;
        int carry = (a&b) <<1;
        while(carry !=0){
            xor=a^b;
            carry =(a&b) <<1;
            a=xor;
            b= carry;
        }
        return xor;
    }

}
