#include <stdio.h>
#include <math.h>
#include "final.h"

int main() {
    // Loan parameters
    double principal = 0.0;
    double rate = 0.0;
    int years = 0;

    // Menu
    int choice;
    do {
        printf("\nBig Bank Loan Calculator\n");
        printf("1. Enter principal\n");
        printf("2. Enter annual interest rate\n");
        printf("3. Enter duration of loan (years)\n");
        printf("4. Calculate loan payment\n");
        printf("5. Display loan repayment table\n");
        printf("0. Quit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter principal: $");
                scanf("%lf", &principal);
                break;

            case 2:
                printf("Enter annual interest rate: ");
                scanf("%lf", &rate);
                if (rate <= 0) {
                    printf("Error: Annual interest rate must be greater than 0%%.\n");
                    rate = 0.0; // Reset rate to 0 if invalid input
                }
                break;

            case 3:
                printf("Enter duration of loan (years): ");
                scanf("%d", &years);
                if (years <= 0) {
                    printf("Error: Duration of loan must be at least 1 year.\n");
                    years = 1; // Reset years to 1 if invalid input
                }
                break;

            case 4:
                if (principal > 0 && rate > 0 && years > 0) {
                    double payment = calculatePayment(principal, rate / 100.0 / 12.0, years * 12);
                    printf("Monthly payment: $%.2lf\n", payment);
                } else {
                    printf("Error: Please enter valid values for principal, interest rate, and duration.\n");
                }
                break;

            case 5:
                if (principal > 0 && rate > 0 && years > 0) {
                    displayRepaymentTable(principal, rate / 100.0 / 12.0, years);
                } else {
                    printf("Error: Please enter valid values for principal, interest rate, and duration.\n");
                }
                break;

            case 0:
                printf("Exiting program. Goodbye!\n");
                break;

            default:
                printf("Invalid choice. Please enter a number between 0 and 5.\n");
        }
    } while (choice != 0);

    return 0;
}

// Function to calculate monthly payment
double calculatePayment(double principal, double rate, int months) {
    return principal * rate / (1 - pow(1 + rate, -months));
}

// Function to display loan repayment table
void displayRepaymentTable(double principal, double rate, int years) {
    int months = years * 12;
    double oldBalance = principal;

    printf("\n%-10s%-15s%-12s%-12s%-12s%-12s\n", "Month", "Old Balance", "Payment", "Interest", "Principal", "New Balance");

    for (int month = 1; month <= months; ++month) {
        double payment = calculatePayment(principal, rate, months);
        double interest = oldBalance * rate;
        double principalPaid = payment - interest;
        double newBalance = oldBalance - principalPaid;

        printf("%-10d%-15.2lf%-12.2lf%-12.2lf%-12.2lf%-12.2lf\n",
               month, oldBalance, payment, interest, principalPaid, newBalance);

        oldBalance = newBalance;
    }
}