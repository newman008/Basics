package LeetCode2;

public class _43_WildcardMatching {
    public boolean isMatch(String s, String p) {
        int si = 0;
        int pi = 0;
        int start = -1;
        int match = 0;
        
        while(si < s.length()) {
            if(pi < p.length() && (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?')) {
                si++;
                pi++;
            }
            else if (pi < p.length() && p.charAt(pi) == '*') {
                start = pi;
                pi++;
                match = si;
            }
            // else case is: either pi >= p.length() and si < s.length, or s.charAt(si) != p.chart(pi)
            else if (start != -1) {
                pi = start + 1;
                match++;
                si = match;
            }
            else
                return false;
        }
        
        while(pi < p.length() && p.charAt(pi) == '*') {
            pi++;
        }
        
        return pi == p.length();
    }
}
