package ru.specialist;

import ru.specialist.bank.BankAccount;

public class App {

	public static void main(String[] args) {
		BankAccount b1 = new BankAccount("Specialist.ru");
		b1.deposit(800);
		BankAccount b2 = new BankAccount("Sergey");
		BankAccount.transfer(b1, b2, 300);
		System.out.println(b1);
		System.out.println(b2);
	}

}
