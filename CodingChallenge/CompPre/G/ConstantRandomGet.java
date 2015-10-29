package InterviewQuestions;
// Data structure: insert, remove, contains, get random element, all at O(1)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ConstantRandomGet {
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    private Random random = new Random(); 
    private List<Integer> array = new ArrayList<Integer>();
    
    public void insert(int num) {
        map.put(num, array.size());
        array.add(num);
    }
    
    public boolean contains(int num) {
        return map.containsKey(num);
    }
    
    public boolean remove(int num) {
        if(!map.containsKey(num)) return false;
        int index = map.get(num);
        
        int last = array.size() - 1;
        int lastNum = array.get(last);
        array.remove(array.size() - 1);
        array.set(index, lastNum);
        map.put(lastNum, index);
        map.remove(num);
        
        return true;
    }
    
    public int getRandom() {
        int size = array.size();
        if(size == 0) return 0;
        int index = random.nextInt(size);
        return array.get(index);
    }
    

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ConstantRandomGet t = new ConstantRandomGet();
        t.insert(7);
        t.insert(8);
        t.insert(3);
        t.insert(4);
        t.remove(8);
    }

}
