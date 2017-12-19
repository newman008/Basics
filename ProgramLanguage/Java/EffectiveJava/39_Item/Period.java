import java.util.*;

public final class Period {
    private final Date start;
    private final Date end;

    public Period(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
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
}
