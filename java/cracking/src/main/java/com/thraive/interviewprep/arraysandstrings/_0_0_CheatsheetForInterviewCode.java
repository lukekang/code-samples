package com.thraive.interviewprep.arraysandstrings;

import com.sun.tools.javac.util.Assert;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class _0_0_CheatsheetForInterviewCode {


    public static void main(String[] args){

        primitives();
        stringsAndArrays();


    }

    private static void primitives() {
        // binary operations
        binaryOps();

    }

    private static void binaryOps() {
        // OR
        int v1 = 6;     // 0110
        int v2 = 5;     // 0101
        int res = 6|5;  // 0111
        out.println("6 | 5 = " + res);

        // &
        v1 = 6;         // 0110
        v2 = 5;         // 0101
        res = 6&5;      // 0100
        out.println("6 & 5 = " + res);

        // ^ XOR
        v1 = 6;         // 0110
        v2 = 5;         // 0101
        res = 6 ^ 5;    // 0011
        out.println("6 ^ 5 = " + res);

        // ~ Complement
        v1 = 6;         // 0000 0110
        res = ~v1;      // 1111 1001
        out.println("~ 6 = " + res);

        out.println(Integer.toBinaryString(6));
        out.println(Integer.toBinaryString(res));


        out.println("MAX => " + Integer.toBinaryString(Integer.MAX_VALUE));
        out.println("MIN => " + Integer.toBinaryString(Integer.MIN_VALUE));

        for(int i = -100; i <=100; i++){
            out.println(i + " => " + Integer.toBinaryString(i));
        }


        for(int i = 0; i < 16; i++){
            int mask = 1 << i;
            out.println("1 << " + i + " = " + mask);
        }

    }

    private static void stringsAndArrays() {
        // Strings and arrays
        String s = "here is my arbitrary string";

        int charCodeOfHInHere = s.charAt(0);

        char[] stringChars = s.toCharArray();

        // convert without guava
        List<Character> listOfChars = s.chars().mapToObj(charCode -> (char)charCode).collect(Collectors.toList());

        Set<Character> setOfChars = new HashSet<>(listOfChars);

        // contains
        Assert.check(setOfChars.contains('h'));
        Assert.check(setOfChars.contains('e'));
        Assert.check(setOfChars.contains('r'));
        Assert.check(!setOfChars.contains('z'));

        // failing assertion
//        Assert.check(setOfChars.contains('z'));

        // sorting
        Arrays.sort(stringChars);

        List<Person> people = Arrays.asList(
                new Person(1, "Foo"),
                new Person(2, "Bar"),
                new Person(3, "Zoolander"),
                new Person(4, "Baz")
        );

        people.sort((p1, p2) -> p1.name.compareTo(p2.name));

        out.println("Printing sorted by name");
        people.forEach(p -> out.println(p.name));


        // Maps

        // create from list
        Map<Integer, Person> personMap = people.stream().collect(Collectors.toMap(p -> p.id, p -> p));

        // iterate over keys
        for(Integer key : personMap.keySet()){
            out.println(key);
        }
        // iterate over values
        for(Person p : personMap.values()){
            out.println(p.toString());
        }

        personMap.forEach((k, v) -> out.println("key: " + k + ", value: " + v.toString()));


        // chars and numeric trickery
        char c = '\0';
        out.println("3 consecutive octal escapes = (" + c + c + c + ")");

        out.println("any char subtracted by itself is = " + (c - c));

        String test = "my test string";
        out.println("In the test string = '" + test + ", the 1st character charAt(0) value = " + test.charAt(0));

        out.println("We can start doing bit vector stuff by subtracting characters by 'a'..");
        out.println("So '" + test.charAt(0) + "' subtracted by 'a' = " + (test.charAt(0) - 'a'));

        out.println("We can then insert that into an int if we want");
        out.println("'" + test.charAt(0) + "' could then be placed in K-th bit: someint = (1 << (" + test.charAt(0) + " - 'a'))");
        int checker = (1 << test.charAt(0) - 'a');
        out.println("the int value of that should  be 2 ^ " + (test.charAt(0)-'a') + " = " + checker);
        out.println("the binary rep of that would be: " + Integer.toBinaryString(checker));


    }

    public static class Person{
        int id;
        String name;

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
