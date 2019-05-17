package com.trilogy;

public class Restaurant {

    private String address="";
    private SodaPop sodaPop;



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public SodaPop getSodaPop() {
        return sodaPop;
    }

    public void setSodaPop(SodaPop sodaPop) {
        this.sodaPop = sodaPop;
    }

    public void sellProduct(String productName){
        System.out.println("The " + productName + " is soled");
    }

    public void restock(){
        System.out.println("The products is restocked.");
    }
}
