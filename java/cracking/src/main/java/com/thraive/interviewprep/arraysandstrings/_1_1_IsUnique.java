package com.thraive.interviewprep.arraysandstrings;

import com.sun.tools.javac.util.Assert;

public class _1_1_IsUnique {

    /*
    Implement an algorithm to deterrmine if a string has all unique characters.
    What if you cannot use additional data structures?
     */

    public static void main(String[] args){

        Assert.check(!isUniqueWithDataStructure("doggy"));
        Assert.check(isUniqueWithDataStructure("dog"));
        Assert.check(isUniqueWithDataStructure("the quick brown fox sat"));

    }

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

}
