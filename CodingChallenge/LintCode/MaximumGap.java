package lintCode;

public class MaximumGap {
	class Bucket {
        int low;
        int high;
        public Bucket() {
            low = -1;
            high = -1;
        }
    }
    
    public int maximumGap(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        
        int min = 0;
        int max = 0;
        for(int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        int len = (max - min) / nums.length + 1;
        int numOfBuckets = (max - min) / len + 1;
        
        Bucket[] buckets = new Bucket[numOfBuckets];
        for(int i = 0; i < buckets.length; i++) {
            buckets[i] = new Bucket();
        }
        
        for(int num : nums) {
            int index = (num - min) / len;
            if(buckets[index].low == -1) {
                buckets[index].low = num;
                buckets[index].high = num;
            } else {
                buckets[index].low = Math.min(buckets[index].low, num);
                buckets[index].high = Math.max(buckets[index].high, num);
            }
        }
        
        int res = 0;
        int pre = 0;
        for(int i = 1; i < buckets.length; i++) {
            if(buckets[i].low != -1) {
                res = Math.max(res, buckets[i].low - buckets[pre].high);
                pre = i;
            }
        }
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumGap t = new MaximumGap();
		int[] nums = new int[]{3,2,1,4,3};
		t.maximumGap(nums);
	}

}
