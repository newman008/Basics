package leetcode;

/**
 * Problem:
 * Merge two sorted arrays to a list, remove duplicates
 */

public class _interview_merge_two_sorted_array {
    public ListNode mergeTwoSortedArrays(int[] arr1, int[] arr2) {
        if (arr1 == null || arr1.length == 0)
            return Utils.generateLinkedListFromArray(arr2);
        if (arr2 == null || arr2.length == 0)
            return Utils.generateLinkedListFromArray(arr1);

        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int i = 0;
        int j = 0;
        while(i < arr1.length && j < arr2.length) {
            //System.out.println("i = " + i + " " + "j = " + j);
            //Utils.printIntLinkedList(pre.next);
            //System.out.println("");
            if (arr1[i] < arr2[j]) {
                if(cur.val != arr1[i]) {
                    ListNode newNode = new ListNode(arr1[i]);
                    cur.next = newNode;
                    cur = newNode;
                }
                i++;
            } else if (arr1[i] > arr2[j]) {
                if(cur.val != arr2[j]) {
                    ListNode newNode = new ListNode(arr2[j]);
                    cur.next = newNode;
                    cur = newNode;
                }
                j++;
            } else {
                i++;
            }
        }

        while(i < arr1.length) {
            if(cur.val != arr1[i]) {
                ListNode newNode = new ListNode(arr1[i]);
                cur.next = newNode;
                cur = newNode;
            }
            i++;
        }

        while(j < arr2.length) {
            if(cur.val != arr2[j]) {
                ListNode newNode = new ListNode(arr2[j]);
                cur.next = newNode;
                cur = newNode;
            }
            j++;
        }
        return pre.next;
    }

    public static void main(String[] args) {
        _interview_merge_two_sorted_array s = new _interview_merge_two_sorted_array();
        int[] array1 = new int[]{1, 2, 4, 4, 6};
        int[] array2 = new int[]{3, 5, 5, 5, 5, 6, 6, 7,  9, 10, 13};

        ListNode result = s.mergeTwoSortedArrays(array1, array2);
        Utils.printIntLinkedList(result);
    }
}

