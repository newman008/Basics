package Amazon;
/*
 * 最后一轮第二道题是 给定阿拉伯数字的串，要求输出它的中文表示
 * 9909 －》 九千九百零九
 * 其中阿拉伯数字最长8位
 */

public class ChineseStringFromNumber {
	
	public static String convertToChinese(int num) {
		String[] thousands = {"", "一千", "二千", "三千", "四千", "五千", "六千", "七千", "八千", "九千"};
		String[] hundreds = {"", "一百", "二百", "三百", "四百", "五百", "六百", "七百", "八百", "九百"};
		String[] tens = {"", "一十", "二十", "三十", "四十", "五十", "六十", "七十", "八十", "九十"};
		String[] digits = {"", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
		
		String th = thousands[num/1000];
		String h = hundreds[(num % 1000) / 100] == "" ? "零":hundreds[(num % 1000) / 100];
		String t = tens[(num % 100) / 10] == "" ? "零": tens[(num % 100) / 10];
		String d = digits[num % 10];
		
		return th + h + t + d; 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ChineseStringFromNumber.convertToChinese(9909));
	}

}
