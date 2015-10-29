package LeetCode2;

public class _227_BasicCalculator2 {
    
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        s = s.trim().replace(" ", "");
//      System.out.println(s);
        
        int res = 0;
        int pre = 0;
        char sign = '+';
        
        for(int i = 0; i < s.length(); i++) {
            int cur = 0;
            while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                cur = cur * 10 + s.charAt(i) - '0';
                i++;
            }
            
            if(sign == '+'){
                res = res + pre;
                pre = cur;
            } else if(sign == '-'){
                res = res + pre;
                pre = -cur;
            } else if(sign == '*'){
                pre = pre * cur;
            } else if(sign == '/') {
                pre = pre / cur;
            }
            
            if(i < s.length())
                sign = s.charAt(i);
        }
        
        res += pre;
        return res;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        _227_BasicCalculator2 solution = new _227_BasicCalculator2();
        System.out.println(solution.calculate("5 + 7 / 2 "));
    }

}
