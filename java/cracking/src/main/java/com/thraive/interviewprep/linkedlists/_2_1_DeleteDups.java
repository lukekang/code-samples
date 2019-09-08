package com.thraive.interviewprep.linkedlists;

import com.sun.tools.javac.util.Assert;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class _2_1_DeleteDups {

    public static void main(String[] args){


        Assert.check(deleteDupsWithoutDataStructure(null) == null);

        Node singleNode = new Node(10);
        Assert.check(deleteDupsWithoutDataStructure(singleNode).equals(singleNode));

        System.out.println("---------- WITH DS ----------");

        Node ll1 = buildLinkedList(20, 4, 100);
        System.out.println("Here's the built linked list: ");
        System.out.println(ll1.toString());

        Node deletedDups = deleteDupsWithDataStructureInPlaceMod(ll1);
        System.out.println("Here's the deduped linked list: ");
        System.out.println(deletedDups.toString());


        System.out.println("---------- WITHOUT DS ----------");

        Node ll2 = buildLinkedList(20, 4, 200);
        System.out.println("Here's the built linked list: ");
        System.out.println(ll2.toString());

        Node deletedDupsWithoutDs = deleteDupsWithoutDataStructure(ll2);
        System.out.println("Here's the deduped linked list: ");
        System.out.println(deletedDupsWithoutDs.toString());



    }


    //
    // O -> 123 -> 23 -> 123 -> 837 -> 132 -> 132 -> null
    // O -> 123 -> 23 -> 123 -> 837 -> 132 -> null
    // O -> 0 -> 123 -> 23 -> 123 -> 837 -> 132 -> null
    //


    private static Node deleteDupsWithoutDataStructure(Node node){
        if(node == null || node.next == null) return node;

        Node head = node;

        while(node != null){
            int val = node.value;

            Node runnerPrev = node;
            Node runner = node.next;
            while(runner != null){
                if(runner.value == val){
                    runnerPrev.next = runner.next;
                    runner = runnerPrev;
                }

                runnerPrev = runner;
                runner = runner.next;

            }
            node = node.next;
        }
        return head;
    }


    private static Node deleteDupsWithDataStructureInPlaceMod(Node node) {

        // these validations are O(1)
        if(node == null) return null;
        if(node.next == null) return node;

        // create set to maintain all distinct values and use to check for deletion candidates
        Set<Integer> seen = new HashSet<>();

        Node head = node; // maintain head to return
        Node prev = null;

        while(node != null){
            if(seen.contains(node.value)){
                prev.next = node.next; // this is fine because the next is either another node or the end.
            }
            else{
                seen.add(node.value);
            }
            prev = node;
            node = node.next;
        }

        return head;
    }

    static Node buildLinkedList(int totalElements, int numDups, int upperBound) {

        Random r = new Random();

        int dupIndex = 0;
        Node head = new Node(r.nextInt(upperBound));
        Node node = head;

        int dupOffset = totalElements / (numDups * 2);
        List<Integer> dups = new LinkedList<>();

        for(int i = 0; i < numDups; i++){
            int val = r.nextInt(upperBound);
            System.out.println("Dup " + i + " = " + val);
            dups.add(val);
            node.next = new Node(val);
            node = node.next;
        }

        for(int i = dups.size(); i < totalElements - 1; i++){

            int val = 0;
            if((i > 0) && (i % dupOffset == 0)){
                val = dups.get(dupIndex);
                System.out.println("dup index: " + i + ", val: " + val);

                if(dupIndex < dups.size()-1)
                    dupIndex++;
                else
                    dupIndex = 0;

            }
            else
                val = r.nextInt(upperBound);

            node.next = new Node(val);
            node = node.next;
        }

        return head;
    }


    static class Node{
        public Node next;
        public int value;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString(){
            StringBuffer b = new StringBuffer("[");
            Node n = this;
            while(n != null){

                b.append(String.valueOf(n.value));

                if(n.next != null)
                    b.append(", ");
                else
                    b.append("]");

                n = n.next;
            }
            return b.toString();
        }
    }

}
