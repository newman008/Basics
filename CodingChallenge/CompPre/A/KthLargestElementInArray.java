package Amazon;
/*
 * 1. sort and get
 * 2. priority queue
 * 3. quick select
 * 
 */

public class KthLargestElementInArray {
    
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || k < 1) return 0;
        return findKth(nums, nums.length - k + 1, 0, nums.length - 1);
    }
    
    public int findKth(int[] nums, int k, int start, int end) {
        int pivot = nums[end];
        int left = start;
        int right = end;
        while(left < right) {
            while(nums[left] < pivot && left < right) left++;
            while(nums[right] > pivot && left < right) right--;
            if(left == right) break;
            swap(nums, left, right);
        }
        swap(nums, left, end);
        
        if(k == left+1){
            return pivot;
        } else if(k > left + 1) {
            return findKth(nums, k, left+1, end);
        } else 
            return findKth(nums, k, start, left-1);
    }
    
    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
