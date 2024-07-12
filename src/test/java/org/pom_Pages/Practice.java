package org.pom_Pages;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Practice {

	public static void main(String[] args) {

		String name = "nikhil";

		char[] ch = name.toCharArray();

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (char c : ch) {

			if (map.containsKey(c)) {

				map.put(c, map.get(c) + 1);

			} else {
				map.put(c, 1);
			}

		}

		for (Map.Entry<Character, Integer> e : map.entrySet()) {

			if (e.getValue() >= 1) {
				System.out.println(e.getKey() + "=>"+ e.getValue());
			}

		}

	}

}
