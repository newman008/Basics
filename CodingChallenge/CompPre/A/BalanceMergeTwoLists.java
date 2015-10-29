package Amazon;

import java.util.*;
/*
 * 给两个列表，每个列表装着一样的元素，合并两个列表，并要求短的列表的元素把长列表元素尽可能均衡分开。
 * 比如列表为AAAAA和BBBBBB，返回BABABABABAB；又比如AAAAAA和BBBB，返回AABABABABA。
 */

public class BalanceMergeTwoLists {
    
    public static List<Character> mergeList(List<Character> a, List<Character> b) {
        List<Character> res = new ArrayList<Character>();
        int sizeA = a.size();
        int sizeB = b.size();
        if(sizeA < sizeB) return mergeList(b, a);
        
        int partSize = sizeA / (sizeB + 1);
        int left = sizeA % sizeB;
        for(int i = 0; i <= sizeB; i++) {
            for(int j = 0; j < partSize; j++) res.add(a.get(0));
            if(left > 0) {
                res.add(a.get(0));
                left--;
            }
            if(i < sizeB)
                res.add(b.get(0));
        }

        return res;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<Character> a = new ArrayList<Character>();
        List<Character> b = new ArrayList<Character>();
        for(int i = 0; i < 7; i++) a.add('A');
        for(int i = 0; i < 4; i++) b.add('B');
        for(Character c : BalanceMergeTwoLists.mergeList(a, b)){
            System.out.print(c + " ");
        }
    }

}
