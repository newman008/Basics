package leetcode;

import java.util.*;

public class Utils {
    public static void printIntArray(int[] array) {
        System.out.print("[");
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if(i != array.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void printListOfIntegerList(List<List<Integer>> lol) {
        for(int i = 0; i < lol.size(); i++) {
            System.out.print("(");
            for(int j = 0; j < lol.get(i).size(); j++) {
                System.out.print(lol.get(i).get(j));
                if(j != lol.get(i).size() - 1) System.out.print(", ");
            }    
            System.out.println(")");
        } 
    }

    public static void printIntLinkedList(ListNode head) {
        if(head == null) {
            System.out.print("LinkedList is empty");
            return;
        }
        while(head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
    }

    public static ListNode generateLinkedListFromArray(int[] array) {
        if(array == null || array.length == 0) {
            System.out.print("array is empty");
            return null;
        }
        ListNode preHead = new ListNode(0);
        ListNode pre = preHead;

        for(int i = 0; i < array.length; i++) {
            ListNode cur = new ListNode(array[i]);
            pre.next = cur;
            pre = cur;
        }

        return preHead.next;
    }
}
