package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.AccountNotFoundException;


public abstract class Account {
	protected String accountNumber; //계좌번호
	protected String ownerName; //소유자 이름
	protected double balance; //잔액
	
	public Account(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialBalance; // 초기잔액
	}
	//계좌번호
	public String getAccountNumber() {
		return accountNumber;
	}
	
	//소유자 이름
	public String getOwnerName() {
		return ownerName;
	}
	//● 잔액
	public double getBalance() {
		return balance;
	}
	//●	입금
	public void deposit(double amount) {
		balance += amount;
        System.out.printf("%.1f원이 입금되었습니다. 현재 잔액: %.1f원%n", amount, balance);

	}
	//●	출금
	public void withdraw(double amount) throws InsufficientBalanceException{
		if (balance < amount) {
			throw new InsufficientBalanceException("잔액이 부족합니다. 현재 잔액: " + balance + "원");
		}
		balance -=amount;
		System.out.printf("%.1f원이 출금되었습니다. 현재 잔액: %.1f원%n",amount,balance);
	}
	@Override
	public String toString() {
		if(this instanceof SavingsAccount) {
			SavingsAccount sa = (SavingsAccount) this;
			return String.format("계좌번호: %s, 소유자: %s, 잔액: %.1f원, 이자율: %.1f%%",accountNumber, ownerName, balance,sa.getInterestRate());
		}
		else if(this instanceof CheckingAccount) {
			CheckingAccount ca = (CheckingAccount) this;
			return String.format("계좌번호: %s, 소유자: %s, 잔액: %.1f원, 출금 한도: %.1f원",accountNumber, ownerName, balance, ca.getWithdrawalLimit());
		}
		else {
			return String.format("계좌번호: %s, 소유자: %s, 잔액: %.1f원",accountNumber, ownerName, balance);
		}
		
	}
}
