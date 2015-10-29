package LeetCode2;

/*
 * Numbers can be regarded as product of its factors. For example,

8 = 2 x 2 x 2;
  = 2 x 4.
Write a function that takes an integer n and return all possible combinations of its factors.

Note: 
Each combination's factors must be sorted ascending, for example: The factors of 2 and 6 is [2, 6], not [6, 2].
You may assume that n is always positive.
Factors should be greater than 1 and less than n.
 */

import java.util.*;

public class _254_FactorCombinations {
    
    public List<List<Integer>> getFactors(int n) {
        // if(isPrime(n) || n == 1) {
        //     return new ArrayList<Integer>();
        // }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        backtrack(res, path, n);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> path, int n) {
        if(n == 1) {
            if(path.size() > 1)
                res.add(new ArrayList<Integer>(path));
            return;
        }
        
        for(int i = 2; i <= n / 2; i++) {
            if(n % i == 0) {
                path.add(i);
                backtrack(res, path, n / i);
                path.remove(path.size() - 1);
            }
        }
    }
    
    private boolean isPrime(int n) {
        boolean isPrime = true;
        for(int i = 2; i < n; i++) {
            if(n % i == 0) isPrime = false;
        }
        return isPrime;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        _254_FactorCombinations t = new _254_FactorCombinations();
        t.getFactors(4);
    }

}
