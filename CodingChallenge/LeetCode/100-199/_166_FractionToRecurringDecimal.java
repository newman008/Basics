package LeetCode2;

import java.util.HashMap;
import java.util.Map;

public class _166_FractionToRecurringDecimal {
	public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";
        if(denominator == 0) return "";
        
        StringBuilder sb = new StringBuilder();
        if((numerator < 0) ^ (denominator < 0)) sb.append("-");
        
        Long n = new Long(numerator);
        Long d = new Long(denominator);
        n = Math.abs(n);
        d = Math.abs(d);
        sb.append(Long.toString(n / d));
        if(n % d == 0)
            return sb.toString();
        else
            sb.append(".");
        
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        Long r = n % d;
        while(r != 0) {
            if(map.containsKey(r)){
                sb.insert(map.get(r), "(");
                sb.append(")");
                break;    
            }
            map.put(r, sb.length());
            r = r*10;
            sb.append(Long.toString(r / d));
            r = r % d;
        }
        
        return sb.toString();
    }
}
