package com.shellcore.java.movie.entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Cesar. 07/06/2017.
 */
public class MovieStock {
    private static Map<String, Integer> movieList;

    public MovieStock(List<String> movieNameList) {
        this.movieList = new HashMap<>();

        for (String movieName :
                movieNameList) {
            this.movieList.put(movieName, 50);
        }
    }

    public static synchronized boolean sellTicket(String movieName) {
        if (movieList.get(movieName) > 0) {
            movieList.put(movieName, (movieList.get(movieName) - 1));
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "\tMovies Stock: " + movieList;
    }

    public static boolean areTicketsAviable() {
        return (movieList.values()
                .stream()
                .mapToInt(i -> i.intValue())
                .sum()) > 0;
    }

    public static void showTicketsAviable() {
        System.out.println("\n\n-----Tickets aviable-----\n");
        movieList.forEach((name, tickets) -> {
            if (tickets > 0) {
                System.out.println(tickets + " : " + name);
            }
        });

        System.out.println("\n");
    }
}
