package com.thraive.interviewprep.arraysandstrings;

import com.sun.tools.javac.util.Assert;

import java.util.HashMap;
import java.util.Map;

public class _1_2_CheckPermutation {


    public static void main(String[] args){
        Assert.check(checkPermutation("bard", "brad"));
        Assert.check(!checkPermutation("bird", "brady"));
    }

    // Convert to array of integers... int[]

    // Assumptions: case sensitive, whitespace count as characters

    // time: O(3n) => O(n), space: O(n)
    static boolean checkPermutation(String s1, String s2){
        // initial implementation

        if(s1 == null || s2 == null) throw new IllegalArgumentException("Must both be non-null");

        if(s1.length() != s2.length()) return false;  // best case

        Map<Character, Integer> charCount = new HashMap<>();

        char[] s1Chars = s1.toCharArray();
        for(int i = 0; i < s1Chars.length; i++){
            Integer count = charCount.get(s1Chars[i]);
            if(count == null)
                count = 0;
            charCount.put(s1Chars[i], count + 1);
        }

        char[] s2Chars = s2.toCharArray();
        for(int i = 0; i < s2Chars.length; i++){
            Integer count = charCount.get(s2Chars[i]);
            if(count == null)
                count = 0;
            charCount.put(s2Chars[i], count - 1);
        }

        for(int count : charCount.values()){
            if(count != 0) return false;
        }

        return true;
    }
}
