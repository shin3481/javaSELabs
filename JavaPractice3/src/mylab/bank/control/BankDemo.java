package mylab.bank.control;


import mylab.bank.entity.Bank;
import mylab.bank.entity.SavingsAccount;
import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;

public class BankDemo {

	public static void main(String[] args) {
        Bank bank = new Bank();

        System.out.println("=== ���� ���� ===");
        bank.createSavingsAccount("ȫ�浿", 10000.0, 3.0);
        bank.createCheckingAccount("��ö��", 20000.0, 5000.0);
        bank.createSavingsAccount("�̿���", 30000.0, 2.0);

        System.out.println();
        bank.printAllAccounts();

        System.out.println("\n=== �Ա�/��� �׽�Ʈ ===");
        try {
            bank.deposit("AC1000", 5000.0);
            bank.withdraw("AC1001", 3000.0);
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }

        System.out.println("\n=== ���� ���� �׽�Ʈ ===");
        try {
            SavingsAccount acc = (SavingsAccount) bank.findAccount("AC1000");
            acc.applyInterest();
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }

        System.out.println("\n=== ���� ��ü �׽�Ʈ ===");
        try {
            bank.transfer("AC1002", "AC1001", 5000.0);
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }

        System.out.println();
        bank.printAllAccounts();

        // ���� �׽�Ʈ
        try {
            bank.withdraw("AC1001", 6000.0);
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }

        try {
            bank.transfer("AC1001", "AC1002", 10000.0);
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }

        try {
            bank.deposit("AC9999", 1000.0);
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }
    }
}
