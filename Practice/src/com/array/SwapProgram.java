package com.array;

import java.util.Scanner;

public class SwapProgram {
	public static void main(String[] args) {
		int a, b;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of a and b");
		a = sc.nextInt();
		b = sc.nextInt();
		System.out.println("Before swap = " + a + " " + b);
		/*
		 * c = a; a = b; b = c;
		 */
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("After Swap = " + a + " " + b);
		sc.close();
	}

}
