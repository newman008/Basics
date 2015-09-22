package Sort;

public class MergeSort {
	
	public void mergeSort(int[] nums) {
		int[] copy = new int[nums.length];
		sort(nums, copy, 0, nums.length - 1);
	}
	
	public void sort(int[] nums, int[] copy, int lo, int hi) {
		if(lo >= hi) return;
		int mid = (lo + hi) / 2;
		sort(nums, copy, lo, mid);
		sort(nums, copy, mid+1, hi);
		merge(nums, copy, lo, mid, hi);
		for(int num : nums) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
	
	public void merge(int[] nums, int[] copy, int lo, int mid, int hi) {
		for(int i = lo; i <= hi; i++) {
			copy[i] = nums[i];
		}
		
		int i = lo;
		int j = mid+1;
		for(int k = lo; k <= hi; k++) {
			if(i > mid) nums[k] = copy[j++];
			else if(j > hi) nums[k] = copy[i++];
			else if(copy[i] < copy[j]) nums[k] = copy[i++];
			else nums[k] = copy[j++];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeSort t = new MergeSort();
		int[] nums = {2, 4, 6, 5, 3, 1};
		t.mergeSort(nums);
	}

}
