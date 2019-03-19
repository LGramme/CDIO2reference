package UI;

import domain.Controller;

import java.io.IOException;
import java.util.Scanner;

public class TUI {
    Controller con;

    public TUI(Controller con) {
        this.con = con;
    }

    public void run() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Enter command");
            System.out.println("\t1  weigh");
            System.out.println("\t2  quit");
            switch (scan.nextInt()) {
                case 1:
                    weigh();
                    break;
                case 2:
                    con.close();
                    break;
                default:
            }
        }
    }

    private void weigh(){
        Scanner scanInt = new Scanner(System.in);
        Scanner scanln = new Scanner(System.in);

        do {
            System.out.println("Enter operator number");
            System.out.println("Are you " + con.getOperator(scanInt.nextInt()) + "?");
            System.out.println("\t1  yes");
            System.out.println("\t2  no");
        } while (scanln.nextLine().equalsIgnoreCase("no"));

        System.out.println("Enter batch number");
        scanInt.nextInt();

        System.out.println("Make sure the weight is unencumbered");
        System.out.println("\t1  ok");
        scanInt.nextInt();


        con.tare();
        System.out.println("Place empty canister on the wight");
        System.out.println("\t1  ok");
        scanInt.nextInt();

        try {
            System.out.println(con.getWeight());
        } catch (IOException e) {
            e.printStackTrace();
        }

        con.tare();

        System.out.println("Place netto on the weight");
        System.out.println("\t1  ok");
        scanInt.nextInt();

        try {
            System.out.println(con.getWeight());
            con.tare();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Empty the weight");
        System.out.println("\t1  ok");
        scanInt.nextInt();

        System.out.println("Brutto weight:");
        try {
            System.out.println(con.getWeight());
            System.out.println("Ok");
            con.tare();
        } catch (IOException e) {
            e.printStackTrace();
        }


        scanInt.close();
        scanln.close();
    }
}
