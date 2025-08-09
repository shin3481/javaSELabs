package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.AccountNotFoundException;


public abstract class Account {
	protected String accountNumber; //���¹�ȣ
	protected String ownerName; //������ �̸�
	protected double balance; //�ܾ�
	
	public Account(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialBalance; // �ʱ��ܾ�
	}
	//���¹�ȣ
	public String getAccountNumber() {
		return accountNumber;
	}
	
	//������ �̸�
	public String getOwnerName() {
		return ownerName;
	}
	//�� �ܾ�
	public double getBalance() {
		return balance;
	}
	//��	�Ա�
	public void deposit(double amount) {
		balance += amount;
        System.out.printf("%.1f���� �ԱݵǾ����ϴ�. ���� �ܾ�: %.1f��%n", amount, balance);

	}
	//��	���
	public void withdraw(double amount) throws InsufficientBalanceException{
		if (balance < amount) {
			throw new InsufficientBalanceException("�ܾ��� �����մϴ�. ���� �ܾ�: " + balance + "��");
		}
		balance -=amount;
		System.out.printf("%.1f���� ��ݵǾ����ϴ�. ���� �ܾ�: %.1f��%n",amount,balance);
	}
	@Override
	public String toString() {
		if(this instanceof SavingsAccount) {
			SavingsAccount sa = (SavingsAccount) this;
			return String.format("���¹�ȣ: %s, ������: %s, �ܾ�: %.1f��, ������: %.1f%%",accountNumber, ownerName, balance,sa.getInterestRate());
		}
		else if(this instanceof CheckingAccount) {
			CheckingAccount ca = (CheckingAccount) this;
			return String.format("���¹�ȣ: %s, ������: %s, �ܾ�: %.1f��, ��� �ѵ�: %.1f��",accountNumber, ownerName, balance, ca.getWithdrawalLimit());
		}
		else {
			return String.format("���¹�ȣ: %s, ������: %s, �ܾ�: %.1f��",accountNumber, ownerName, balance);
		}
		
	}
}
