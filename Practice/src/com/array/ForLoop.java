package com.array;

import java.util.Iterator;
import java.util.Scanner;

public class ForLoop {
	public static void main(String[] args) {
		int no;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Value");
		no = sc.nextInt();
		for (int i = 1; i <= no; i++)
			;
		{
			for (int j = 1; j < 5; j++) {
				System.out.print("*");
			}
			System.out.println(" ");
		}
		sc.close();

	}
}
