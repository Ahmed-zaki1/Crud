package com.array;

import java.util.Scanner;

public class EvenOddWithoutIf {
	public static void main(String[] args) {
		/*
		 * Scanner sc = new Scanner(System.in);
		 * System.out.print("Enter Number To Check"); int no = sc.nextInt(); switch (no
		 * % 2) { case 1: System.out.println("Odd"); break; case 0:
		 * System.out.println("Even"); break; default: break; } sc.close();
		 */
		String[] arr = { "Even", "Odd" };

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the number: ");
		int no = sc.nextInt();

		System.out.println(arr[no % 2]);
		sc.close();
	}
}
