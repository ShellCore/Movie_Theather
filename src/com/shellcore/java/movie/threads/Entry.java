package com.shellcore.java.movie.threads;

import com.shellcore.java.movie.MultiThreading;
import com.shellcore.java.movie.data.MoviesList;
import com.shellcore.java.movie.entities.Customer;
import com.shellcore.java.movie.entities.CustomerQueue;
import com.shellcore.java.movie.entities.MovieStock;

import java.util.Random;

/**
 * Created by Cesar. 07/06/2017.
 */
public class Entry extends Thread {

    private static int ids;
    private boolean threadAlive = true;

    Random randomGenerator = new Random();

    public Entry() {
    }

    public void entry(int timeCustomerEntry) {
        int wichMovie = randomGenerator.nextInt(MoviesList.getListSize());
        int queue = wichMovie / 3; // Número de películas por fila

        CustomerQueue.enterCustomer(queue, new Customer(ids++, MoviesList.getMovieList().get(wichMovie)));

        String message = "Customer #" + ids
                + " enters the queue " + (queue + 1)
                + " in " + (timeCustomerEntry / 1000)
                + " seconds";
        System.out.println(message);
    }

    public void end() {
        this.threadAlive = false;
    }

    @Override
    public void run() {
        int timeCustomerEnter = 0;

        while (this.threadAlive) {

            timeCustomerEnter = 1000 + (1000 * randomGenerator.nextInt(3));

            try {
                this.sleep(timeCustomerEnter);
                if (MovieStock.areTicketsAviable()) {
                    this.entry(timeCustomerEnter);
                } else {
                    MultiThreading.endThreads();
                }
            } catch (InterruptedException e) {
                System.out.println("Entry interrupted");
            }
        }
    }
}
