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
		while (true) {
			if (value == SENTINEL) break;
			if((value % 2) == 0){
				value= value/2;
				println(2*value+ "is even, so I take half:" + value );
				break;
			}
		}
	
	}
}

