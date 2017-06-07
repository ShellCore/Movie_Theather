package com.shellcore.java.movie;

import com.shellcore.java.movie.data.MoviesList;
import com.shellcore.java.movie.entities.MovieStock;
import com.shellcore.java.movie.threads.Attender;
import com.shellcore.java.movie.threads.Entry;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Cesar. 07/06/2017.
 */
public class MultiThreading {

    private static Entry entry;
    private static Attender attender1;
    private static Attender attender2;
    private static Attender attender3;
    private static Attender attender4;
    private static Attender attender5;

    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        String userInput;

//        String filePath = "Root/movies.txt"; // Esta dirección es para la página del proyecto en Edx.org (codeboard.io)
        String filePath = "./src/movies.txt";

        /*Read movies from movies.txt*/
        try {
            MoviesList.loadMoviesFile(filePath);
            MovieStock movieStock = new MovieStock(MoviesList.getMovieList());
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no se encuentra");
            System.exit(1);
        }

        /*Create clases*/
        entry = new Entry();
        attender1 = new Attender(0, MoviesList.getMovieListFromQueue(0));
        attender2 = new Attender(1, MoviesList.getMovieListFromQueue(1));
        attender3 = new Attender(2, MoviesList.getMovieListFromQueue(2));
        attender4 = new Attender(3, MoviesList.getMovieListFromQueue(3));
        attender5 = new Attender(4, MoviesList.getMovieListFromQueue(4));


        /*Start Threads*/
        entry.start();
        attender1.start();
        attender2.start();
        attender3.start();
        attender4.start();
        attender5.start();

        // Stop with any key, except just Enter
        while(MovieStock.areTicketsAviable()) {
            userInput = inputReader.next();
            /*End Threads*/
            if (userInput.equals("-")) {
                MovieStock.showTicketsAviable();
            } else {
                endThreads();
                System.exit(0);
            }
        }
    }

    public static void endThreads() {
        attender1.end();
        attender2.end();
        attender3.end();
        attender4.end();
        attender5.end();
        entry.end();
        System.exit(0);
    }
}
