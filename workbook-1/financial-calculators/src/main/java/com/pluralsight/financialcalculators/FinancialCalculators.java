package com.pluralsight.financialcalculators;

import java.util.Scanner;

public class FinancialCalculators {

        // Method to calculate the monthly mortgage payment
        public static double calculateMortgage(double principal, double annualRate, int loanlengthyears) {
                double monthlyRate = annualRate / 100 / 12;
                int numberOfPayments = loanlengthyears * 12;
                return (principal * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -numberOfPayments));
        }

        // Method to calculate the future value of an investment with daily compounded interest
        public static double calculateFutureValue(double deposit, double annualExpectedRate, int years) {
                return deposit * Math.pow(1 + (annualExpectedRate / 100), years);
        }

        // Method to calculate the present value of an ordinary annuity
        public static double calculatePresentValue(double monthlyPayout, double annualRate, int yearstopayout) {
                double monthlyRate = annualRate / 100 / 12;
                int n = yearstopayout * 12;
                return monthlyPayout * (1 - Math.pow(1 + monthlyRate, -n)) / monthlyRate;
        }

        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                int choice;

                // Displaying the menu
                System.out.println("\n Financial Calculators:");
                System.out.println("1. Mortgage Calculator");
                System.out.println("2. Future Value Calculator (Daily Compounded Interest)");
                System.out.println("3. Present Value Calculator (Ordinary Annuity)");
                System.out.print("Select Options 1 - 3: ");
                choice = scanner.nextInt();

                switch (choice) {
                        case 1:
                                // Mortgage Calculator
                                System.out.print("Enter principal amount: ");
                                double principal = scanner.nextDouble();
                                System.out.print("Enter annual rate (in %): ");
                                double annualRate = scanner.nextDouble();
                                System.out.print("Enter loan term (in years): ");
                                int loanlengthyears = scanner.nextInt();

                                double monthlyPayment = calculateMortgage(principal, annualRate, loanlengthyears);
                                double totalPayment = monthlyPayment * loanlengthyears * 12;
                                double totalInterest = totalPayment - principal;

                                System.out.printf("Expected Monthly Payment: %.2f%n", monthlyPayment);
                                System.out.printf("Total Interest Paid: %.2f%n", totalInterest);
                                break;

                        case 2:
                                // Future Value Calculator
                                System.out.print("Enter initial deposit amount: ");
                                double futurePrincipal = scanner.nextDouble();
                                System.out.print("Enter annual interest rate (in %): ");
                                double futureRate = scanner.nextDouble();
                                System.out.print("Enter number of years: ");
                                int futureYears = scanner.nextInt();

                                double futureValue = calculateFutureValue(futurePrincipal, futureRate, futureYears);
                                double totalInterestEarned = futureValue - futurePrincipal;

                                System.out.printf("Future Value: %.2f%n", futureValue);
                                System.out.printf("Total Interest Earned: %.2f%n", totalInterestEarned);
                                break;

                        case 3:
                                // Present Value Calculator
                                System.out.print("Enter monthly payout: ");
                                double monthlyPayout = scanner.nextDouble();
                                System.out.print("Enter expected annual interest rate (in %): ");
                                double presentRate = scanner.nextDouble();
                                System.out.print("Enter number of years to pay out: ");
                                int presentYears = scanner.nextInt();

                                double presentValue = calculatePresentValue(monthlyPayout, presentRate, presentYears);

                                System.out.printf("Present Value of the Annuity: %.2f%n", presentValue);
                                scanner.close();
                }
        }
}