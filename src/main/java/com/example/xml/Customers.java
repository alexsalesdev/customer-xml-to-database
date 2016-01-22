package com.example.xml;

import java.util.List;

/**
 * Created by asales on 23/1/2016.
 */
public class Customers {
    List<Customer> customers;

    @Override
    public String toString() {
        return "Customers{" +
                "customers=" + customers +
                '}';
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
