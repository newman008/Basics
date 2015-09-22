package LeetCode2;

public class _209_MinimumSizeSubarraySum {
	public int minSubArrayLen2(int s, int[] nums) {
        int sum = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while(sum >= s) {
                minLen = Math.min(minLen, i-start+1);
                sum = sum - nums[start];
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
	
	public int minSubArrayLen(int s, int[] nums) {
        int[] sums = new int[nums.length+1];
        for(int i = 1; i < sums.length; i++) sums[i] = sums[i-1] + nums[i-1];
        int minLen = Integer.MAX_VALUE;
        
        for(int i = 0; i < sums.length; i++) {
            int end = binarySearch(i+1, sums.length-1, sums[i] + s, sums);
            if (end == sums.length) break;
            if(end - i< minLen) minLen = end - i;
        }
        
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
    
    private int binarySearch(int lo, int hi, int key, int[] nums) {
        while(lo <= hi) {
            int mid = (lo+hi)/2;
            if(nums[mid] == key) return mid;
            else if(nums[mid] > key) hi = mid - 1;
            else 
                lo = mid + 1;
        }
        return lo;
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    		_209_MinimumSizeSubarraySum t = new _209_MinimumSizeSubarraySum();
    		int[] nums = {1, 5, 6};
		System.out.print(t.minSubArrayLen(4, nums));
	}
}
