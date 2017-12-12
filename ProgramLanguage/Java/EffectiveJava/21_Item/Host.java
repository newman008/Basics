import java.util.*;
import java.io.*;

public class Host {
    private static class StrLenCmp implements Comparator<String>, Serializable {
        public int compare(String s1, String s2) {
            return s1.length() - s2.length();
        }
    }

    public static final Comparator<String> STRING_LENGTH_COMPARATOR = new StrLenCmp();

    public static void main(String[] args) {
        String s1 = "123456";
        String s2 = "12345678";

        int result = Host.STRING_LENGTH_COMPARATOR.compare(s1, s2);
        System.out.println(result);

        String[] stringArray = {"12dafa", "123", "1234", "324153"};
        Arrays.sort(stringArray, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        for(String s : stringArray)
            System.out.println(s);
    }
}
