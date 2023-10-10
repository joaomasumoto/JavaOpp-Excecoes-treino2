package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Holder: ");
			String holder = sc.next();
			sc.nextLine();
			System.out.print("Initial balance: ");
			double inicialBalance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdrawLimit = sc.nextDouble();

			Account ac = new Account(number, holder, inicialBalance, withdrawLimit);

			System.out.print("Enter amount for withdraw: ");
			double withdrawValue = sc.nextDouble();
			ac.withdraw(withdrawValue);
			System.out.printf("New balance: %.2f", ac.getBalance());
		}

		catch (DomainException e) {
			System.out.println("Withdraw Error: " + e.getMessage());
		}

		catch (InputMismatchException e) {
			System.out.println("Error: Input mismatch.");
		}
	}
}
