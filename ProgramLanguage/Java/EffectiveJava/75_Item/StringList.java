import java.io.*;

public final class StringList implements Serializable {
    private transient int size = 0;
    private transient Entry head = null; // transient is used to indicate a field should not be serialized

    // No longer Serializable!
    private static class Entry {
        String data;
        Entry next;
        Entry previous;
    }

    public final void add(String s) {}

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(size);

        for (Entry e = head; e != null; e = e.next)
            s.writeObject(e.data);
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        int numElements = s.readInt();
        for (int i = 0; i < numElements; i++)
            add((String) s.readObject());
    }

}
