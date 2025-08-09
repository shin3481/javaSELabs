package mylab.bank.entity;
import java.util.ArrayList;
import java.util.List;
import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.AccountNotFoundException;


//���µ��� �迭�� �����ϰ� ���� ����� ����
public class Bank {
	private List<Account> accounts = new ArrayList<Account>(); // ���԰���: Bank�� Account�� ����
	private int nextAccountNumber = 1000;
	
	public Bank() {
		
	}
	//��	�⺻ �������� �ִ� ���� ���� ����
	public String createSavingsAccount(String ownerName, double initialBalance, double interestRate) {
		String accountNumber = "AC" + nextAccountNumber ++;
		SavingsAccount account = new SavingsAccount(accountNumber, ownerName, initialBalance, interestRate);
		accounts.add(account);
		System.out.println("Saving(����) ���°� �����Ǿ����ϴ�. " + account);
		return accountNumber; // ���¹�ȣ�� ��ȯ
		
	}
	//�� ���� �ѵ��� �ִ� üŷ ���� ����
	public String createCheckingAccount(String ownerName, double initialBalance, double withdrawalLimit) {
		String accountNumber = "AC" +nextAccountNumber++;
		CheckingAccount account = new CheckingAccount(accountNumber, ownerName, initialBalance, withdrawalLimit);
		accounts.add(account);
		System.out.println("üŷ ���°� �����Ǿ����ϴ�. "+ account);
		return accountNumber; //���¹�ȣ�� ��ȯ
	}
	//��	���� �˻�
    public Account findAccount(String accountNumber) throws AccountNotFoundException {
        return accounts.stream()
                .filter(acc -> acc.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElseThrow(() -> new AccountNotFoundException(
                        "���¹�ȣ " + accountNumber + "�� �ش��ϴ� ���¸� ã�� �� �����ϴ�."
                ));
    }
	//��	�Ա� ���
	public void deposit(String accountNumber, double amount) throws AccountNotFoundException {
		findAccount(accountNumber).deposit(amount);
	}
	//��	��� ���
	public void withdraw(String accountNumber, double amount) throws InsufficientBalanceException, AccountNotFoundException {
		findAccount(accountNumber).withdraw(amount);
	}
	//��	���� �� �۱� ���
	public void transfer(String fromAccountNumber, String toAccountNumber, double amount) throws InsufficientBalanceException, AccountNotFoundException{
		Account from = findAccount(fromAccountNumber);
		Account to = findAccount(toAccountNumber);
		from.withdraw(amount);
		to.deposit(amount);
		System.out.printf("%.1f���� %s���� %s�� �۱ݵǾ����ϴ�.%n", amount, fromAccountNumber, toAccountNumber);
	}
	//��� ���� �μ�
	public void printAllAccounts() {
		System.out.println("=== ��� ���� ��� ===");
		accounts.forEach(System.out::println);
		System.out.println("===============");
	}
}
