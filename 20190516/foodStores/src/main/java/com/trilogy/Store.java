package com.trilogy;

public class Store {

    private String address ="";
    private Chips chips;
    private SodaPop sodaPop;
    private Chocolate chocolate;



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Chips getChips() {
        return chips;
    }

    public void setChips(Chips chips) {
        this.chips = chips;
    }

    public SodaPop getSodaPop() {
        return sodaPop;
    }

    public void setSodaPop(SodaPop sodaPop) {
        this.sodaPop = sodaPop;
    }

    public Chocolate getChocolate() {
        return chocolate;
    }

    public void setChocolate(Chocolate chocolate) {
        this.chocolate = chocolate;
    }

    public void sellProduct(String productName){
        System.out.println("The " + productName + " is soled");
    }

    public void restock(){
        System.out.println("The products is restocked.");
    }
}
