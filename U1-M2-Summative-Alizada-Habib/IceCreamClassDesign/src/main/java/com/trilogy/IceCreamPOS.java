package com.trilogy;

import java.util.Scanner;

public class IceCreamPOS {

    private String flavor;
    private String topping;
    private int size;
    private double price = 3;
    private int quantity;
    private static int orderNumber=0;


    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber() {
        this.orderNumber++;
    }

    public void placeOrder(){
        Scanner myScanner = new Scanner(System.in);

        System.out.println("What ice cream flavor would you like? ");
        this.flavor = myScanner.nextLine();

        System.out.println("What size? Enter a number: (1.Small, 2.Medium, 3.Large)");
        this.size = Integer.parseInt(myScanner.nextLine());

        System.out.println("What kind of topping would your like? (Sprinkles, Caramel, Oreos)");
        this.topping = myScanner.nextLine();

        System.out.println("How many ice cream would you like? ");
        this.quantity = Integer.parseInt(myScanner.nextLine());
        setOrderNumber();

    }

    public void makeIceCream(){
        String iceCreamSize;
        if (size == 1){
            iceCreamSize = "small";
        }else if (size == 2){
            iceCreamSize = "medium";
        }else {
            iceCreamSize = "large";
        }
        System.out.println("Order #" + orderNumber +": "+ quantity + " "+iceCreamSize + " " + flavor + " ice cream with " + topping
                + " topping is made. Price: " +size*price*quantity);

    }
}
