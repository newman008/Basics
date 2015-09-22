package InterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ambigram {
	
	public boolean isAmbigram(String s) {
		StringBuilder sb = new StringBuilder();
		for(int i = s.length() - 1; i >= 0; i--) {
			char ch = s.charAt(i);
			if(ch == '9') sb.append("6");
			else if(ch == '6') sb.append("9");
			else if(ch == '1') sb.append(ch);
			else if(ch == '8') sb.append(ch);
			else if(ch == '0') sb.append(ch);
			else return false;
		}
		
		return sb.toString().equals(s);
	}
	
	public List<String> genAmbigram(int n) {
		List<String> res = new ArrayList<String>();
		if(n == 1) return Arrays.asList("0", "1", "8");
		else if(n == 2) return Arrays.asList("00", "11", "88", "69", "96");  
		
		List<String> list = genAmbigram(n-2);
		for(String s : list) {
			res.add('0' + s + '0');
			res.add('1' + s + '1');
			res.add('8' + s + '8');
			res.add('6' + s + '9');
			res.add('9' + s + '6');
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ambigram a = new Ambigram();
		System.out.print(a.isAmbigram("609"));
	}

}
