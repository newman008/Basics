package LeetCode2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class _71_SimplifyPath {
    public String simplifyPath(String path) {
        // ".."     pop
        // "."      skip
        // "other"  push
        // corner case: /../ ==> /
        // corner case: /home//foo/ ==> /home/foo
        LinkedList<String> stack = new LinkedList<String>();
        Set<String> skip = new HashSet<String>(Arrays.asList("..",".",""));
        
        for(String dir : path.split("/")) {
            if(dir.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if(!skip.contains(dir)) {
                stack.push(dir);
            }
        }
        
        String res = "";
        for (String dir : stack) {
            res = "/" + dir + res;
        }
        
        return res.isEmpty() ? "/" : res;
    }
}
