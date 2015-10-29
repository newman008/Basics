package Sort;

public class ShellSort {
    
    public void sort(int[] nums) {
        int N = nums.length;
        int h = 1;
        while(h < N / 3) h = h * 3 + 1;
        
        while(h >= 1) {
            System.out.println(h);
            for(int i = h; i < N; i++) {
                for(int j = i; j >= h && nums[j] < nums[j-h]; j = j - h) {
                    swap(nums, j, j-h);
                }
            }
            for(int num : nums) {
                System.out.print(num + " ");
            }
            System.out.println();
            
            h = h / 3;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ShellSort t = new ShellSort();
        int[] nums = {2, 4, 6, 5, 3, 1, 11, 12, 13, 15, 16, 17, 100, 18, 21, 22};
        t.sort(nums);

    }

}
