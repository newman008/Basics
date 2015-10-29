package LeetCode2;

import java.util.ArrayList;
import java.util.List;

public class _119_PascalsTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        if(rowIndex < 0) return res;
        
        for(int i = 0; i <= rowIndex; i++) {
            res.add(0, 1);
            for(int j = 1; j < res.size() - 1; j++) {
                res.set(j, res.get(j) + res.get(j+1));
            }
        }
        
        return res;
    }
}
