package com.company;

public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.print("* ");
        }
        System.out.println();
        System.out.println();
        System.out.println("-------------");
        System.out.println();
        for (int bloque = 0; bloque < 5; bloque++) {
            for (int i = 0; i < 5; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("-------------");
        System.out.println();
        for (int i = 0; i < 6; i++) {
            for (int inc = 0; inc < i; inc++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("-------------");
        System.out.println();
        for (int i = 0; i < 6; i++) {
            for (int inc = 5; inc > i; inc--) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("-------------");
        System.out.println();
        for (int i = 0; i < 5; i++) {
            for (int inc = 0; inc < i; inc++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }
        System.out.println();
        System.out.println("-------------");
        System.out.println();
        for (int inc = 0; inc < 5; inc++) {
            if (inc == 0 || inc == 4) {
                for (int inca = 0; inca < 5; inca++) {
                    System.out.print("*");
                }
            } else {
                for (int inca = 0; inca < 5; inca++) {
                    if (inca == 0 || inca == 4) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }
}
