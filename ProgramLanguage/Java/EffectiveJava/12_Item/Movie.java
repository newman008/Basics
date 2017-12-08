//package Item12;

import java.io.*;
import java.util.*;

public class Movie implements Comparable<Movie> {
    private double rating;
    private String name;
    private int year;

    public Movie(String nm, double rt, int yr) {
        this.name = nm;
        this.rating = rt;
        this.year = yr;
    }

    public double getRating() { return rating; }
    public String getName()   { return name;   }
    public int getYear()      { return year;   }

    public int compareTo(Movie m) {
        return this.year - m.year;
    }
}

