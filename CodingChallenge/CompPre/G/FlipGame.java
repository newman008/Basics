package InterviewQuestions;
/*
算法游戏，给一个只有＋－两种字符的array，两个玩家，轮到某个玩家他可以任选
两个连续的＋＋将他们变成－－，如果某个玩家发现对方无法行动则赢得游戏，要求写
canWin（String s）判断先行动的玩家能否赢。
*/

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
