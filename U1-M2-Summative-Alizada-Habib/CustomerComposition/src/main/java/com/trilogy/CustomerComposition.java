package com.trilogy;

public class CustomerComposition {
    public static void main(String[] args) {

        Address customerBillingAddress = new Address("123 Main str", "","Chicago", "IL", "60612");
        Address customerShippingAddress = new Address("321 N Clark str", "","Chicago", "IL", "60630");
        Customer customer = new Customer("Bob", "Smith", "bob@gmail.com", "773-123-1234",
                true, customerShippingAddress,customerBillingAddress);

        System.out.println("Customer's information:");
        System.out.println("First Name: " + customer.getFirstName() + "\nLast Name: " + customer.getLastName());
        System.out.println("Email: " + customer.getEmail() + "\nPhone: " + customer.getPhoneNumber());
        System.out.println("Shippin Address: " + customer.getShippingAddress());
        System.out.println("Milling Address: " + customer.getBillingAddress());

    }
}
