import java.util.*;

public class ForwardingSet<E> implements Set<E> {
    private final Set<E> s;

    public ForwardingSet(Set<E> s) {
        this.s = s;
    }

    public void clear() { s.clear(); }
    public boolean add(E e) { return s.add(e); }
    public boolean addAll(Collection<? extends E> c) {
        return s.addAll(c);
    }

    public boolean contains(Object o) { return s.contains(o); }
    public boolean containsAll(Collection<?> c) { return s.contains(c); }
    public boolean equals(Object o) { return s.equals(o); }
    public int hashCode() { return s.hashCode(); }
    public boolean isEmpty() { return s.isEmpty(); }
    public Iterator<E> iterator() { return s.iterator(); }
    public boolean remove(Object o) { return s.remove(o); }
    public boolean removeAll(Collection<?> c) { return s.removeAll(c); }
    public boolean retainAll(Collection<?> c) { return s.retainAll(c); }
    public int size() { return s.size(); }
    public Object[] toArray() { return s.toArray(); }
    public <T> T[] toArray(T[] a) { return s.toArray(a); }
}
