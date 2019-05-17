package com.trilogy;

public class VendingMachine {
    private String address="";
    private Chips chips;
    private SodaPop sodaPop;
    private Chocolate chocolate;
    private Mints mints;
    private Gum gum;
    private Popcorn popcorn;



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

    public Mints getMints() {
        return mints;
    }

    public void setMints(Mints mints) {
        this.mints = mints;
    }

    public Gum getGum() {
        return gum;
    }

    public void setGum(Gum gum) {
        this.gum = gum;
    }

    public Popcorn getPopcorn() {
        return popcorn;
    }

    public void setPopcorn(Popcorn popcorn) {
        this.popcorn = popcorn;
    }

    public void sellProduct(String productName){
        System.out.println("The " + productName + " is soled");
    }

    public void restock(){
        System.out.println("The products is restocked.");
    }
}
