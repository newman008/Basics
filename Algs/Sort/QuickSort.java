package Sort;

public class QuickSort {
	
	public void sort(int[] nums) {
		quickSort(nums, 0, nums.length - 1);
	}
	
	public void quickSort(int[] nums, int lo, int hi) {
		if(hi <= lo) return;
		int j = partition(nums, lo, hi);
		quickSort(nums, lo, j-1);
		quickSort(nums, j+1, hi);
		
	}
	
	private int partition(int[] nums, int lo, int hi) {
		int i = lo+1; 
		int j = hi;
		int pivot = nums[lo];
		while(i <= j) {
			while(i <= j && nums[i] < pivot) {
				i++;
			}
			while(nums[j] > pivot) {
				j--;
			}
			if(i > j) break;
			swap(nums, i, j);
		}
		swap(nums, lo, j);
		for(int num : nums) {
			System.out.print(num + " ");
		}
		System.out.println();
		return j;
	}
	
	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickSort t = new QuickSort();
		int[] nums = {2, 4, 6, 5, 3, 1};
		t.sort(nums);
		
	}

}
