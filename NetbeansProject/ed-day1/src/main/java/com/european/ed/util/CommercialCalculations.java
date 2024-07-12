/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.european.ed.util;

/**
 *
 * @author stef6
 */
public class CommercialCalculations {

    public static boolean primeCheck(int primeCanditate) {
        if (primeCanditate <= 0) {
            return false;
        }
        for (int i = 2; i <= primeCanditate / 2; i++) {
            if (primeCanditate % i == 0) {
                System.out.println(i);
                return false;
            }

        }
        return true;
    }

    public static int calculateYearsDoublingCapital(double interestRate) {
        double capital = 1;
        int years = 0;
        while (capital <= 2 * capital) {
            capital += capital * interestRate;
            years++;
        }
        System.out.println(capital);
        return years;
       
    }

    public static int greatestCommonDivisor(int numerator, int deminator) {
        if (numerator<1|| deminator <1){
            System.out.println("Can't find gcd with those numbers, give another");
            return 0;
        }
        else{
            int gcd = min(numerator, deminator);
            do {
                if (numerator % gcd == 0 && deminator % gcd == 0) 
                    return gcd;
                else 
                    gcd--;
            } while (gcd > 1);
            return gcd;
        }

    }

    private static int min(int a, int b) {
        return (a < b) ? a : b;
    }
}
