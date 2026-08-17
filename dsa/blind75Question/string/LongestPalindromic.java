package dsa.blind75Question.string;

/*
LC 5

Given a string s, return the longest palindromic substring in s.



Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"


Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.

Palindromic
A string is palindromic if it reads the same forward and backward.
 */

public class LongestPalindromic {

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;  // Empty or single-character string is already the longest palindrome
        }

        int start = 0; // Starting index of longest palindrome found so far
        int maxLen = Integer.MIN_VALUE;

        for (int i = 0; i < s.length(); i++) {
            int lenOdd = expandFromCenter(s, i, i);       // palindrome length with center at i (odd)
            int lenEven = expandFromCenter(s, i, i + 1);  // palindrome length with centers i and i+1 (even)
            int len = Math.max(lenOdd, lenEven);

            if (len > maxLen) {
                start = i - (len - 1) / 2;
                maxLen = len;
            }
        }

        return s.substring(start, start + maxLen);
    }

    private int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // length after overshooting once on both sides
    }


}
