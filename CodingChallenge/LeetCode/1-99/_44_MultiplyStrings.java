package LeetCode2;

public class _44_MultiplyStrings {
    public String multiply(String num1, String num2) {
        String n1 = new StringBuffer(num1).reverse().toString();
        String n2 = new StringBuffer(num2).reverse().toString();
        
        int[] temp = new int[num1.length() + num2.length()];
        for(int i = 0; i < n1.length(); i++) {
            for(int j = 0; j < n2.length(); j++) {
                temp[i+j] += (n1.charAt(i) - '0') * (n2.charAt(j) - '0');
            }
        }
        
        StringBuffer res = new StringBuffer();
        
        for(int i = 0; i < temp.length; i++) {
            int digit = temp[i] % 10;
            int carry = temp[i] / 10;
            if(i + 1 < temp.length) temp[i+1] += carry;
            res.insert(0, digit);
        }
        
        while(res.charAt(0) == '0' && res.length() > 1) {
            res.deleteCharAt(0);
        }
        
        return res.toString();
    }
}
