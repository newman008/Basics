package Amazon;

import java.util.*;
/*
 * 第二轮 leetcode那个letter combination的变形，然后让输出valid word。
 * 我说的把所有单词都存入hashmap，然后查找是否valid
 */

public class LetterCombination {
	
	final static String[] strings = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}; 
	
	public static boolean letterCombinations(String digits, String s) {
        List<String> list = new ArrayList<String>();
        for(int i = 0; i < digits.length(); i++) {
        		char ch = digits.charAt(i);
        		int index = ch - '0';
        		List<String> tmp = new ArrayList<String>();
        		if(list.size() == 0){
        			for(char c : strings[index].toCharArray()){
        				tmp.add(c + "");
        			}
        		} else {
        			for(String str : list) {
        				for(char c : strings[index].toCharArray()){
        					tmp.add(str + c);
        				}
        			}
        		}
        		list = tmp;
        }
        
        for(String str : list) {
        		if(str.equals(s)) return true;
        }
		
		return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean res = LetterCombination.letterCombinations("234", "afg");
		System.out.println(res);
	}

}
