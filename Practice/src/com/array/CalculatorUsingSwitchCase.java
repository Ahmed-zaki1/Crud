package com.array;

import java.util.Scanner;

public class CalculatorUsingSwitchCase {
	public static void main(String[] args) {
		char d;
		int a, b, c;
		for (int i = 1; i < 100; i++) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Choose an operator: +, -, *, or /");
			d = sc.next().charAt(0);
			System.out.println("Enter Value for doing arthmetic operation");
			a = sc.nextInt();
			b = sc.nextInt();

			switch (d) {
			case '+':
				c = a + b;
				System.out.println("Ans= " + a + "" + d + "" + b + "=" + c);
				break;
			case '-':
				c = a - b;
				System.out.println("Ans= " + a + "" + d + "" + b + "=" + c);
				break;
			case '*':
				c = a * b;
				System.out.println("Ans= " + a + "" + d + "" + b + "=" + c);
				break;
			case '/':
				c = a + b;
				System.out.println("Ans= " + a + "" + d + "" + b + "=" + c);
				break;
			default:
				System.out.println("Invalid operator!");
				break;
			}
		}
	}
}
