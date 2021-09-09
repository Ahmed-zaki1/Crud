package com.array;

public class Itera {
	/*
	 * static void main1(){ System.out.println("Hi"); }
	 * 
	 * } class Itera{ public static void main(String[] args) { Itera1 obj=null;
	 * Itera1.main1(); }
	 */
	/*
	 * public static void main(String[] args) { Integer in=new Integer(null);
	 * String str=new String(null); }
	 */
static void method1(Object object) {
	System.out.println("Hoi");
}

static void method1(Integer integer) {
	System.out.println("Hi");
	
}

public static void main(String[] args) {
	Itera.method1(0);
}

}