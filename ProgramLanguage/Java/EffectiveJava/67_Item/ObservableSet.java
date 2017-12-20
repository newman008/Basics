import java.util.*;

public class ObservableSet<E> extends ForwardingSet<E> {
    public ObservableSet(Set<E> set) { super(set); }

    private final List<SetObserver<E>> observers =
        new ArrayList<SetObserver<E>>();

    public void addObserver(SetObserver<E> observer) {
        synchronized(observers) {
            observers.add(observer);
        }
    }

    public void removeObserver(SetObserver<E> observer) {
        synchronized(observers) {
            observers.remove(observer);
        }
    }

    // Alien method moved outside of synchronized block - open calls
    private void notifyElementAdded(E element) {
        List<SetObserver<E>> snapshot = null;
        synchronized(observers) {
            snapshot = new ArrayList<SetObserver<E>>(observers);
        }
        for (SetObserver<E> observer : snapshot)
            observer.added(this, element);
    }

    @Override public boolean add(E element) {
        boolean added = super.add(element);
        if (added)
            notifyElementAdded(element);
        return added;
    }

    @Override public boolean addAll(Collection<? extends E> c) {
        boolean result = false;
        for (E element : c)
            result |= add(element);
        return result;
    }

    public static void main(String[] args) {
        ObservableSet<Integer> set = new ObservableSet<Integer>(new HashSet<Integer>());

        set.addObserver(new SetObserver<Integer>() {
            public void added(ObservableSet<Integer> s, Integer e) {
                System.out.println(e);
                if (e == 23) s.removeObserver(this);
            }
        });

        for(int i = 0; i < 100; i++)
            set.add(i);
    }
}
