//package Item12;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<Movie> list = new ArrayList<Movie>();
        list.add(new Movie("Force Awakens", 8.3, 2015));
        list.add(new Movie("Star Wars", 8.7, 1977));
        list.add(new Movie("Empire Strikes Back", 8.8, 1980));
        list.add(new Movie("Return of the Jedi", 8.4, 1983));

        System.out.println("\nSorted by year");
        Collections.sort(list);
        printResult(list);

        System.out.println("\nSorted by rating");
        RatingComparator ratingComparator = new RatingComparator();
        Collections.sort(list, ratingComparator);
        printResult(list);

        System.out.println("\nSorted by name");
        NameComparator nameComparator = new NameComparator();
        Collections.sort(list, nameComparator);
        printResult(list);
    }

    private static void printResult(List<Movie> list) {
        for (Movie movie: list)
            System.out.println(movie.getYear() + " " +
                               movie.getRating() + " " +
                               movie.getName()+" ");
    }

}
