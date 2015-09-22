package LeetCode2;

public class _263_UglyNumber {
	
	// Naive solution
	public boolean isUgly(int num) {
        if(num <= 0) return false;
        if(num == 1) return true;
        
        if(num % 5 == 0) return isUgly(num / 5);
        else if(num % 3 == 0) return isUgly(num / 3);
        else if(num % 2 == 0) return isUgly(num / 2);
        else
            return false;
    }
	
	// Time Complexity: O(logN)
    public boolean isUgly2(int num) {
        if(num <= 0) return false;
        if(num == 1) return true;
        
        num = divideMax(num, 2);
        num = divideMax(num, 3);
        num = divideMax(num, 5);
        
        return num == 1? true : false;
    }
    
    private int divideMax(int num, int factor) {
        while(num % factor == 0){
            num = num / factor;
        }
        return num;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
