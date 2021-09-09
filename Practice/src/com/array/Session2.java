package com.array;

public class Session2 {

	public static void main(String[] args) {

		int a = 10, b = 11, c = 12;
		if (a > b) {
			System.out.println("1"); // false
		} else if (b < c) {
			System.exit(0);
			System.out.println("2"); // false
		}
		else  {
			System.out.println("3"); // true
		} 
	}
}