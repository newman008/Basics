package lintCode;

public class ReverseInteger {
    public int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        int res = 0;
        x = Math.abs(x);
        while(x > 0) {
            if(res > Integer.MAX_VALUE / 10) return 0;
            res = res * 10 + x % 10;
            x = x / 10;
        }
        
        return res * sign;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ReverseInteger t = new ReverseInteger();
        System.out.print(t.reverse(1463847412));
    }

}
