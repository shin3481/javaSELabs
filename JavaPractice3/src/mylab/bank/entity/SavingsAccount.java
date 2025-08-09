package mylab.bank.entity;

//기본 이자율이 있는 저축 계좌
public class SavingsAccount extends Account {
	private double interestRate;
	
	//기본 이자율이 있는 저축 계좌 생성
	public SavingsAccount(String accountNumber, String ownerName, double initialBalance, double interestRate) {
		super(accountNumber,ownerName,initialBalance);
		this.interestRate = interestRate;
		
	}
	
	// 이자율 가져오기
	public double getInterestRate() {
		return interestRate;

	}
	
	// 신청이자
	public void applyInterest() {
		double interest = balance *(interestRate / 100);
		deposit(interest);
        System.out.printf("이자 %.1f원이 적용되었습니다. 현재 잔액: %.1f원%n", interest, balance);

	}


}
