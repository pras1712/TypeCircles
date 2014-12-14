/*
 * File: Hailstone.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the Hailstone problem.
 */

import acm.program.*;

public class Hailstone extends ConsoleProgram {
	
	private static final int SENTINEL = 1;
	
	public void run() {
		int value = readInt("Enter a number: ");
		int total=0;
		while (true) {
			if (value == SENTINEL) break;
			if((value % 2) == 0){
				value= value/2;
				println(2*value + "is even, so I take half: " + value );
				total++;
			} else{
				value= 3*value +1;
				println((value-1)/3 + " is odd, so I take 3n+1: " + value );
				total++;
			}
		}
		
		println("The process took" + total + "to reach 1");
	
	}
}

