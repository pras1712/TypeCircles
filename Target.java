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
		drawCircle(cx, cy, 72, Color.RED);
	}
	
	private void drawCircle(double a, double b, double r, Color c){
		double x = a - r;
		double y = b - r;
		GOval circle = new GOval(2 * r, 2 * r);
		circle.setColor(c);
		circle.setFilled(true);
		add(circle, x, y);
	}
}
