package com.array;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AList {

	public static int totalNumber(List<Integer> numbers, Predicate<Integer> cusPredicate) {
		return numbers.parallelStream().filter(cusPredicate).reduce(Integer::sum).orElse(0);
	}

	public static void main(String[] args) {
		/*
		 * IntPredicate i= no -> no%2 ==0;
		 */
		List<Integer> list=Arrays.asList(1,2,3,4,5,6,7,8,9);
		System.out.println(totalNumber(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8), no -> true));
		System.out.println(totalNumber(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8), no -> no % 2 == 0));
		System.out.println(totalNumber(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8), no -> no % 2 != 0));
		System.out.println(list.stream().filter(a-> a > 4).collect(Collectors.toList()));
	}
}