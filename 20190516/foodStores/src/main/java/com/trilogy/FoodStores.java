package com.trilogy;

public class FoodStores {
    public static void main(String[] args) {

        Store myStore = new Store();
        VendingMachine myVendignMachine = new VendingMachine();
        Restaurant myRestaurant = new Restaurant();

        myStore.setChips(new Chips());
        myStore.setChocolate(new Chocolate());
        myStore.setSodaPop(new SodaPop());

        myStore.getChips().setSize(16);
        myStore.getChips().setBrand("Cheetos");
        myStore.getChocolate().setBrand("Lucky chocolate");
        myStore.getChocolate().setPrice(5);
        myStore.getSodaPop().setBrand("Fanta");

        myVendignMachine.setChips(new Chips());
        myVendignMachine.setGum(new Gum());
        myVendignMachine.setPopcorn(new Popcorn());
        myVendignMachine.setMints(new Mints());

        myVendignMachine.getGum().setBrand("Doublemint");
        myVendignMachine.getPopcorn().setSize(20);
        myVendignMachine.getMints().setPrice(2);
        myVendignMachine.getChips().setBrand("Fritos");

        myRestaurant.setSodaPop(new SodaPop());

        myRestaurant.getSodaPop().setBrand("Coca cola");

        myStore.sellProduct(myStore.getChips().getBrand());
        myStore.restock();

        myVendignMachine.sellProduct(myRestaurant.getSodaPop().getBrand());
        myRestaurant.restock();

        myRestaurant.sellProduct(myRestaurant.getSodaPop().getBrand());
        myRestaurant.restock();



    }
}
