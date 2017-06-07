package com.shellcore.java.movie.data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Cesar. 07/06/2017.
 */
public class MoviesList {

    public static List<String> movieList = new ArrayList<>();

    public MoviesList() {
    }

    public static List<String> getMovieList() {
        return movieList;
    }

    public static void setMovieList(List<String> movieList) {
        movieList = movieList;
    }

    public static int getListSize() {
        return movieList.size();
    }

    public static List<String> getMovieListFromQueue(int queue) {
        int begin = queue * 3;
        int end = begin + 3;
        return movieList.subList(begin, end);
    }

    public static void loadMoviesFile(String url) throws FileNotFoundException {
        Scanner inputFile = new Scanner(new BufferedReader(new FileReader(url)));

        try {
            while (inputFile.hasNext()) {
                String movieName = inputFile.nextLine();
                movieList.add(movieName);
            }
        } finally {
            if (inputFile != null) {
                inputFile.close();
            }
            System.out.println("Lista de peliculas: ");
            movieList.forEach(movie -> System.out.println(movie));
            System.out.println("\n");
        }

    }
}
