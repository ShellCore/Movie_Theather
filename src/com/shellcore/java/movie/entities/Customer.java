package com.shellcore.java.movie.entities;

/**
 * Created by Cesar. 07/06/2017.
 */
public class Customer {
    public int id;
    public String desiredMovie;

    public Customer(int id, String desiredMovie) {
        this.id = id;
        this.desiredMovie = desiredMovie;
    }

    @Override
    public String toString() {
        return "Customer No. " + id;
    }
}
