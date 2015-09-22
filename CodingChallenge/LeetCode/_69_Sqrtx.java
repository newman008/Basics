package LeetCode2;

public class _69_Sqrtx {
	public int mySqrt(int x) {
        if(x == 0 || x == 1) return x;
        
        int l = 0;
        int r = x / 2 + 1;
        int res = 0;
        while(l <= r) {
            int mid = (l + r) / 2;
            if(mid <= x / mid && x/(mid+1) < mid+1) return mid;
            else if(mid > x / mid) r = mid - 1;
            else {
                l = mid + 1;
            }
        }
        
        return 0;
    }
}
