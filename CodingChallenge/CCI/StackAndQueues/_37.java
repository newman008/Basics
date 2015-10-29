package StackAndQueues;

import java.util.*;

/*
 * An animal shelter holds only dogs and cats, and operates on a strictly "first in, first
out" basis. People must adopt either the "oldest" (based on arrival time) of all animals
at the shelter, or they can select whether they would prefer a dog or a cat (and will
receive the oldest animal of that type). They cannot select which specific animal they
would like. Create the data structures to maintain this system and implement operations
such as enqueue, dequeueAny, dequeueDog and dequeueCat. You may
use the built-in L inkedL ist data structure.
 */

abstract class Animal{
    private int order;
    private String name;
    public Animal(String s) {
        name = s;
    }
    public void setOrder(int o) {
        order = o;
    }
    public int getOrder() {
        return order;
    }
    public boolean isOlderThan(Animal a) {
        return this.order < a.order;
    }
}

class Dog extends Animal{
    public Dog(String s) {
        super(s);
    }
}

class Cat extends Animal{
    public Cat(String s) {
        super(s);
    }
}

public class _37 {
    
    LinkedList<Dog> dogs = new LinkedList<Dog>();
    LinkedList<Cat> cats = new LinkedList<Cat>();
    private int order = 0;
    
    public void enqueue(Animal a) {
        a.setOrder(order);
        order++;
        if(a instanceof Dog) dogs.add((Dog)a);
        else if(a instanceof Cat) cats.add((Cat)a);
    }
    
    public Animal dequeueAny() {
        if(dogs.size() == 0) return cats.poll();
        if(cats.size() == 0) return dogs.poll();
        
        Dog d = dogs.peek();
        Cat c = cats.peek();
        
        if(d.isOlderThan(c)) return dogs.poll();
        else return cats.poll();
    }
    
    public Dog dequeueDog() {
        return dogs.poll();
    }
    
    public Cat dequeueCat() {
        return cats.poll();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
