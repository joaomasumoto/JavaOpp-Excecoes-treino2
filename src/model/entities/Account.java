package model.entities;

import model.exceptions.DomainException;

public class Account {
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;

	public Account() {
	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
		validateAccount();
	}

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

	public void deposit(Double amount) {
		balance += amount;
	}

	public void withdraw(Double amount) {
		validateWithdraw(amount);
		balance -= amount;
	}

	private void validateAccount() {
		if (number <= 0) {
			throw new DomainException("Account Number must be positive");
		}
		for (int i = 0; i < holder.length(); i++) {
			char c = holder.charAt(i);
			if (!(('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z') || (c == ' '))) {
				throw new DomainException("Holder name must contains only letters and spaces");
			}
		}
		if (balance < 0) {
			throw new DomainException("Inicial Balance must be greater than zero");
		}
		if (withdrawLimit < 0) {
			throw new DomainException("Withdraw Limit must be greater than zero");
		}
		if (withdrawLimit == 0) {
			throw new DomainException("Withdraw Limit must be must be greater than zero");
		}
	}

	private void validateWithdraw(Double amount) {
		if (amount > getWithdrawLimit()) {
			throw new DomainException("The amount exceeds withdraw limit");
		} else if (amount > getBalance()) {
			throw new DomainException("Not enough balance");
		}

	}

}
