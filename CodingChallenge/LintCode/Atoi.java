package lintCode;

public class Atoi {
	public int myAtoi(String str) {
        if(str == null || str.length() == 0) return 0;
        str = str.trim();
        
        int sign = 1;
        int i = 0;
        if(str.charAt(0) == '+') {
            sign = 1;
            i++;
        } else if(str.charAt(0) == '-') {
            sign = -1;
            i++;
        }
        
        int res = 0;
        while(i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && str.charAt(i) > '7')){
                if(sign == 1) return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }
            
            res = res * 10 + (str.charAt(i) - '0');
            i++;
        }
        
        return sign * res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Atoi t = new Atoi();
		int res = t.myAtoi("-2147483648");
		System.out.print(res);
	}

}
