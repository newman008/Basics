package leetcode;

/** Problem:
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/

/** Analysis:
Time  complexity: O(N)
Space complexity: O(N)
*/

import java.util.*;

public class _006_zigzag_conversion {
    
    public String convert(String s, int numRows) {
        StringBuilder[] res = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++) res[i] = new StringBuilder();

        char[] ch = s.toCharArray();
        int l = s.length();
        int i = 0;
        while ( i < l ) {
            for(int j = 0; j < numRows && i < l; j++) {
                res[j].append(ch[i]);
                i++;
            }
            for(int j = numRows - 2; j > 0 && i < l; j--) {
                res[j].append(ch[i]);
                i++;
            }
        }

        StringBuilder result = new StringBuilder();
        for(int j = 0; j < numRows; j++) result.append(res[j]);

        return result.toString();
    }

    public static void main(String[] args) {
        _006_zigzag_conversion s = new _006_zigzag_conversion();
        System.out.println(s.convert("PAYPALISHIRING", 3));
    } 
}


