package dsa.blind75Question.string;

/*
LC 76
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.



Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 */

public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        int [] mapT=new int[256];
        int [] mapS=new int[256];

        //This will store the actual freq of character which need to be satisfied
        for(char ch:t.toCharArray()){
            mapT[ch]++;
        }

        int left =0, right=0 , minLen=Integer.MAX_VALUE,minStart=0;
        for(;right<s.length();right++){
            mapS[s.charAt(right)]++;

            //This loop while truncate as much as it satisfy
            while(isSatisfied(mapS,mapT)){
                if(right-left+1<minLen){
                    minLen=right-left+1;
                    minStart=left;
                }
                mapS[s.charAt(left++)]--;
            }
        }
        return minLen==Integer.MAX_VALUE ? "" : s.substring(minStart,minStart+minLen);



    }
    public static boolean isSatisfied(int [] mapS, int []mapT){
        for(int i=0;i<256;i++){
            if(mapS[i]<mapT[i])
                return false;
        }
        return true;
    }

}
