import java.util.*;
import java.io.*;

public final class Period {
    private Date start;
    private Date end;

    public Period(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
        if (this.start.compareTo(this.end) > 0)
            throw new IllegalArgumentException(start + " after " + end);
    }
    
    public Date start() {
        return new Date(start.getTime());
    }

    public Date end() {
        return new Date(end.getTime());
    }

    public static void main(String[] args) {
        Date start = new Date();
        Date end = new Date();
        Period p = new Period(start, end);
        //p.end().setYear(78);
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();

        // Defensively copy our mutable components
        start = new Date(start.getTime());
        end   = new Date(end.getTime());

        if (start.compareTo(end) > 0)
            throw new IllegalArgumentException(start + " after " + end);
    }
}
