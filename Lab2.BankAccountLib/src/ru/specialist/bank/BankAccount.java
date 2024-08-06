package ru.specialist.bank;

public class BankAccount {
	private String owner;
	private double balance;
	
	public String getOwner() {
		return owner;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public BankAccount(String owner) {
		this.owner = owner;
		this.balance = 0d;
	}
	
	public void deposit(double summa) {
		if (summa < 0d) throw new IllegalArgumentException("summa < 0");
		this.balance += summa;
		
	}
	
	public boolean withdraw(double summa) {
		if (summa < 0d) throw new IllegalArgumentException("summa < 0");
		if (getBalance() >= summa) {
			this.balance -= summa;
			return true;
		}
		else
			return false;
	}
	
	@Override
	public String toString() {
		return String.format("%-20s : %8.2f", 
				getOwner(), getBalance());
	}
	
	public static boolean transfer(BankAccount source, BankAccount dest, double summa){
		if (source.withdraw(summa))	{
			dest.deposit(summa);
			return true;
		}
		else
			return false;
	}
	
}
