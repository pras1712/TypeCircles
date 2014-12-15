/*
 * File: CS106ATiles.java
 * Name: 
 * Section Leader: 
 * ----------------------
 * This file is the starter file for the CS106ATiles problem.
 */

import acm.graphics.*;
import acm.program.*;

public class CS106ATiles extends GraphicsProgram {
	
	/** Amount of space (in pixels) between tiles */
	private static final int TILE_SPACE = 20;
	
	/** Width of tiles */
	private static final int TILE_WIDTH = 100;	
	
	/** height of tiles */
	private static final int TILE_HEIGHT = 60;

	public void run() {
		double cx = getWidth()/2;
		double cy = getHeight()/2;
		
		/*
		 * These are the numbers by which the centers of the tiles are offset
		 * from the center of the display
		 */
		
		double a= TILE_SPACE/2.0+TILE_WIDTH/2.0;
		double b= TILE_SPACE/2.0+TILE_HEIGHT/2.0;
		
	
		drawTileWithLabel(cx-a, cy-b);
		drawTileWithLabel(cx+a, cy+b);
		drawTileWithLabel(cx-a, cy+b);
		drawTileWithLabel(cx+a, cy-b);
		
	}
	
	/** Draw tile with label centered at (x,y) */
	
	private void drawTileWithLabel(double x, double y){
		drawTile(x, y);
		drawLabel(x, y);	
	}
	
	private void drawTile(double x, double y) {
		GRect tile= new GRect(TILE_WIDTH, TILE_HEIGHT);
		double a = x - TILE_WIDTH/2.0;
		double b = y - TILE_HEIGHT/2.0;
		add(tile, a, b);
	}
	
	private void drawLabel(double x, double y){
		GLabel label= new GLabel("CS106A");
		double a = x - label.getWidth()/2.0;
		double b = y +  label.getAscent()/2.0;
		add(label, a, b);	
	}
}

