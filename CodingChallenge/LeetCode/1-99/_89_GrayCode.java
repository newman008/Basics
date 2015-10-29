package LeetCode2;

import java.util.ArrayList;
import java.util.List;

public class _89_GrayCode {
    public List<Integer> grayCode(int n) {
        if(n == 0) {
            List<Integer> res = new ArrayList<Integer>();
            res.add(0);
            return res;
        }
        
        List<Integer> pre = grayCode(n-1);
        List<Integer> cur = new ArrayList<Integer>(pre);
        for(int i = cur.size() - 1; i >= 0; i--) {
            cur.add(pre.get(i) + (1 << (n-1)));
        }

        return cur;
    }
}
