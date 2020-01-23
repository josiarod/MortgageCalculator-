import java.util.Scanner;

public class MortgageCalculator {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        double loanAmount = 0;
        double interestRate = 0;
        double processor = 0;
        double balanceOwed = 0;
        int years;

        //Get loan information from the user

        System.out.printf("Enter the loan amount: ");
        loanAmount = keyboard.nextDouble();

        System.out.printf("Enter the interest rate on the loan: ");
        interestRate = keyboard.nextDouble();

        System.out.printf("Enter the term (years) for the loan payment: ");
        years = keyboard.nextInt();

        System.out.printf("\n======================================\n");
        keyboard.close();

        //Calculate balance owed to bank and minimum monthly payment

        processor = processSomething(loanAmount, interestRate, years);
        balanceOwed = -(processor*(years*12));
        System.out.format("%-30s$%-+10.2f%n", "Balance owed to bank: ", balanceOwed);
        System.out.format("%-30s$%-+10.2f%n", "Minimum monthly payment: ", processor);
    }


    public static double processSomething(double l, double i, int trm) {
        // calculates the monthly payment
        double rate = (i/ 100) / 12;
        double base = (1 + rate);
        double months = trm* 12;
        double result = 0.0;
        result = ((rate * l) / (1 - Math.pow(base, -months)));

        return result;
    }
}