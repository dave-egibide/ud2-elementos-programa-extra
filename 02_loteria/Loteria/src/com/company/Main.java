package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Random r = new Random();

        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        int num4 = 0;
        int num5 = 0;
        int est1 = 0;
        int est2 = 0;

        System.out.println("Introduzca el número de boletos aleatorios de Euromillones");
        int x = Integer.parseInt(br.readLine());

        for (int i = 0; i < x; i++) {
            num1 = r.nextInt(49)+1;
            do {
                num2 = r.nextInt(49)+1;
            } while (num2 == num1);
            do {
                num3 = r.nextInt(49)+1;
            } while (num3 == num1 || num3 == num2);
            do {
                num4 = r.nextInt(49)+1;
            } while (num4 == num1 || num4 == num2 || num4 == num3);
            do {
                num5 = r.nextInt(49)+1;
            } while (num5 == num1 || num5 == num2 || num5 == num3 ||num5 == num4);

            est1 = r.nextInt(11)+1;
            do {
                est2 = r.nextInt(11)+1;
            } while (est2 == est1);

            System.out.print("Núm.: ");
            System.out.print(num1);
            System.out.print(" ");
            System.out.print(num2);
            System.out.print(" ");
            System.out.print(num3);
            System.out.print(" ");
            System.out.print(num4);
            System.out.print(" ");
            System.out.print(num5);
            System.out.print(" Est.: ");
            System.out.print(est1);
            System.out.print(" ");
            System.out.println(est2);
        }
    }
}
