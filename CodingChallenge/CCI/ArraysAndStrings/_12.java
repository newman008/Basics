package ArraysAndStrings;

public class _12 {
    public static String reverse(String str) {
        char[] res = str.toCharArray();
        char temp;
        for(int i = 0, j = str.length() - 1; i < j; i++, j--) {
            temp = res[i];
            res[i] = res[j];
            res[j] = temp;
        }
        
        return new String(res);
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.print(reverse("abdcss"));
    }
}
