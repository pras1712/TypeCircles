/*
 * File: Hailstone.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This program computes the steps taken for the Hailstone sequence, and displays
 * the number of steps taken.
 */

import acm.program.*;

public class Hailstone extends ConsoleProgram {
	
	private static final int SENTINEL = 1;
	
	public void run() {
		int value = readInt("Enter a number: ");
		int count = 0;
		while (true) {
			if (value == SENTINEL) break;
			if((value % 2) == 0){
				value/= 2;
				println(2*value + " is even, so I take half: " + value );
			} else {
//				(value*=3)++;
				value = 3*value + 1;
				value= 3*value +1;
				println((value-1)/3 + " is odd, so I take 3n+1: " + value );
			}
			count++; //add to number of steps
		}
		
		println("The process took " + count + " to reach 1");
	
	}
}

