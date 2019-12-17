package ca.hank.passingobjectbetweenactiviesexample;

import java.io.Serializable;

public class Movie implements Serializable {
    String movieName, directedBy;
    int year;
    double rating;
    String[] starring;

    public Movie(String movieName, String directedBy, int year, double rating, String[] starring) {
        this.movieName = movieName;
        this.directedBy = directedBy;
        this.year = year;
        this.rating = rating;
        this.starring = starring;
    }
}
