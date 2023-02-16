import java.util.ArrayList;

class BankAccount {
	private double balance;
	private String name;
	private ArrayList<String> transactionLog = new ArrayList<String>();
	
	public BankAccount(String name){
		this.name = name;
        this.balance = 0;
        this.transactionLog = new ArrayList<String>();
	}

	public void deposit(double amount) {
		this.balance += amount;
		transactionLog.add("Deposit of " + amount + " euros");
	}
	
	public double withdraw(double amount) {
		if(balance < amount) return 0;
        else {
			balance -= amount;
			transactionLog.add("Withdrawal of " + amount + " euros");
			return amount;
		}
	}
	
	public void printStatement() {
		System.out.println(name + " account: ");
		for(String transaction : transactionLog){
			System.out.println(transaction);
		}
		System.out.println("The balance in the account is " + balance);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		transactionLog.add("Change of name from " + this.name + " to " + name);
		this.name = name;
    }
}

class TestBankAccount {
	public static void main(String args[]){
		BankAccount myAccount = new BankAccount("Tsaparas");

		myAccount.deposit(100);
		double pocketMoney = myAccount.withdraw(50);
		myAccount.deposit(100);
		pocketMoney += myAccount.withdraw(200);
		
        myAccount.setName("Panayiotis");
		myAccount.printStatement();
		System.out.println("Pocket money is " + pocketMoney);
	}
}
