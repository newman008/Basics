package LeetCode2;

public class _135_Candy {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) return 0;
        
        int[] candy = new int[ratings.length];
        candy[0] = 1;
        
        for(int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i-1]) candy[i] = candy[i-1] + 1;
            else 
                candy[i] = 1;
        }
        
        int result = candy[ratings.length - 1];
        
        for(int i = ratings.length - 2; i >= 0; i--) {
            int cur = 1;
            if(ratings[i] > ratings[i+1]) {
                cur = candy[i+1] + 1;
            }
            
            result += Math.max(cur, candy[i]);
            candy[i] = cur;
        }
        
        return result;
    }
}
