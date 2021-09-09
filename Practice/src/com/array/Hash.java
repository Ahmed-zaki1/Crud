package com.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;

public class Hash {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter numver");
		int s = br.read();
		HashMap<Integer, Float> hm = new HashMap<Integer, Float>();
		for (int i = 0; i < s; i++) {
			hm.put((br.read()), Float.parseFloat(br.readLine()));
		}
		System.out.println(display(hm));
	}

	public static String display(HashMap<Integer, Float> hm) {
		float sum = 0;
		int count = 0;
		DecimalFormat df = new DecimalFormat("#.00");
		Iterator<Integer> it = hm.keySet().iterator();
		while (it.hasNext()) {
			int y = it.next();
			if (y % 2 == 0) {
				sum = (float) (sum + hm.get(y));
				count++;
			}
		}
		float d = sum / count;
		return df.format(d);
	}
}
