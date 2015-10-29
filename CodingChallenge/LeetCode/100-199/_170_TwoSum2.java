package LeetCode2;

public class _170_TwoSum2 {
    
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        
        for(int i = 0; i < numbers.length - 1; i++) {
            int num = target - numbers[i];
            
            int lo = i+1;
            int hi = numbers.length - 1;
            while(lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if(numbers[mid] == num) {
                    res[0] = i+1;
                    res[1] = mid+1;
                    return res;
                } else if(numbers[mid] < num) {
                    lo = mid+1;
                } else {
                    hi = mid-1;
                }
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
