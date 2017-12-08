import java.util.*;

/*
 * class using inheritance
public class InstrumentedHashSet<E> extends HashSet<E> {
    private int addCount = 0;

    public InstrumentedHashSet() {}

    public InstrumentedHashSet(int initCap, float loadFactor) {
        super(initCap, loadFactor);
    }

    @Override public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    public int getAddAcount() {
        return addCount;
    }
}
*/

// Wrapper class - uses composition in place of inheritance
public class InstrumentedHashSet<E> extends ForwardingSet<E> {
    private int addCount = 0;

    public InstrumentedHashSet(Set<E> s) {
        super(s);
    }

    @Override public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    public int getAddAcount() {
        return addCount;
    }
}
