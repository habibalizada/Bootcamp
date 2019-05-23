package com.trilogy;

public class myIceCream {

    public static void main(String[] args) {

        System.out.println("-------------------------------------Ice Cream Shop--------------------------------------");
        IceCreamPOS myIceCreamShop = new IceCreamPOS();

        myIceCreamShop.placeOrder();
        myIceCreamShop.makeIceCream();


        System.out.println("\n------------------------------------Ice Cream Factory------------------------------------");
        IceCreamFactory myIceCreamFactory = new IceCreamFactory();

        myIceCreamFactory.placeOrder();
        myIceCreamFactory.produceIceCream();
    }
}
