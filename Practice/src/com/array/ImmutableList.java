package com.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableList {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Hi");
		list.add("Hello");
		list.add("Hey");
		System.out.println(list);
		List<String> list2 = Collections.unmodifiableList(list); //making list as final
		list2.set(1, "Sakib"); 
		System.out.println(list2);
	}
}
