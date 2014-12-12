/*
 * File: PythagoreanTheorem.java
 * Name: 
 * Section Leader: 
 * -----------------------------
 * This file is the starter file for the PythagoreanTheorem problem.
 */

import acm.program.*;

public class PythagoreanTheorem extends ConsoleProgram {
	
	public void run() {
		println("Enter values to compute the pythagorean theorem.");
		double a= readInt("Enter a: ");
		double b= readInt("Enter b: ");
		int c = a+b;
		println("c= " + c + ".");
	}
}
