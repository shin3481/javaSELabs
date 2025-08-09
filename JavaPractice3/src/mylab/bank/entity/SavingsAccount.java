package mylab.bank.entity;

//�⺻ �������� �ִ� ���� ����
public class SavingsAccount extends Account {
	private double interestRate;
	
	//�⺻ �������� �ִ� ���� ���� ����
	public SavingsAccount(String accountNumber, String ownerName, double initialBalance, double interestRate) {
		super(accountNumber,ownerName,initialBalance);
		this.interestRate = interestRate;
		
	}
	
	// ������ ��������
	public double getInterestRate() {
		return interestRate;

	}
	
	// ��û����
	public void applyInterest() {
		double interest = balance *(interestRate / 100);
		deposit(interest);
        System.out.printf("���� %.1f���� ����Ǿ����ϴ�. ���� �ܾ�: %.1f��%n", interest, balance);

	}


}
