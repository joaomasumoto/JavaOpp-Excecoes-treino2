package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;
import model.validators.DataValidator;

/**
 * This is the main class responsible for running the account management system.
 */
public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		try (Scanner sc = new Scanner(System.in)) {
			DataValidator validator = new DataValidator(); // Create a new DataValidator object for use them into prompt validation
			
			System.out.println("Enter account data");
			
			System.out.print("Number: ");
			int number = sc.nextInt(); // Prompting the user for the account number
			validator.validateNumber(number); // Validate account number using DataValidator criteria
			sc.nextLine(); // Consume newline buffer
			
			System.out.print("Holder: ");
			String holder = sc.nextLine(); // Prompting the user for the account holder name
			validator.validateHolder(holder); // Validate account holder name using DataValidator criteria
			
			System.out.print("Initial balance: ");
			double initialBalance = sc.nextDouble(); // Prompting the user for the account initial balance
			validator.validateBalance(initialBalance); // Validate account initial balance using DataValidator criteria
			
			System.out.print("Withdraw limit: ");
			double withdrawLimit = sc.nextDouble(); // Prompting the user for the account Withdraw Limit
			validator.validateWithdrawLimit(withdrawLimit); // Validate account Withdraw Limit using DataValidator criteria
			
			Account ac = new Account(number, holder, initialBalance, withdrawLimit); // Create a new Account object with the provided information

			System.out.print("Enter amount for withdraw: ");
			double amount = sc.nextDouble(); // Prompting the user for the withdraw amount
			validator.validateWithdraw(amount, ac); // Validate withdraw amount using DataValidator criteria
			ac.withdraw(amount); // Attempting to withdraw the specified amount from the account
			
			System.out.printf("New balance: %.2f", ac.getBalance()); // Displaying the updated balance to the user
		}

		catch (DomainException e) {
			System.out.println("Withdraw Error: " + e.getMessage());
		}

		catch (InputMismatchException e) {
			System.out.println("Error: Input mismatch.");
		}
	}
}
