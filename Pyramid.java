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
		double cx = getWidth()/2;
		double cy = getHeight(); 
		for (int i = 0; i<14 ; i++) {
			bulidRow(i,19,cy-(14-i)*BRICK_HEIGHT);
			}	
	}
	
	
	private void drawBrick(double x, double y){
		GRect brick =new GRect( x, y, BRICK_WIDTH, BRICK_HEIGHT);
		add(brick);
	}
	
	
	/*
	 * build a row with n bricks
	 */
	
	private void bulidRow(int n, double x, double y){
		for (int i = 0; i < n; i++) {
			drawBrick((x+i)*BRICK_WIDTH, y);
			}
	}
	
}

