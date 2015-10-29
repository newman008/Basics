package Sort;

public class HeapSort {
    
    public void heapSort(int[] nums) {
        int l = nums.length;
        for(int i = l / 2; i >= 1; i--) {
            sink(nums, i, l);
        }
        while(l > 1) {
            swap(nums, 1, l--);
            sink(nums, 1, l);
        }
        
    }
    
    private void sink(int[] nums, int i, int l) {
        while(2 * i <= l) {
            int j = 2 * i;
            if(j < l && nums[j-1] < nums[j]) j++;
            if(nums[i-1] > nums[j-1]) break;
            swap(nums, i, j);
            i = j;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i-1];
        nums[i-1] = nums[j-1];
        nums[j-1] = tmp;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        HeapSort t = new HeapSort();
        int[] nums = {2, 4, 6, 5, 3, 1};
        t.heapSort(nums);
        for(int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
