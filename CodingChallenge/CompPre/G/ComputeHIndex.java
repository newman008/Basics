package InterviewQuestions;

import java.util.Arrays;

// f(A)=10, f(B)=8, f(C)=5, f(D)=4, f(E)=3　→ h-index=4
// f(A)=25, f(B)=8, f(C)=5, f(D)=3, f(E)=3　→ h-index=3
// h-index (f) = max_i (min (f(i), i))
public class ComputeHIndex {
    
    // if citation is already sorted in descending order
    public int getHIndex(int[] citation) {
        int lo = 0;
        int hi = citation.length-1;
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            if(citation[mid] == mid + 1) return citation[mid];
            else if(citation[mid] > mid + 1) lo = mid + 1;
            else hi = mid - 1;
        }
        
        return -1;
    }
    
    // not sorted, NlogN
    public int getHIndex2(int[] citation) {
        Arrays.sort(citation);
        int h = 0;
        for(int i = citation.length - 1; i >= 0; i--) {
            if(citation[i] > h) h++;
            else break;
        }
        
        return h;
    }
    
    // do not use sort, O(N)
    public int getHIndex3(int[] citation) {
        int n = citation.length;
        int[] s = new int[n+1];
        for(int num : citation) {
            num = Math.min(n, num);
            s[num]++;
        }
        int sum = 0;
        for(int i = n; i >= 0; i--) {
            sum += s[i];
            if(sum >= i) return i;
        }
        
        return -1;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ComputeHIndex t = new ComputeHIndex();
        int[] nums = {10, 8, 3, 5, 3};
        int res = t.getHIndex3(nums);
        System.out.print(res);
    }

}
