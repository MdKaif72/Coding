package dsa.blind75Question.string;

import java.util.HashMap;

/*
LC 409
Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that
can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome.



Example 1:

Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
Example 2:

Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", whose length is 1.


Constraints:

1 <= s.length <= 2000
s consists of lowercase and/or uppercase English letters only.
 */
public class LongestPalindrome {


    public static int longestPalindrome(String s) {

        HashMap<Character, Integer> freqMap = new HashMap<>();

        for (char ch : s.toCharArray()) {
            freqMap.put(ch, 1 + freqMap.getOrDefault(ch, 0));
        }
        int ans = 0;
        boolean isOdd = false;

        for (char key : freqMap.keySet()) {
            if (freqMap.get(key) % 2 == 0) {
                ans += freqMap.get(key);
            } else {
                if (freqMap.get(key) >= 2) {
                    ans += freqMap.get(key) - 1;
                    isOdd = true;
                } else
                    isOdd = true;
            }
        }
        return isOdd ? ans + 1 : ans;


    }

}
