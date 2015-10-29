package designModes;

import java.util.Iterator;
import java.util.Vector;
public abstract class ObjectPool<T> {

   private Vector<T> locked, unlocked;   

   public ObjectPool() {
       locked = new Vector<T>();
       unlocked = new Vector<T>();
   }
  
   protected abstract T create();
   
   public abstract boolean validate(T o);
   
   public abstract void expire(T o);
   
   public synchronized T checkOut() {
       T t;
       if (unlocked.size() > 0) {
           Iterator<T> iter = unlocked.iterator();
           while(iter.hasNext()) {
               t = iter.next();
               if(validate(t)) {   
                   unlocked.remove(t);
                   locked.add(t);
                   return t;
               }
               else {   
                   unlocked.remove(t);
                   expire(t);
               }
           }
       }

       t = create();
       locked.add(t);

       return (t);
    }
   
   public synchronized void checkIn(T t) {
       locked.remove(t);
       if(validate(t)) {   
           unlocked.add(t);
       }
       else {   
           expire(t);
       }
   }
}