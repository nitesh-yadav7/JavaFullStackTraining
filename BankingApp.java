public class BankingApp {
	public static void main(String[] args) {
		BankAccount acc = new BankAccount();
		ThreadWithdrawal t1 = new ThreadWithdrawal(acc, "A", 2000);
		ThreadWithdrawal t2 = new ThreadWithdrawal(acc, "M", 4000);
		ThreadDeposit t3 = new ThreadDeposit(acc, "M", 3500);
		ThreadWithdrawal t4 = new ThreadWithdrawal(acc, "R", 8000);
		ThreadWithdrawal t5 = new ThreadWithdrawal(acc, "S", 4000);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
}

class BankAccount {
	static int balance = 10000;

    static synchronized void getBalance() {
        System.out.println("Current Balance: " + balance);
    }

	synchronized void withdrawn(String name, int withdrawal) {
		if (balance >= withdrawal) {
			System.out.println(name + " withdrawn " + withdrawal);
			balance -= withdrawal;
			System.out.println("Balance after withdrawal: " + balance);
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(name + " you can not withdraw " + withdrawal);
			System.out.println("your balance is: " + balance);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	synchronized void deposit(String name, int deposit) {
		System.out.println(name + " deposited " + deposit);
		balance += deposit;
		System.out.println("Balance after deposit: " + balance);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class ThreadWithdrawal extends Thread {
	BankAccount object;
	String name;
	int dollar;

	ThreadWithdrawal(BankAccount ob, String name, int money) {
		this.object = ob;
		this.name = name;
		this.dollar = money;
	}

	public void run() { 
        object.withdrawn(name, dollar); 
    }
}

class ThreadDeposit extends Thread {
	BankAccount object;
	String name;
	int dollar;

	ThreadDeposit(BankAccount ob, String name, int money) {
		this.object = ob;
		this.name = name;
		this.dollar = money;
	}

	public void run() { 
        object.deposit(name, dollar); 
    }
}
