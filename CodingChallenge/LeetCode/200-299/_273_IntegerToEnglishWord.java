package LeetCode2;
/*
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.
 * For example,
 * 123 -> "One Hundred Twenty Three"
 * 12345 -> "Twelve Thousand Three Hundred Forty Five"
 * 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * 
 */

public class _273_IntegerToEnglishWord {
    final String[] strs = {"Billion", "Million", "Thousand", ""};
    final String[] digits = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    final String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    public String numberToWords(int num) {
        String res = new String();
        
        int cur = num;
        int i = 3;
        if(cur == 0) return "Zero";
        while(cur > 0) {
            String tmp = helper(cur % 1000);
            
            if(i <= 2) {
                res = (tmp.length() == 0? "" : tmp + " " + strs[i]) + (res.length() == 0 ? "" : (tmp.length() == 0? "":" ")+ res);
            } else {
                res = tmp;
            }
            cur = cur / 1000;
            i--;
        }
        
        return res;
    }
    
    public String helper(int num) {
        String res = new String();
        
        if(num / 100 > 0) res = digits[num / 100] + " " + "Hundred";
        num = num % 100;
        if(num == 0) return res;
        if(res.length() != 0) res = res + " ";
        
        if(num < 20) {
            res += digits[num];
        } else {
            int ten = num / 10;
            int digit = num % 10;
            res += (ten == 0? "" :tens[ten]) + (digit == 0? "" : " " + digits[digit]);
        }
        
        return res;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
