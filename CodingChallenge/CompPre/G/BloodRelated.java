package InterviewQuestions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Person {
    int id;
    ArrayList<Person> ancestors;
    Person parent1;
    Person parent2;
    
    public Person(int id) {
        this.id = id;
        ancestors = new ArrayList<Person>();
    }
    
    public ArrayList<Person> getAncestors(){
        return this.ancestors;
    }
}

public class BloodRelated {
    
    public boolean isBloodRelatedR(Person p1, Person p2) {
        Person cur = p1;
        dfs(p1, cur);
        cur = p2;
        dfs(p2, cur);
        
        for(Person a1 : p1.ancestors) {
            for(Person a2 : p2.ancestors) {
                if(a1.id == a2.id) return true;
            }
        }
        
        return false;
    }
    
    private void dfs(Person p1, Person cur) {
        if(cur == null) return;
        p1.ancestors.add(cur);
        if(cur.parent1 != null) dfs(p1, cur.parent1);
        if(cur.parent2 != null) dfs(p1, cur.parent2);
        
    }
    
    public boolean isBloodRelated(Person p1, Person p2) {
        if(p1 == null || p2 == null) return false;
        
        Queue<Person> q1 = new LinkedList<Person>();
        q1.offer(p1);
        while(!q1.isEmpty()){
            Person p = q1.poll();
            p1.ancestors.add(p);
            if(p.parent1 != null) {
                q1.offer(p.parent1);
            }
            if(p.parent2 != null) {
                q1.offer(p.parent2);
            }
        }
        
        q1.offer(p2);
        while(!q1.isEmpty()){
            Person p = q1.poll();
            p2.ancestors.add(p);
            if(p.parent1 != null) {
                q1.offer(p.parent1);
            }
            if(p.parent2 != null) {
                q1.offer(p.parent2);
            }
        }
        
        for(Person a1 : p1.ancestors) {
            for(Person a2 : p2.ancestors) {
                if(a1.id == a2.id) return true;
            }
        }
        
        return false;
    }
    
    public boolean isBloodRelatedEnhanced(Person p1, Person p2) {
        if(p1 == null || p2 == null) return false;
        
        HashSet<Person> p1Ancestors = new HashSet<Person>();
        HashSet<Person> p2Ancestors = new HashSet<Person>();
        Queue<Person> q1 = new LinkedList<Person>();
        q1.offer(p1);
        Queue<Person> q2 = new LinkedList<Person>();
        q2.offer(p2);
        
        while(!q1.isEmpty() || !q2.isEmpty()) {
            if(!q1.isEmpty()) {
                Person nextP1 = q1.poll();
                if(p2Ancestors.contains(nextP1)) {
                    return true;
                }
                if(nextP1.parent1 != null) q1.offer(nextP1.parent1);
                if(nextP1.parent2 != null) q1.offer(nextP1.parent2);
                
                p1Ancestors.add(nextP1);
            }
            
            if(!q2.isEmpty()) {
                Person nextP2 = q2.poll();
                if(p1Ancestors.contains(nextP2)) {
                    return true;
                }
                if(nextP2.parent1 != null) q1.offer(nextP2.parent1);
                if(nextP2.parent2 != null) q1.offer(nextP2.parent2);
                
                p2Ancestors.add(nextP2);
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Person p1 = new Person(1);
        Person p2 = new Person(2);
        Person p3 = new Person(3);
        Person p4 = new Person(4);
        Person p5 = new Person(5);

        Person p6 = new Person(6);
        Person p7 = new Person(7);
        Person p8 = new Person(8);
        p1.parent1 = p2;
        p1.parent2 = p3;
        p2.parent1 = p4;
        p2.parent2 = p5;
        p6.parent1 = p7;
        p6.parent2 = p8;
        
        BloodRelated t = new BloodRelated();
        //System.out.print(t.isBloodRelated(p1, p8));
        //System.out.print(t.isBloodRelatedEnhanced(p7, p8));
        System.out.print(t.isBloodRelatedR(p4, p2));
    }

}
