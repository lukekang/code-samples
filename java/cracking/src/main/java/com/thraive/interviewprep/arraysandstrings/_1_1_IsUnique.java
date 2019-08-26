package com.thraive.interviewprep.arraysandstrings;

import com.sun.tools.javac.util.Assert;

import java.util.Arrays;

public class _1_1_IsUnique {

    /*
    Implement an algorithm to deterrmine if a string has all unique characters.
    What if you cannot use additional data structures?
     */

    public static void main(String[] args){

        Assert.check(!isUniqueWithDataStructure("doggy"));
        Assert.check(isUniqueWithDataStructure("dog"));
        Assert.check(isUniqueWithDataStructure("abcdefghijklmnopqrstuvwxyz"));


        Assert.check(!isUniqueWithoutDataStructure("doggy"));
        Assert.check(isUniqueWithoutDataStructure("dog"));
        Assert.check(isUniqueWithoutDataStructure("abcdefghijklmnopqrstuvwxyz"));
        Assert.check(!isUniqueWithoutDataStructure("abcdefghijklmnopqrstuvwxyzz"));
    }


    // time: O(n), space O(numOfCharNums) => O(1)... bounded by worst case 128
    static boolean isUniqueWithDataStructure(String s){
        boolean[] charSet = new boolean[128];

        for(int i = 0; i < s.length(); i++){
            int charCode = s.charAt(i);

            if(charSet[charCode]){
                return false;
            }
            else
                charSet[charCode] = true;
        }

        return true;
    }

    // time: O(n log n), space: O(1)
    static boolean isUniqueWithoutDataStructure(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        for(int i = 0; i < chars.length-1; i++){
            if(chars[i] == chars[i+1]) return false;
        }
        return true;
    }
}
