package com.trilogy;

import java.util.Scanner;

public class IceCreamFactory {

    private String flavor;
    private int size;
    private double pricePerPack = 36;
    private int numOfOrder;
    private String customerName;
    private String customerAddress;
    private static int orderNumber = 0;

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double getPricePerPack() {
        return pricePerPack;
    }

    public void setPricePerPack(double pricePerPack) {
        this.pricePerPack = pricePerPack;
    }

    public int getNumOfOrder() {
        return numOfOrder;
    }

    public void setNumOfOrder(int numOfOrder) {
        this.numOfOrder = numOfOrder;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public  void setOrderNumber() {
        this.orderNumber++;
    }

    public void placeOrder(){
        Scanner myScanner = new Scanner(System.in);

        System.out.println("What ice cream flavor do you want to produce? ");
        this.flavor = myScanner.nextLine();

        System.out.println("What size? Enter a number: (1.Small, 2.Medium, 3.Large)");
        this.size = Integer.parseInt(myScanner.nextLine());


        System.out.println("How many ice cream do you want ot produce? ");
        this.numOfOrder = Integer.parseInt(myScanner.nextLine());

        System.out.println("Enter customer's name: ");
        this.customerName = myScanner.nextLine();

        System.out.println("Enter is customer's address:");
        this.customerAddress = myScanner.nextLine();
        setOrderNumber();

    }

    public void produceIceCream(){

        String iceCreamSize;
        if (size == 1){
            iceCreamSize = "small";
        }else if (size == 2){
            iceCreamSize = "medium";
        }else {
            iceCreamSize = "large";
        }

        System.out.println("Order #" + orderNumber +": "+ numOfOrder + " "+iceCreamSize + " " + flavor +
                " ice cream is produced. Price: " +size*pricePerPack*(numOfOrder/12));
        System.out.println("Customer's name: " + customerName);
        System.out.println("Customer's address: " + customerAddress);


    }


}
