/*
 * File: PythagoreanTheorem.java
 * Name: 
 * Section Leader: 
 * -----------------------------
 * This file is the starter file for the PythagoreanTheorem problem.
 * The program computes the hypotenuse of a triangle with given legs
 * a and b.
 */

import acm.program.*;

public class PythagoreanTheorem extends ConsoleProgram {
	
	public void run() {
		println("Enter values to compute the pythagorean theorem.");
		double a= readDouble("Enter a: ");
		double b= readDouble("Enter b: ");
		double c = squareRoot(square(a)+ square(b));
		println("c= " + c + ".");
	}
	
	private double square(double x){
		return x*x;
	}
	
	/*
	 * Use Newton's Method to approximate squareroot. 
	 * Iterate 100 times for accuracy.
	 * We used the starting approximation of 5.
	 * Doesn't matter what we pick
	 * (This is before I learned java has a math package)
	 */
	
	private double squareRoot(double x){
		double y=5;
		for (int i = 0; i < 100; i++) {
			y=(y + x/y)/2;
		}
		return y;
	}
}
