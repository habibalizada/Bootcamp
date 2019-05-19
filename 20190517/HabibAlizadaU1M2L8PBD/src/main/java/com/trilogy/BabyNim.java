package com.trilogy;

import java.util.Scanner;

public class BabyNim {
    public static void main(String[] args) {

        int A = 3;
        int B = 3;
        int C = 3;
        String pile;
        int toRemove;

        Scanner myScanner = new Scanner(System.in);


        while (A > 0 || B > 0 || C > 0){

            System.out.println("A: " + A+ "\tB: " + B + "\tC: " + C);
            System.out.println("\nChoose a pile: ");
            pile = myScanner.nextLine();
            System.out.println("How many to remove from pile " + pile +": ");
            toRemove = Integer.parseInt(myScanner.nextLine());

            if (pile.equalsIgnoreCase("A")){
                A = A - toRemove;
            }else if (pile.equalsIgnoreCase("B")){
                B = B - toRemove;
            }else if (pile.equalsIgnoreCase("C")){
                C = C - toRemove;
            }else {
                System.out.println("Not a valid pile!");
            }
        }

        System.out.println("\nA: " + A+ "\tB: " + B + "\tC: " + C);
        System.out.println("All piles are empty. Good job!");

    }
}
