package LeetCode2;

public class _264_UglyNumber2 {
	// naive solution, O(N) where N is the total number from 1 to N that contains n ugly number
    public int nthUglyNumber(int n) {
        int count = 0;
        int i = 0;
        while(count < n) {
            i++;
            if(isUgly(i)){
                count++;
            }
        }
        
        return i;
    }
    
    public boolean isUgly(int num) {
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
    
 // dp solution
    public int nthUglyNumber2(int n) {
        int[] uglyNums = new int[n];
        uglyNums[0] = 1;
        
        int k2 = 0; 
        int k3 = 0;
        int k5 = 0;
        
        for(int i = 1; i < n; i++) {
            uglyNums[i] = Math.min(uglyNums[k2] * 2, Math.min(uglyNums[k3] * 3, uglyNums[k5] * 5));
            if(uglyNums[i] == uglyNums[k2] * 2) {
                k2++;
            }
            if(uglyNums[i] == uglyNums[k3] * 3) {
                k3++;
            }
            if(uglyNums[i] == uglyNums[k5] * 5) {
                k5++;
            }
        }
        
        return uglyNums[n-1];
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    		_264_UglyNumber2 s = new _264_UglyNumber2();
    		System.out.print(s.nthUglyNumber2(11));
	}
}
