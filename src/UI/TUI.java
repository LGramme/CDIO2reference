package UI;

import domain.IController;

import java.io.IOException;
import java.util.Scanner;

public class TUI {
    IController con;

    public TUI(IController con) {
        this.con = con;
    }

    public void run(){
        Scanner scanInt = new Scanner(System.in);
        Scanner scanln = new Scanner(System.in);

        double tara = 0;
        double netto = 0;
        double brutto = 0;

        do {
            System.out.println("Enter operator number");
            try {
                System.out.println("Are you " + con.getOperator(scanInt.nextInt()) + "?");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage() + "\nTry again");
                continue;
            }
            System.out.println("\t1  yes");
            System.out.println("\t2  no");
        } while (scanInt.nextInt() == 2);

        System.out.println("Enter batch number");
        scanInt.nextInt();

        System.out.println("Make sure the weight is unencumbered");
        System.out.println("\t1  ok");
        scanInt.nextInt();


        try {
            con.tare();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Place empty canister on the weight");
        System.out.println("\t1  ok");
        scanInt.nextInt();

        tara = weigh(tara);


        System.out.println("Place netto on the weight");
        System.out.println("\t1  ok");
        scanInt.nextInt();

        netto = weigh(netto);

        System.out.println("Empty the weight");
        System.out.println("\t1  ok");
        scanInt.nextInt();

        brutto = weigh(brutto);

        if (con.checkWighing(tara, netto, brutto))
            System.out.println("Ok");
        else
            System.out.println("Kasseret");

        scanInt.close();
        scanln.close();
        con.close();
    }

    private double weigh(double val) {
        try {
            val = con.getWeight();
            System.out.println("Weight: " + val + "kg");
            con.tare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return val;
    }
}
