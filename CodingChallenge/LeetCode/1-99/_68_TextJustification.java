package LeetCode2;

import java.util.ArrayList;
import java.util.List;

public class _68_TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();
        int covered = 0;
        int last = 0;
        
        for(int i = 0; i < words.length; i++) {
            if(covered + words[i].length() + (i-last) > maxWidth) {
                int space = 0;
                int extra = 0;
                if(i-last-1 > 0) {
                    space = (maxWidth - covered) / (i-last-1);
                    extra = (maxWidth - covered) % (i-last-1);
                }
                
                StringBuffer str = new StringBuffer();
                for(int j = last; j < i; j++) {
                    str.append(words[j]);
                    if(j < i - 1) {
                        for(int k = 0; k < space; k++) {
                            str.append(" ");
                        }
                        if(extra > 0) {
                            str.append(" ");
                        }
                        extra--;
                    }
                }
                
                // handle only one word in a line case
                for(int j=str.length();j<maxWidth;j++)  
                {  
                    str.append(" ");  
                }
                
                res.add(str.toString());
                covered = 0;
                last = i;
            }
            covered += words[i].length();
        }
        
        StringBuilder lastline = new StringBuilder();  
        for(int i=last;i<words.length;i++)  
        {  
                lastline.append(words[i]);  
            if(lastline.length() < maxWidth)  
                    lastline.append(" ");  
        }  
        for(int i=lastline.length();i < maxWidth;i++)  
        {  
                lastline.append(" ");  
        } 
        res.add(lastline.toString());
        return res;
    }
}
