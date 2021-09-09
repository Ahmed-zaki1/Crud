package com.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Rest {

	public static void main(String[] args) {
	Map map=new HashMap<>();
	map.put(1, "saif");
	map.put(2, "zaki");
	map.put(3, "zaki"); //it will ovverride
	map.put(4, "khan");
	System.out.println(map);

}
}
