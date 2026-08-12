package dsa.blind75Question.string;

/*
LC 49
Given an array of strings strs, group the anagrams together. You can return the answer in any order.



Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:

There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
Example 2:

Input: strs = [""]

Output: [[""]]

Example 3:

Input: strs = ["a"]

Output: [["a"]]


 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {

    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs == null || strs.length == 0)
            return new ArrayList<>();

        Map<String, List<String>> frequencyStringMap = new HashMap<>();
        for (String str : strs) {

            String frequencyString = getFrequencyString(str);

            if (frequencyStringMap.containsKey(frequencyString))
                frequencyStringMap.get(frequencyString).add(str);
            else {
                List<String> list = new ArrayList<>();
                list.add(str);
                frequencyStringMap.put(frequencyString, list);
            }
        }
        return new ArrayList<>(frequencyStringMap.values());

    }


    private String getFrequencyString(String str) {
        int[] freq = new int[26];

        for (char c : str.toCharArray())
            freq[c - 'a']++;

        StringBuilder freqString = new StringBuilder();
        char c = 'a';

        for (int i : freq) {
            freqString.append(c);
            freqString.append(i);
            c++;
        }
        return freqString.toString();


    }
}
