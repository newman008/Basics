package lintCode;

public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
        if(divisor == 1) return dividend;
        if(divisor == 0) return Integer.MAX_VALUE;
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if(divisor == Integer.MIN_VALUE) return 0;
        if(dividend == 0) return 0;
        
        int sign;
        if((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0))
            sign = 1;
        else 
            sign = -1;
        
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        
        int res = 0;
        while(divisor <= dividend) {
            int fact = 1;
            int cur = divisor;
            while(cur <= dividend) {
                dividend = dividend - cur;
                res += fact;
                if(cur <= 2 << 29) {
                    cur = cur + cur;
                    fact = fact + fact;
                }
            }
        }
        
        return res * sign;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DivideTwoIntegers t = new DivideTwoIntegers();
		t.divide(-2147483648, 2);
	}

}
