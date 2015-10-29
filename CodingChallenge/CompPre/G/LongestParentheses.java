package InterviewQuestions;

public class LongestParentheses {
    
    public int maxLength(String s) {
        int max = 0;
        boolean finished = false;
        int count = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                count++;
            } else {
                count--;
                //
            }
        }
        
        return max;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LongestParentheses solution = new LongestParentheses();
        // (())
        System.out.println(solution.maxLength("()()()()"));
        System.out.println(solution.maxLength("(()()()())"));
    }

}
