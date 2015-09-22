package LeetCode2;
/*
 * Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?
 */

public class _275_HIndex2 {
	public int hIndex(int[] citations) {
        int h = 0;
        int n = citations.length;
        for(int i = n-1; i >= 0; i--) {
        		if(citations[i] > h) h++;
        		else break;
        }
        return h;
    }
}
