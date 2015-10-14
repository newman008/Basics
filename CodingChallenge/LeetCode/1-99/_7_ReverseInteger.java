package LeetCode2;

public class _7_ReverseInteger {
    public int reverse(int x) {
        int res = 0;
        int sign = x > 0 ? 1:-1;
        x = Math.abs(x);
        while(x != 0) {
            if(res > Integer.MAX_VALUE / 10 || (Integer.MAX_VALUE - x % 10) / 10 < res) {
                return 0;
            }
//          int newRes = res * 10 + x % 10;
//          if((newRes - x % 10) / 10 != res)
//              return 0;
//          res = newRes ;
            res =  res * 10 + x % 10;
            x = x / 10;
        }
        return res*sign;
    }
}
