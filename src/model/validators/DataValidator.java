package model.validators;

import model.entities.Account;
import model.exceptions.DomainException;

/**
 * Utility class for validating data related to account operations.
 * It encapsulates various validation routines to ensure that data meets
 * the required criteria before further processing.
 */

public class DataValidator {
	
	/**
	 * Validates the holder's name.
	 * 
	 * @param holder The name to be validated.
	 * @throws DomainException if the name contains characters other than letters or spaces.
	 */
	public void validateHolder(String holder) {
		for (int i = 0; i < holder.length(); i++) {
			char c = holder.charAt(i);
			if (!(('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z') || (c == ' '))) {
				throw new DomainException("Holder name must contains only letters and spaces");
			}
		}
	}
	
	/**
	 * Validates the account number.
	 * 
	 * @param number The account number to be validated.
	 * @throws DomainException if the number is not positive.
	 */
	public void validateNumber(int number) {
		if (number <= 0) {
			throw new DomainException("Account Number must be positive");
		}
	}

	/**
	 * Validates the initial balance.
	 * 
	 * @param balance The initial balance to be validated.
	 * @throws DomainException if the balance is less than zero.
	 */
	public void validateBalance(Double balance) {
		if (balance < 0) {
			throw new DomainException("Inicial Balance must be greater than zero");
		}
	}
	
	/**
	 * Validates the withdraw limit.
	 * 
	 * @param withdrawLimit The withdraw limit to be validated.
	 * @throws DomainException if the limit is less than zero or equal to zero.
	 */
	public void validateWithdrawLimit(Double withdrawLimit) {
		if (withdrawLimit < 0) {
			throw new DomainException("Withdraw Limit must be greater than zero");
		}
		if (withdrawLimit == 0) {
			throw new DomainException("Withdraw Limit must be must be greater than zero");
		}
	}

	/**
	 * Validates a withdrawal operation.
	 * 
	 * @param amount The amount to be withdrawn.
	 * @param ac     The account to perform the withdrawal.
	 * @throws DomainException if the amount exceeds the withdrawal limit or if there
	 *                         are insufficient funds.
	 */
	public void validateWithdraw(Double amount, Account ac) {
		if (amount > ac.getWithdrawLimit()) {
			throw new DomainException("The amount exceeds withdraw limit");
		} else if (amount > ac.getBalance()) {
			throw new DomainException("Not enough balance");
		}

	}
}
