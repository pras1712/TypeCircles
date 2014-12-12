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
		double a= readDouble("Enter a: ");
		double b= readDouble("Enter b: ");
		double c = square(a)+ square(b);
		println("c= " + c + ".");
	}
	private double square(double x){
		return x*x;
	}
}
