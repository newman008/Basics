package LeetCode2;

public class _172_FactorialTrailingZeros {
	public int trailingZeroes(int n) {
        int res = 0;
        while(n >= 5) {
            res += n / 5;
            n = n / 5;
        }
        return res;
    }
}
