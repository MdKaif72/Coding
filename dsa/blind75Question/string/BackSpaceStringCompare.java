package dsa.blind75Question.string;

import java.util.Stack;

/*
LC 844
Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a
backspace character.

Note that after backspacing an empty text, the text will continue empty.



Example 1:

Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".
Example 2:

Input: s = "ab##", t = "c#d#"
Output: true
Explanation: Both s and t become "".
Example 3:

Input: s = "a#c", t = "b"
Output: false
Explanation: s becomes "c" while t becomes "b".


Constraints:

1 <= s.length, t.length <= 200
s and t only contain lowercase letters and '#' characters.


Follow up: Can you solve it in O(n) time and O(1) space?
 */
public class BackSpaceStringCompare {

    public static boolean backspaceCompare(String s, String t) {


        System.out.println("S " + convertStringWithHash(s));
        System.out.println("T " + convertStringWithHash(t));
        return convertStringWithHash(s).equals(convertStringWithHash(t));


    }

    private static String convertStringWithHash(String s) {

        int skip = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '#'){
                skip++;
                continue;
            }
            if (skip > 0)
              skip--;
            else
                sb.append(s.charAt(i));
        }
        return sb.reverse().toString();


    }


}
