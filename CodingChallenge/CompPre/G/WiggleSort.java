package InterviewQuestions;
// [1,2,3,4,5] => [1, 3, 2, 5, 4] a[0] <= a[1] >= a[2] <= a[3] >= a[4]
public class WiggleSort {
    
    public void wiggle_sort(int[] nums) {
        if(nums == null || nums.length == 0) return;
        
        int l = nums.length;
        boolean isInc = true;
        for(int i = 1; i < l; i++) {
            if((isInc && nums[i] >= nums[i-1]) || (!isInc && nums[i] <= nums[i-1])){
                
            } else {
                swap(nums, i, i-1);
            }
            isInc = !isInc;
        }
        
    }
    
    public void wiggle_sort2(int[] nums) {
        if(nums == null || nums.length == 0) return;
        
        int l = nums.length;
        boolean isInc = true;
        int pre = nums[0];
        for(int i = 1; i < l; i++) {
            if((isInc && pre <= nums[i]) || (!isInc && pre >= nums[i])){
                nums[i-1] = pre;
                pre = nums[i];
            } else {
                nums[i-1] = nums[i];
            }
            isInc = !isInc;
        }
        
        nums[l-1] = pre;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        WiggleSort t = new WiggleSort();
        int[] nums = new int[]{1,2,5,1,3};
        t.wiggle_sort2(nums);
        for(int num : nums) {
            System.out.print(num);
        }
    }

}
