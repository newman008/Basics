package LeetCode2;

/*
 * Given an integer, write a function to determine if it is a power of two.
 */

public class _231_PowerOfTwo {
    
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        return (n & (n-1)) == 0;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
