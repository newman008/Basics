package InterviewQuestions;
/*
given an order string "abc" check if "aabdccd" maintain the order
"aabdccd" -> true;
"abbca" -> false;
note:order does not contain all chars in s
*/

import java.util.Arrays;

/*
 * given an order string "abc" check if "aabdccd" maintain the order
 */

public class CheckStringOrde {
    
    public static boolean checkOrder(String p, String s) {
        int[] pos = new int[256];
        Arrays.fill(pos, -1);
        for(int i = 0; i < p.length(); i++) {
            pos[p.charAt(i)] = i;
        }
        int last = 0;
        for(int i = 0; i < s.length(); i++) {
            int val = pos[s.charAt(i)];
            if(val == -1) continue;
            if(val < last) return false;
            last = val;
        }
        
        return true;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.print(CheckStringOrde.checkOrder("abc", "favzvbc"));
    }

}
