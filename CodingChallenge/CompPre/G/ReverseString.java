package InterviewQuestions;

public class ReverseString {
    
    public void reverse(char[] s) {
        reverse(s, 0, s.length-1);
        int i = 0; 
        int j = 0;
        for(;j < s.length; j++) {
            if(s[j] == ' ') {
                reverse(s, i, j-1);
                i = j + 1;
            }
        }
        reverse(s, i, s.length - 1);
        
    }
    
    private void reverse(char[] s, int lo, int hi) {
        while(lo < hi) {
            char tmp = s[lo];
            s[lo] = s[hi];
            s[hi] = tmp;
            lo++;
            hi--;
        }
    }
    
    public void reverse2(char[] s) {
        String str = new String(s);
        String[] strs = str.split("[a-z]{1,}");
        System.out.println(strs.length);
        for(String s1 : strs) {
            System.out.print(s1 + "*");
        }
        System.out.println();
        
        int r = str.length();
        String res = "";
        int i = 1;
        for(int l = s.length - 1; l >= 0; l--) {
            if(!(s[l] >= 'a' && s[l] <= 'z')){
                res += str.substring(l+1, r);
                while(!(s[l] >= 'a' && s[l] <= 'z')) {
                    l--;
                }
                r = l+1;
                res += strs[i];
                i++;
            }
        }
        
        res += str.substring(0, r);
        System.out.println(res);
//      System.out.print(sb.toString());
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ReverseString solution = new ReverseString();
        String s = "this,,,is.a word";
        char[] chrr = s.toCharArray();
        solution.reverse2(chrr);
//      for(char ch : chrr) {
//          System.out.print(ch);
//      }
    }

}
