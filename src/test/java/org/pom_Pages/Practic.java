package org.pom_Pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Practic {

	public static void day(String[] arr, int size) {

		Arrays.sort(arr, Collections.reverseOrder());

		for (int i =0;i<=arr.length-1;i++) {

			System.out.print(arr[i]);

		}

	}

	public static void main(String[] args) {

		String ele = "My name is nikhil";

		String[] arr = ele.split(" ");

		int n = arr.length;
		day(arr, n);

		// output= "nikhil is name My";

	}
}
