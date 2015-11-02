package InterviewQuestions;

/*
Find the longest continuous subsequence of 1's in binary representation of an integer.
*/

public class LongtestConsecutive1sBinary {

    public int countConsecutive1s(int n) {
        int c = 0;
        while(n != 0) {
            n = n & (n>>1);
            c++;
        }
        return c;
    }
        
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LongtestConsecutive1sBinary t = new LongtestConsecutive1sBinary();
        System.out.print(t.countConsecutive1s(1026));
    }

}
