package LeetCode2;

public class _67_AddBinary {
	public String addBinary(String a, String b) {
        StringBuffer res = new StringBuffer();
        int carry = 0;
        int acur = 0;
        int bcur = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        for(; i>=0 || j>=0; i--, j--) {
            acur = (i >= 0? a.charAt(i) - '0': 0);
            bcur = (j >= 0? b.charAt(j) - '0': 0);
            int cur = (acur + bcur + carry) % 2;
            carry = (acur + bcur + carry) / 2;
            res = res.insert(0, cur);
        }
        if(carry == 1) res.insert(0, 1);
        return res.toString();
    }
}
