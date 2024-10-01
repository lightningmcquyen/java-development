package finance;

import java.util.Scanner;

public class Practice {

    //calculate the monthly mortgage payment and total interest
    public static double calculateMortgage(double principal, double interestRate, int loanyears) {
        double monthlyRate = (interestRate / 100) / 12;
        int loanmonths = loanyears * 12;
        return principal * (monthlyRate / (1 - Math.pow(1 + monthlyRate, -loanmonths)));
    }

    //calculate the future value and total interest earned of a one time deposit
    public static double calculateFutureValue(double deposit, double currentRate, int years) {
        return deposit * Math.pow(1 + (currentRate / 100), years);
    }

    //calculate the present value of ordinary annuity
    public static double calculatePresentValue (double monthlyPayout, double expectedRate, int yearstopayout) {
        double monthlyRate = (expectedRate / 100) / 12;
        int n = yearstopayout * 12;
        return monthlyPayout * (1 - Math.pow(1 + monthlyRate, -n)) / monthlyRate;
    }


    public static void main(String[] args) {
        Scanner scanley = new Scanner (System.in);
        int choice;

        // Displaying the menu
        System.out.println("\n Financial Calculators:");
        System.out.println("1. Mortgage Calculator");
        System.out.println("2. Future Value Calculator (Daily Compounded Interest)");
        System.out.println("3. Present Value Calculator (Ordinary Annuity)");
        System.out.print("Select Options 1 - 3: ");
        choice = scanley.nextInt();

        switch (choice) {
            case 1 -> { //Mortgage Calculator
                System.out.println("Enter principal amount: ");
                double principal = scanley.nextDouble();
                System.out.println("Enter interest rate (in %): ");
                double interestRate = scanley.nextDouble();
                System.out.println("Enter loan term (in years): ");
                int loanyears = scanley.nextInt();
                double monthlyPayment = calculateMortgage(principal, interestRate, loanyears);
                double totalPayment = (monthlyPayment * loanyears) * 12;
                double totalInterest = totalPayment - principal;
                System.out.printf("Expected Monthly Payment: %.2f%n", monthlyPayment);
                System.out.printf("Total Interest Paid: %.2f%n", totalInterest);
            }
            case 2 -> { //Future Value Calculator
                System.out.print("Enter initial deposit amount: ");
                double deposit = scanley.nextDouble();
                System.out.print("Enter annual interest rate (in %): ");
                double currentRate = scanley.nextDouble();
                System.out.print("Enter number of years: ");
                int years = scanley.nextInt();
                double futureValue = calculateFutureValue(deposit, currentRate, years);
                double totalInterestEarned = futureValue - (deposit);
                System.out.printf("Future Value: %.2f%n", futureValue);
                System.out.printf("Total Interest Earned: %.2f%n", totalInterestEarned);
            }
            case 3 -> { //Present Value Calculator
                System.out.print("Enter monthly payout: ");
                double monthlyPayout = scanley.nextDouble();
                System.out.print("Enter expected annual interest rate (in %): ");
                double expectedRate = scanley.nextDouble();
                System.out.print("Enter number of years to pay out: ");
                int yearstopayout = scanley.nextInt();
                double presentValue = calculatePresentValue(monthlyPayout, expectedRate, yearstopayout);
                System.out.printf("Present Value of the Annuity: %.2f%n", presentValue);
            }
        }

    }
}
