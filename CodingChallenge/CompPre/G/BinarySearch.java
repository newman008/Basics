package InterviewQuestions;

public class BinarySearch {
	
	public int search(int[] nums, int num) {
		if(nums == null || nums.length == 0) return -1;
		
		int lo = 0;
		int hi = nums.length - 1;
		while(lo <= hi) {
			int mid = (lo + hi) / 2;
			if(nums[mid] == num) return mid;
			else if(nums[mid] < num) lo = mid+1;
			else hi = mid - 1;
		}
		
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{1,2,3,4,5,6};
		BinarySearch bs = new BinarySearch();
		System.out.println(bs.search(nums, 4));
	}

}
