package com.pluralsight.practice;

import java.util.Scanner;

public class Practice {
        public static void main(String[] args) {
            // Scanner
            Scanner inputScanner = new Scanner(System.in);

            // x + y
            System.out.println("Enter two numeric values you want to add");
            System.out.println("Enter the first value");
            int x = inputScanner.nextInt();
            System.out.println("Enter the second value");
            int y = inputScanner.nextInt();

            System.out.print("The sum is: " + (x + y));

        }
    }
