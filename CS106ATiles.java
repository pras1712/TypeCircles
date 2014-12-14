/*
 * File: CS106ATiles.java
 * Name: 
 * Section Leader: 
 * ----------------------
 * This file is the starter file for the CS106ATiles problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class CS106ATiles extends GraphicsProgram {
	
	/** Amount of space (in pixels) between tiles */
	private static final int TILE_SPACE = 20;
	
	/** Width of tiles */
	private static final int TILE_WIDTH = 150;	
	
	/** height of tiles */
	private static final int TILE_HEIGHT = 80;

	public void run() {
		double cx = getWidth()/2;
		double cy = getHeight()/2;
		drawTileWithLabel(cx, cy);
		
	}
	
	/** Draw tile with center (x,y) */
	
	private void drawTile(double x, double y) {
		GRect tile= new GRect(TILE_WIDTH, TILE_HEIGHT);
		double a = x - TILE_WIDTH/2.0;
		double b = y - TILE_HEIGHT/2.0;
		add(tile, a, b);
	}
	
	private void drawTileWithLabel(double x, double y){
		drawTile(x, y);
		drawLabel(x, y);	
	}
	
	private void drawLabel(double x, double y){
		GLabel label= new GLabel("CS106A");
		double a = x - label.getWidth()/2.0;
		double b = y +  label.getAscent()/2.0;
		add(label, a, b);	
	}
}

