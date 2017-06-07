package com.shellcore.java.movie.entities;

import java.util.LinkedList;

/**
 * Created by Cesar. 07/06/2017.
 */
public class CustomerQueue {
    private static LinkedList<Customer> customerQueue1 = new LinkedList<>();
    private static LinkedList<Customer> customerQueue2 = new LinkedList<>();
    private static LinkedList<Customer> customerQueue3 = new LinkedList<>();
    private static LinkedList<Customer> customerQueue4 = new LinkedList<>();
    private static LinkedList<Customer> customerQueue5 = new LinkedList<>();

    public CustomerQueue() {
    }

    public static void enterCustomer(int queue, Customer customer) {
        switch (queue) {
            case 0:
                customerQueue1.add(customer);
                break;
            case 1:
                customerQueue2.add(customer);
                break;
            case 2:
                customerQueue3.add(customer);
                break;
            case 3:
                customerQueue4.add(customer);
                break;
            case 4:
                customerQueue5.add(customer);
                break;
        }
    }


    public static Customer attendCustomer(int queue) {
        switch (queue) {
            case 0:
                if (customerQueue1.size() > 0) {
                    return customerQueue1.removeFirst();
                }
                return null;
            case 1:
                if (customerQueue2.size() > 0) {
                    return customerQueue2.removeFirst();
                }
                return null;
            case 2:
                if (customerQueue3.size() > 0) {
                    return customerQueue3.removeFirst();
                }
                return null;
            case 3:
                if (customerQueue4.size() > 0) {
                    return customerQueue4.removeFirst();
                }
                return null;
            case 4:
                if (customerQueue5.size() > 0) {
                    return customerQueue5.removeFirst();
                }
                return null;
        }
        return null;
    }

    @Override
    public String toString() {
        String res = "\tQueue 1: " + customerQueue1 + "\n" +
                "\tQueue 2: " + customerQueue2 + "\n" +
                "\tQueue 3: " + customerQueue3 + "\n" +
                "\tQueue 4: " + customerQueue4 + "\n" +
                "\tQueue 5: " + customerQueue5;
        return res;
    }
}
