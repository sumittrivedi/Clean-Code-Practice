package com.epam.engx.cleancode.naming.task3;

public class HarshadNumber {

	// print some Harshad numbers
	public static void main(String[] args) {
		long limit = 1000; // limit the seq of Harshad numbers
		for (int i = 1; i <= limit; i++) {
			if (i % loop(i) == 0) {
				System.out.println(i);
			}
		}
	}

	private static int loop(int number) {
		int sum = 0;
		while (number != 0) {
            sum += number % 10;
            number /=  10;
        }
		return sum;
	}

}
