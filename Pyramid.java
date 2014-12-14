/*
 * File: Pyramid.java
 * Name: 
 * Section Leader: 
 * ------------------
 * This file is the starter file for the Pyramid problem.
 * It includes definitions of the constants that match the
 * sample run in the assignment, but you should make sure
 * that changing these values causes the generated display
 * to change accordingly.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Pyramid extends GraphicsProgram {

/** Width of each brick in pixels */
	private static final int BRICK_WIDTH = 30;

/** Height of each brick in pixels */
	private static final int BRICK_HEIGHT = 12;

/** Number of bricks in the base of the pyramid */
	private static final int BRICKS_IN_BASE = 14;
	
	public void run() {
		double cx = getWidth();
		double cy = getHeight(); 
		bulidRow(5,10,10);
	}
	
	
	private void drawBrick(double x, double y){
		new GRect( x, y, BRICK_WIDTH, BRICK_HEIGHT);
	}
	
	
	/*
	 * build a row with n bricks
	 */
	
	private void bulidRow(int n, double x, double y){
		for (int i = n; i > 0; i++) {
			drawBrick((x+i)*BRICK_WIDTH, y);
			}
	}
	
}

