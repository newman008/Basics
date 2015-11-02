package InterviewQuestions;

// Find the second largest number in a given array.
// Return 0 if the given array has no second largest number.

public class SecondLargestNumber {
    
    public int secondLargest(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        int first = Math.max(nums[0], nums[1]);
        int second = Math.min(nums[0], nums[1]);
        
        for(int i = 2; i < nums.length; i++) {
            if(nums[i] > first) {
                second = first;
                first = nums[i];
            } else if (nums[i] < first && nums[i] > second) {
                second = nums[i];
            }
        }
        if(first == second) return 0;
        
        return second;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
