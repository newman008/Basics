package Sort;

public class BubbleSort {
	
	public void bubbleSort(int[] nums) {
		
		int l = nums.length;
		boolean isSwapped = false;
		for(int i = 0; i < l; i++) {
			for(int num : nums) {
				System.out.print(num+" ");
			}
			System.out.println();
			for(int j = 1; j < l - i; j++) {
				if(nums[j] < nums[j-1]){
					swap(nums, j, j-1);
					isSwapped = true;
				}
			}
			if(!isSwapped) break;
			isSwapped = false;
		}
		
//		for(int num : nums) {
//			System.out.print(num+" ");
//		}
	}
	
	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BubbleSort t = new BubbleSort();
		int[] nums = {-1, 0, 1, 2, 3, 4, 5, 6};
		t.bubbleSort(nums);
	}

}
