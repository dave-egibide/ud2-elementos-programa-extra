package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //Inicializar
        boolean end = false;
        int turno = 1;
        int f1 = 4;
        int e1 = 4;
        int d1 = 4;
        int c1 = 4;
        int b1 = 4;
        int a1 = 4;
        int A1 = 4;
        int B1 = 4;
        int C1 = 4;
        int D1 = 4;
        int E1 = 4;
        int F1 = 4;
        int capt1 = 0;
        int f2 = 4;
        int e2 = 4;
        int d2 = 4;
        int c2 = 4;
        int b2 = 4;
        int a2 = 4;
        int A2 = 4;
        int B2 = 4;
        int C2 = 4;
        int D2 = 4;
        int E2 = 4;
        int F2 = 4;
        int capt2 = 0;
        while (!end){
            //tablero 1
            System.out.println("Jugador 1:");
            System.out.println("     ┌─────────────────────────────────┐");
            System.out.println("     │  f │  e │  d │  c │  b │  a │");
            System.out.println("┌─────┼─────────────────────────────────┼─────┐");
            System.out.print("│    │  " + f1);
            System.out.print(" │  " + e1);
            System.out.print(" │  " + d1);
            System.out.print(" │  " + c1);
            System.out.print(" │  " + b1);
            System.out.print(" │  " + a1);
            System.out.println(" │     │");
            System.out.print("│  0 ├─────────────────────────────────┤  " + capt1);
            System.out.println("  │");
            System.out.print("│    │  " + A1);
            System.out.print(" │  " + B1);
            System.out.print(" │  " + C1);
            System.out.print(" │  " + D1);
            System.out.print(" │  " + E1);
            System.out.print(" │  " + F1);
            System.out.println(" │     │");
            System.out.println("└─────┼─────────────────────────────────┼─────┘");
            System.out.println("     │  A │  B │  C │  D │  E │  F │");
            System.out.println("     └─────────────────────────────────┘");
            //tablero 2
            System.out.println("Jugador 2:");
            System.out.println("     ┌─────────────────────────────────┐");
            System.out.println("     │  f │  e │  d │  c │  b │  a │");
            System.out.println("┌─────┼─────────────────────────────────┼─────┐");
            System.out.print("│    │  " + f2);
            System.out.print(" │  " + e2);
            System.out.print(" │  " + d2);
            System.out.print(" │  " + c2);
            System.out.print(" │  " + b2);
            System.out.print(" │  " + a2);
            System.out.println(" │     │");
            System.out.print("│  0 ├─────────────────────────────────┤  " + capt2);
            System.out.println("  │");
            System.out.print("│    │  " + A2);
            System.out.print(" │  " + B2);
            System.out.print(" │  " + C2);
            System.out.print(" │  " + D2);
            System.out.print(" │  " + E2);
            System.out.print(" │  " + F2);
            System.out.println(" │     │");
            System.out.println("└─────┼─────────────────────────────────┼─────┘");
            System.out.println("     │  A │  B │  C │  D │  E │  F │");
            System.out.println("     └─────────────────────────────────┘");
        }
    }
}
