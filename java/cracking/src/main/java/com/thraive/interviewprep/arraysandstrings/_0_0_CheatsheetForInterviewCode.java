package com.thraive.interviewprep.arraysandstrings;

import com.sun.tools.javac.util.Assert;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class _0_0_CheatsheetForInterviewCode {


    public static void main(String[] args){

        // Strings and arrays
        String s = "here is my arbitrary string";

        int charCodeOfHInHere = s.charAt(0);

        char[] stringChars = s.toCharArray();

        // convert without guava
        List<Character> listOfChars = s.chars().mapToObj(charCode -> (char)charCode).collect(Collectors.toList());

        Set<Character> setOfChars = new HashSet<>(listOfChars);

        Assert.check(setOfChars.contains('h'));
        Assert.check(setOfChars.contains('e'));
        Assert.check(setOfChars.contains('r'));
        Assert.check(!setOfChars.contains('z'));

        // failing assertion
//        Assert.check(setOfChars.contains('z'));


    }
}
