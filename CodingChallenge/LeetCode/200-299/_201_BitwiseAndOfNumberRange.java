package LeetCode2;

public class _201_BitwiseAndOfNumberRange {
    public int rangeBitwiseAnd(int m, int n) {
        if(m == 0) return 0;
        int step = 0;
        while(m != n) {
            m = m >> 1;
            n = n >> 1;
            step++;
        }
        return n << step;
    }
}
