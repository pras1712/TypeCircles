/*
 * File: Target.java
 * Name: 
 * Section Leader: 
 * -----------------
 * This file is the starter file for the Target problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Target extends GraphicsProgram {	
	public void run() {
		double cx = getWidth()/2;
		double cy = getHeight()/2;
		drawCircle(cx, cy, ONE_INCH, Color.RED);
		drawCircle(cx, cy, 0.65*ONE_INCH, Color.WHITE);
		drawCircle(cx, cy, 0.3*ONE_INCH, Color.RED);
	}
	
	private void drawCircle(double a, double b, double r, Color c){
		double x = a - r;
		double y = b - r;
		GOval circle = new GOval(2 * r, 2 * r);
		circle.setColor(c);
		circle.setFilled(true);
		add(circle, x, y);
	}
	
	private static final int ONE_INCH=72;
	
}
