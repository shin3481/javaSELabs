package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;
//인출 한도가 있는 체킹 계좌
public class CheckingAccount extends Account {

	private double withdrawalLimit; //출금한도
	
	//인출 한도가 있는 체킹 계좌 생성
	public CheckingAccount(String accountNumber, String ownerName, double initialBalance, double withdrawalLimit) {
		super(accountNumber, ownerName, initialBalance);
		this.withdrawalLimit = withdrawalLimit;
	}
	//출금 한도 가져오기
	public double getWithdrawalLimit() {
		return withdrawalLimit;
		
	}
	//출금
	@Override
	public void withdraw(double amount) throws InsufficientBalanceException {
		if (amount > withdrawalLimit) {
			throw new WithdrawalLimitExceededException("출금 한도를 초과했습니다. 한도: " + withdrawalLimit + "원");
		}
		super.withdraw(amount);
	}
}
