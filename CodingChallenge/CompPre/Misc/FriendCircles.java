package Misc;

public class FriendCircles {
	
	static int friendCircles(String[] friends) {
        // Union Find
        int n = friends.length;
        int[] array = new int[n];
        for(int i = 0; i < n; i++) {
            array[i] = i;
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                if(friends[i].charAt(j) == 'Y'){
                    int x = root(array, i);
                    int y = root(array, j);
                    array[x] = y;
                }
            }
        }
        
        int res = 0;
        for(int i = 0; i < n; i++) {
            if(array[i] == i) res += 1;
        }
        
        return res;

    }

    static int root(int[] nums, int i) {
        while(nums[i] != i){
            i = nums[i];
        }
        return i;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] friends = {"YYNN", "YYYN", "NYYN", "NNNY"};
		int res = FriendCircles.friendCircles(friends);
		System.out.println(res);
	}

}
