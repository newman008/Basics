package LeetCode2;

public class _29_DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
        // handle overflow
        if(divisor == 1) return dividend;
        if(dividend == Integer.MIN_VALUE && Math.abs(divisor) == 1) return Integer.MAX_VALUE;
        
        int sign;
		if((dividend > 0) == (divisor > 0))
			sign = 1;
		else 
			sign = -1;
			
		int x = - Math.abs(dividend);
		int y = - Math.abs(divisor);
		
		int res = 0;
		while(x <= y){
		    int temp = y;
		    int step = 1;
		    
		    while(x <= temp) {
		        x = x - temp;
		        res = res + step;
		        if(temp >= -2 << 29) {
		            temp = temp << 1;
		            step = step << 1;
		        }
		    }
		}
		
		return sign * res;
    }
}
