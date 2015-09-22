package InterviewQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CompareMap {
	// The values of the maps could two types:
	  // 1. Strings
	  // 2. Map<String, Object> objects
	  private boolean equal(Map<String, Object> m1, Map<String, Object> m2) {
	    if(m1 == null && m2 == null) return true;
	    if(m1 == null || m2 == null) return false;
	    
	    Set<String> key1 = m1.keySet();
	    Set<String> key2 = m2.keySet();
	    if(key1.size() != key2.size()) return false;
	    
	    // convert set to array
	    ArrayList<String> keyArray1 = new ArrayList<String>();
	    ArrayList<String> keyArray2 = new ArrayList<String>();
	    
	    for(String str : key1)
	      keyArray1.add(str);
	    for(String str : key2)
	      keyArray2.add(str);
	    
	    
	    for(int i = 0; i < keyArray1.size(); i++) {
	      String tmpKey = keyArray1.get(i);
	      
	      if(m2.containsKey(tmpKey)) {
	        if(m1.get(tmpKey).getClass().getName().equals("java.util.HashMap")){
	          if(m1.get(tmpKey).equals(m2)) return false;
	          return equal((Map<String, Object>)m1.get(tmpKey), (Map<String, Object>)m2.get(tmpKey));  
	        }
	        else if(!m1.get(tmpKey).equals(m2.get(tmpKey))) {
	          return false;
	        } else {
	          continue;
	        }
	      } else {
	        return false;
	      }
	    }
	    
	    return true;
	  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompareMap solution = new CompareMap();
	    Map<String, Object> m1 = new HashMap<String, Object>();
	    Map<String, Object> m2 = new HashMap<String, Object>();
	    Map<String, Object> m3 = new HashMap<String, Object>();
	    Map<String, Object> m4 = new HashMap<String, Object>();
	    
	    /*m1.put("key1", "value1");
	    m1.put("key2", "value2");
	    
	    m2.put("key1", "value1");
	    m2.put("key2", "value2");
	    
	    Map<String, Object> v1 = new HashMap<String, Object>();
	    v1.put("nestedKey1", "nestedValue1");
	    Map<String, Object> v2 = new HashMap<String, Object>();
	    v2.put("nestedKey1", "nestedValue2");
	    m1.put("key3", v1);
	    m2.put("key3", v2);*/
//	     m1.put("a", m3);
//	     m2.put("a", m4);
//	     m1.put("b", m3);
//	     m2.put("b", m4);
	    m1.put("a", m2);
	    m2.put("a", m1);
	    
	 // can we add a check before recursive call to break the deadlock
	    
	    
//	     System.out.print(m1.getClass().getName().equals("java.util.HashMap"));
	    
	    boolean res = solution.equal(m1, m2);
	    // res should be true
	    System.out.print(res);

	}

}
