package com.cognixia.jump.fullstack.projects;

import java.util.Scanner;

public class GetInteger {

	static Scanner input1;

	public int getInt() {
		int userInput = 0;
		boolean valid;

		do {
			// re-initialize the scanner
			input1 = new Scanner(System.in);

			// verify the right kind of input
			valid = input1.hasNextInt();

			// we only Read the user input if it is valid
			if (valid) {
				// this is the actual reading
				userInput = input1.nextInt();
			} else {
				System.out.println("Not a number");
			}
		} while (!valid);

		return userInput;
	}

	public void closeScanner() {
		input1.close();
	}

}
