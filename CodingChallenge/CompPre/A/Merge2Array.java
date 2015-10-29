package Amazon;

public class Merge2Array {
    
    static void mergeArray(int []a, int []b, int M ){
        // use two pointers
        int p = M - 1; // pointer of first array
        int q = M - 1; // pointer of second array
        for(int i = 2 * M - 1; i >= 0 && p >= 0 && q >= 0; i--) {
            if(a[p] >= b[q]) {
                b[i] = a[p];
                p--;
            } else {
                b[i] = b[q];
                q--;
            }
        }
        
        if(p >= 0) {
            for(int j = 0; j <= q; j++) {
                b[j] = a[j];
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {3, 5, 6, 9, 12, 14, 18, 20, 25, 28};
        int[] b = {30, 32, 34, 36, 38, 40, 42, 44, 46, 48};
        Merge2Array.mergeArray(a, b, 10);
    }

}
