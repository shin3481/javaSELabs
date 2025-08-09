package mylab.bank.entity;
import java.util.ArrayList;
import java.util.List;
import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.AccountNotFoundException;


//계좌들의 배열을 관리하고 다음 기능을 제공
public class Bank {
	private List<Account> accounts = new ArrayList<Account>(); // 포함관계: Bank가 Account를 소유
	private int nextAccountNumber = 1000;
	
	public Bank() {
		
	}
	//●	기본 이자율이 있는 저축 계좌 생성
	public String createSavingsAccount(String ownerName, double initialBalance, double interestRate) {
		String accountNumber = "AC" + nextAccountNumber ++;
		SavingsAccount account = new SavingsAccount(accountNumber, ownerName, initialBalance, interestRate);
		accounts.add(account);
		System.out.println("Saving(저축) 계좌가 생성되었습니다. " + account);
		return accountNumber; // 계좌번호만 반환
		
	}
	//● 인출 한도가 있는 체킹 계좌 생성
	public String createCheckingAccount(String ownerName, double initialBalance, double withdrawalLimit) {
		String accountNumber = "AC" +nextAccountNumber++;
		CheckingAccount account = new CheckingAccount(accountNumber, ownerName, initialBalance, withdrawalLimit);
		accounts.add(account);
		System.out.println("체킹 계좌가 생성되었습니다. "+ account);
		return accountNumber; //계좌번호만 반환
	}
	//●	계좌 검색
    public Account findAccount(String accountNumber) throws AccountNotFoundException {
        return accounts.stream()
                .filter(acc -> acc.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElseThrow(() -> new AccountNotFoundException(
                        "계좌번호 " + accountNumber + "에 해당하는 계좌를 찾을 수 없습니다."
                ));
    }
	//●	입금 기능
	public void deposit(String accountNumber, double amount) throws AccountNotFoundException {
		findAccount(accountNumber).deposit(amount);
	}
	//●	출금 기능
	public void withdraw(String accountNumber, double amount) throws InsufficientBalanceException, AccountNotFoundException {
		findAccount(accountNumber).withdraw(amount);
	}
	//●	계좌 간 송금 기능
	public void transfer(String fromAccountNumber, String toAccountNumber, double amount) throws InsufficientBalanceException, AccountNotFoundException{
		Account from = findAccount(fromAccountNumber);
		Account to = findAccount(toAccountNumber);
		from.withdraw(amount);
		to.deposit(amount);
		System.out.printf("%.1f원이 %s에서 %s로 송금되었습니다.%n", amount, fromAccountNumber, toAccountNumber);
	}
	//모든 계정 인쇄
	public void printAllAccounts() {
		System.out.println("=== 모든 계좌 목록 ===");
		accounts.forEach(System.out::println);
		System.out.println("===============");
	}
}
