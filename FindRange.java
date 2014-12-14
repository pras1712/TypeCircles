/*
 * File: FindRange.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This program finds the largest and smallest numbers out of a set of given numbers
 */

import acm.program.*;

public class FindRange extends ConsoleProgram {
	
	private static final int SENTINEL = 0;
	
	public void run() {
		println("This program finds the largest and smallest numbers.");
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		while (true) {
			int value = readInt(" ? ");
			if (value==SENTINEL && max==Integer.MIN_VALUE){
				println("No numbers have been entered");
			}
			if (value == SENTINEL) break;
			if (value> max){
				max= value;
			}
			if (value<min){
				min=value;
			}
		}
		
		if (max!=Integer.MIN_VALUE && min!=Integer.MAX_VALUE){
		println("smallest="+min);
		println("largest="+max);	
		
		}
	}
}

