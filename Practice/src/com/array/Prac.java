package com.array;

public class Prac {
static void m1 (Object obj) {
	System.out.println("Hello");
}
static void m1(String s) {
	System.out.println("Hii");
}
public static void main(String[] args) {
	Prac obj1=new Prac();
	Prac.m1(null);
}
}
