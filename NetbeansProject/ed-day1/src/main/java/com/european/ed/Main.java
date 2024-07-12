package com.european.ed;

import com.european.ed.util.CommercialCalculations;
import com.european.ed.userinterface.Ui;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
      Ui ui = new Ui();
      ui.function2();;

    }

    public static void program() {
        Scanner scanner = new Scanner(System.in);
        int primeCanditate;
        do {
            System.out.println("Give me a prime number");
            primeCanditate = scanner.nextInt();
            System.out.println(CommercialCalculations.primeCheck(primeCanditate));
        } while (primeCanditate != 0);

    }

    public static void gcd() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give numerator :");
        int numerator = scanner.nextInt();
        System.out.println("Give deminator :");
        int deminator = scanner.nextInt();
        System.out.println("gcd is: " + CommercialCalculations.greatestCommonDivisor(numerator, deminator));
    }

}
