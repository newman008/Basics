package Item3;

public class Elvis {
    private static final Elvis INSTANCE = new Elvis();
    private Elvis() {}
    public static Elvis getInstance() { return INSTANCE; }

    public void sing() {}
}

public enum Elvis {
    INSTANCE;

    public void sing() {}
}
