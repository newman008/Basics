package LeetCode2;

public class _65_ValidNumber {
	public boolean isNumber(String s) {
        s = s.trim();
        if(s.length() == 0) return false;
        
        boolean hasNum = false;
        boolean hasDot = false;
        boolean hasE = false;
        boolean hasNumAfterE = true;
        
        for(int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if(tmp <= '9' && tmp >= '0') {
                hasNum = true;
                hasNumAfterE = true;
            } else if (tmp == '.') {
                if(hasDot || hasE) return false;
                hasDot = true;
            } else if (tmp == 'e' || tmp == 'E') {
                if(hasE || !hasNum) return false;
                hasE = true;
                hasNumAfterE = false;
            } else if (tmp == '+' || tmp == '-') {
                if(i != 0 && s.charAt(i-1) != 'e')
                    return false;
            } else {
                return false;
            }
        }
        
        return hasNum && hasNumAfterE;
    }
}
