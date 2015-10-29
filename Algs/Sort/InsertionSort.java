package Sort;

public class InsertionSort {
    
    public void insertSort(int[] nums) {
        int l = nums.length;
        
        for(int i = 1; i < l; i++) {
            int insertNum = nums[i];
            int j = i;
            for(j = i; j > 0; j--) {
                if(insertNum < nums[j-1]) {
                    nums[j] = nums[j-1];
                } else {
                    break;
                }
            }
            nums[j] = insertNum;
        }
        
        for(int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        InsertionSort t = new InsertionSort();
        int[] nums = {2, 4, 6, 5, 3, 1};
        t.insertSort(nums);
    }   

}
