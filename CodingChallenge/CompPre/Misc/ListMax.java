package Misc;

import java.util.Scanner;

public class ListMax {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        long[] diff = new long[N+1];
        
        for(int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int k = sc.nextInt();
            diff[a-1] += k;
            diff[b] -= k;
        }
        
        long max = 0;
        long preSum = 0;
        for(int i = 0; i <= N; i++) {
            preSum += diff[i];
            max = Math.max(max, preSum);
        }
       
        System.out.println(max);
    }

}
