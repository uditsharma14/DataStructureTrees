package com.ds.dynamic.problems;

public class Memoziation {
	
	public static void main(String []args) {
		Integer number = 8;
		Integer []data= new Integer[number];
		//Integer factorialValue = calculateWithTabulatization(number,data);
		Integer factorialValue2 = calculateWithMemoization(number-1,data);
		System.out.println(factorialValue2);
		
	}

	
	
	private static Integer calculateWithMemoization(int number, Integer[] data) {
		if (number==0)
	        return 1;
	    return number * calculateWithMemoization(number-1,data);
	}



	private static Integer calculateWithTabulatization(int parseInt, Integer[] data) {
		// base case
		data[0] = 1;
		for (int i = 1; i < 8; i++) {
			data[i] = data[i - 1] * i;
		}
		return data[parseInt - 1];
	}
     
}
