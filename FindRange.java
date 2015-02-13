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

		/*
		 * We set the max to be the minimum possible and the min to be the max
		 * possible, so that after any set of numbers that is chosen, the program
		 * knows the max and the min.
		 */

		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		int value = readInt(" ? ");
		while (value != 0) {
			if (value==SENTINEL && max==Integer.MIN_VALUE){
				println("No numbers have been entered");
			}
			if (value> max){
				max= value;
			}
			if (value<min){
				min=value;
			}
			value = readInt(" ? ");
		}

		if (max!=Integer.MIN_VALUE && min!=Integer.MAX_VALUE){ //If any number has been put, these numbers won't both be the max and min.
			println("smallest="+min);
			println("largest="+max);	

		}
	}
}

