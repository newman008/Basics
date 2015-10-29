package Sort;

public class SelectionSort {
    
    public void selectionSort(int[] nums) {
        int l = nums.length;
        for(int i = 0; i < l; i++) {
            int minIndex = i;
            for(int j = i+1; j < l; j++) {
                if(nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
        for(int num : nums) {
            System.out.print(num);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SelectionSort t = new SelectionSort();
        int[] nums = {2, 4, 6, 5, 3, 1};
        t.selectionSort(nums);
    }

}
