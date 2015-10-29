package InterviewQuestions;

import java.util.Arrays;

public class FlipGame {
    
    public boolean canWin(char[] s) {
        int pre = -1;
        for(int i = 0; i < s.length; i++) {
            if(s[i] == '+'){
                if(pre != -1) {
                    char[] t = Arrays.copyOf(s, s.length);
                    t[i] = '-';
                    t[pre] = '-';
                    if(!canWin(t)) return true; 
                    pre++;
                } else {
                    pre = i;
                }
            } else 
                pre = -1;
        }
        return false;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        FlipGame t = new FlipGame();
        char[] s = "++--+++--++".toCharArray();
        System.out.print(t.canWin(s));
    }

}
