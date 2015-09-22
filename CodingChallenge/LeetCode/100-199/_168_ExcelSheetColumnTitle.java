package LeetCode2;

public class _168_ExcelSheetColumnTitle {
	public String convertToTitle(int n) {
        String res = "";
        
        while(n > 0) {
            n--;
            res = (char)(n%26 + 'A') + res;
            n = n / 26;
        }
        
        return res;
    }
}
