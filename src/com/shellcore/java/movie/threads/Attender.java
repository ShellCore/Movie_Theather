package com.shellcore.java.movie.threads;

import com.shellcore.java.movie.entities.Customer;
import com.shellcore.java.movie.entities.CustomerQueue;
import com.shellcore.java.movie.entities.MovieStock;

import java.util.List;
import java.util.Random;

/**
 * Created by Cesar. 07/06/2017.
 */
public class Attender extends Thread {

    private int wichQueue;
    private List<String> moviesAssigned;
    private boolean threadAlive = true;

    Random randomGenerator = new Random();

    public Attender(int wichQueue, List<String> moviesAssigned) {
        this.wichQueue = wichQueue;
        this.moviesAssigned = moviesAssigned;
    }

    public void attend(Customer customer) {
        String res = "";
        int randomTime = 3000 + (randomGenerator.nextInt(3) * 1000);
        try {
            this.sleep(randomTime);
        } catch (InterruptedException e) {
            System.out.println("Attender interrupted wait for attend");
        }
        res = "Customer #" + (customer.id + 1)
                + " from queue " + (wichQueue + 1);
        if (MovieStock.sellTicket(customer.desiredMovie)) {
            res += " buys ticket after "
                    + (randomTime / 1000)
                    + " seconds for the movie "
                    + customer.desiredMovie;
        } else {
            res += " leaves queue. No tickets aviable for the movie "
                    + customer.desiredMovie;
        }
        System.out.println(res);
    }

    public void end() {
        this.threadAlive = false;
    }

    @Override
    public void run() {
        Customer customer;

        while(this.threadAlive) {
            customer = CustomerQueue.attendCustomer(this.wichQueue);

            if (customer != null) {
                this.attend(customer);
            } else {
                try {
                    this.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Attender interrupted");
                }
            }
        }
    }
}
