package Facebook;

import java.util.*;

/*
 * In a party of N people, only one person is known to everyone. 
 * Such a person may be present in the party, if yes, (s)he doesn’t know anyone in the party. 
 * We can only ask questions like “does A know B? “. Find the stranger (celebrity) in minimum number of questions.
 * We can describe the problem input as an array of numbers/characters representing persons in the party. 
 * We also have a hypothetical function HaveAcquaintance(A, B) which returns true if A knows B, false otherwise. 
 * How can we solve the problem, try yourself first.
 */

public class CelebrityProblem {
    
    static int size = 4;
    static int matrix[][] = {{0,0,1,0},  
                             {0,0,1,0},  
                             {0,0,0,0},  
                             {0,0,1,0}};
    
    public static boolean haveAcquiantance(int a, int b){  
        return matrix[a][b] != 0;  
    }  
    
    public static int celebrity(int size){
        Stack<Integer> stack = new Stack<Integer>();
        int C = -1;
        for(int i = 0; i < size; i++) stack.push(i);
        
        int A = stack.pop();
        int B = stack.pop();
        while(stack.size() > 1) {
            if(haveAcquiantance(A, B)){ // if A knows B
                A = stack.pop();
            } else {
                B = stack.pop();
            }
        }
        
        C = stack.pop();
        if(haveAcquiantance(C, B)){  
            C = B;  
        }  
        if(haveAcquiantance(C, A)){  
            C = A;  
        }  
        
        for(int i = 0; i < size; i++){
                if(C == i) continue;
                if(haveAcquiantance(C, i) || !haveAcquiantance(i, C)) return -1;
        }
        
        return C;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(CelebrityProblem.celebrity(size));
    }

}
