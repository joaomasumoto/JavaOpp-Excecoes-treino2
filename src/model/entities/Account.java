package model.entities;

/**
 * This class represents an account entity with essential information.
 */

public class Account {
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;

	public Account() {
	}

	/**
	 * Constructs an Account object with the provided details.
	 * @param number The account number.
	 * @param holder The name of the account holder.
	 * @param balance The initial balance of the account.
	 * @param withdrawLimit The withdrawal limit of the account.
	 */
	
	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}
	
	/** 
	 * Encapsulation through Getters and Setters
	 * 
	 * I've implemented getters for retrieving account details and setters to control access
	 * to sensitive properties. Specifically, I removed the setBalance method to prevent potential 
	 * fraudulent activities and ensured that the balance and withdrawLimit can only be modified 
	 * through designated deposit and withdraw methods, adhering to the principle of encapsulation.
	 */

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	/**
	 * Performs a deposit into the account.
	 * @param amount The amount to be deposited.
	 */
	
	public void deposit(Double amount) {
		balance += amount;
	}
	
	/**
	 * Performs a withdrawal from the account.
	 * @param amount The amount to be withdrawn.
	 */
	
	public void withdraw(Double amount) {
		balance -= amount;
	}
}
