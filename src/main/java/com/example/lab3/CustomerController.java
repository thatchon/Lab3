package com.example.lab3;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class CustomerController {
    private List<Customer> customers = new ArrayList<Customer>(){{
        add(new Customer("1010", "John", "Male", 25));
        add(new Customer("1018", "Peter", "Male", 24));
        add(new Customer("1019", "Sara", "Female", 23));
        add(new Customer("1110", "Rose", "Female", 23));
        add(new Customer("1001", "Emma", "Female", 30));
    }};

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public List<Customer> getCustomers(){
        return customers;
    }

    @RequestMapping(value = "/customerbyid/{id}", method = RequestMethod.GET)
    public Customer getCustomerByID(@PathVariable("id") String ID){
        for (Customer customer : customers) {
            if (customer.getID().equals(ID)) {
                return customer;
            }
        }
        return null;
    }

    @RequestMapping(value = "/customerbyname/{n}", method = RequestMethod.GET)
    public Customer getCustomerByName(@PathVariable("n") String n){
        for (Customer customer : customers) {
            if (customer.getName().equals(n)) {
                return customer;
            }
        }
        return null;
    }

    @RequestMapping(value = "/customerDelByid/{id}", method = RequestMethod.DELETE)
    public boolean delCustomerByID(@PathVariable("id") String ID){
        for (int i = 0; i < customers.size(); i++){
            if(customers.get(i).getID().equals(ID)){
                customers.remove(i);
                return true;
            }
        }
        return false;
    }

    @RequestMapping(value = "/customerDelByname/{n}", method = RequestMethod.DELETE)
    public boolean delCustomerByName(@PathVariable("n") String n){
        for (int i = 0; i < customers.size(); i++){
            if(customers.get(i).getName().equals(n)){
                customers.remove(i);
                return true;
            }
        }
        return false;
    }

    @RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
    public boolean addCustomer(@RequestParam("id") String ID,
                               @RequestParam("name") String n,
                               @RequestParam("sex") String s,
                               @RequestParam("age") int a){
        customers.add(new Customer(ID, n, s, a));
        return true;
    }

    @RequestMapping(value = "/addCustomer2", method = RequestMethod.POST)
    public boolean addCustomer2(@RequestParam("id") String ID,
                                @RequestParam("name") String n,
                                @RequestParam("sex") String s,
                                @RequestParam("age") int a){
        customers.add(new Customer(ID, n, s, a));
        return true;
    }
}