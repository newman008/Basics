package LeetCode2;

import java.util.LinkedList;
import java.util.List;

public class _60_PermutationSequence {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        
        int[] fact = new int[n];
        fact[0] = 1;
        for(int i = 1; i < n; i++) fact[i] = i * fact[i-1];
        
        List<Integer> num = new LinkedList<Integer>();
        for(int i = 1; i <= n; i++) num.add(i);
        
        k = k-1;
        for(int i = 0; i < n ; i++) {
            int cur = k / fact[n-1-i];
            sb.append(num.get(cur));
            num.remove(cur);
            k = k % fact[n-1-i];
            
        }
        
        return sb.toString();
    }
}
