import java.awt.AWTException;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Robot;
import javax.swing.*;

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.event.*;
import java.awt.image.BufferedImage;

public class TypeCircles extends GraphicsProgram{
	
	public static void main(String[] args) {
		new TypeCircles().start(args);
	}
	
	
/** Width and height of application window in pixels.  On some platforms 
  * these may NOT actually be the dimensions of the graphics canvas. */
	public static final int APPLICATION_WIDTH = 700;
	public static final int APPLICATION_HEIGHT = 740;
	
/** Dimensions of game board.  On some platforms these may NOT actually
  * be the dimensions of the graphics canvas. */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;
	
/** Maximum size of textField */
	private static final int max_size = 10;
	
	
	
	
	private int fontSize = 70;

//	private String FONT = "American Typewriter-" + Integer.toString(fontSize);
	private String FONT = "Serif-" + Integer.toString(fontSize);
	
	
	
/** Private instance variables */
	private RandomGenerator rgen = RandomGenerator.getInstance();
	private double a = rgen.nextDouble(0, WIDTH/2);
	private double b = rgen.nextDouble(0, HEIGHT/2);
	
	private GOval centerCircle = new GOval(a, b, WIDTH/2, HEIGHT/2);
	private GLabel label = new GLabel("");
	
	private int appx = 0;
	private int appy = 0;
	
	private BufferedImage screenshot;
	private boolean boo = false;
	private GRect boundingRect;
	
	private JComboBox pickColor;
	private JTextField textField;

	
	//in my travels, I have found that at times, GObjects are not added to the canvas 
	//until the whole method at hand is finished running. In this particular case, 
	//the GLabel added by actionPerformed doesn't get added until that method is finished.
	//For this reason, I needed a way to have something happen immediately after this method, 
	//without calling another method in actionPerformed. Thus, I've put in this run method which
	//constantly checks if actionPerformed has happened or not. It's miserable but it works.
	
	public void run(){
		while(true){ //while true loop so that we are constantly checking if to do something.
			if(!boo){
				System.out.print(""); //I don't know why this is needed. For some reason, the code doesn't work without it.
			} else{
				pause(50); //pause to ensure that the screenshot has the label
				runAction();
				doCircles();
				boo = false;
			}
		}
		
	}

	/**
	 * Initializes North region with JTextFields and JComboBoxes
	 */
	
	public void init(){
		add(new JLabel("Text:"), NORTH);
		
		textField = new JTextField(max_size);
		textField.addActionListener(this);
//		addActionListeners();
		add(textField, NORTH);
		
		pickColor = new JComboBox();
		pickColor.setEditable(false);
		pickColor.addItem("Red-Orange");
		pickColor.addItem("Green-Blue");
		pickColor.addItem("Red-Pink");
		pickColor.addItem("Black-Gray");
		pickColor.addItem("Blue-Orange");
		
		pickColor.setSelectedItem("Red-Orange");
		add(new JLabel("Color Scheme:"), NORTH);
		add(pickColor, NORTH);	
	}
	
	/**
	 * The pre-circle action of the program.
	 * Obtains the x and y at the top left, and changes the label 
	 * out for pixel sized GRects
	 */
	
	public void runAction(){
		screenshot = createScreenCapture(0 , 0, WIDTH, HEIGHT);
		getAppxy();
		substituteLabel();
	}
	
	/**
	 * Equivalent to getBounds(), but uses a GRect rather than 
	 * a GRectabgle. Mostly easier to work with.
	 */

	private GRect getBoundingRect(GLabel lab){
		return new GRect(lab.getX(), lab.getY() - lab.getAscent(), lab.getWidth(), lab.getAscent() + lab.getDescent());
	}
	
	
	/**
	 * Gets the x and y coordinates (appx, appy) of the top left pixel
	 * in the applet (relative to the entire screen). Necessary to get the 
	 * Robot package to use terms pertaining to just the applet.
	 */
	
	private void getAppxy(){
		for(int i = 0; i< WIDTH; i++){
			for(int j = 0; j< HEIGHT; j++){
				
				int rgb1 = screenshot.getRGB(i, j);
				Color c = new Color(rgb1);
				
				if(isWhite(c)){ // probably the first white pixel is the top left of the applet works so far
					appx = i;
					appy = j;
					break;
				}
			}
			if(appx > 0 && appy > 0) break;
		}		
	}
	
	/**
	 * Replaces the GLabel with pixel sized black GRects.
	 * These are easier to identify, and remove.
	 */
	
	private void substituteLabel(){
		for(int i = 0; i< WIDTH; i++){
			for(int j = 0; j< HEIGHT; j++){
				
				int rgb = screenshot.getRGB(i, j);
				Color c = new Color(rgb);
				
				
				if(isColor(c)){
					GRect pix = new GRect(i - appx, j - appy, 1, 1);
					pix.setFilled(true);
					add(pix);
				} 
				
			}
		}
		remove(label);
	}
	
	
	/**
	 * Responds to text input. Removes everything, changes
	 * ivar label to the text and then adds it to the screen.
	 * Changes boo to true to indicate that the label has been added.
	 */
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == textField){
			removeAll();
			a = rgen.nextDouble(0, WIDTH/2);
			b = rgen.nextDouble(0, HEIGHT/2);
			centerCircle = new GOval(a, b, WIDTH/2, HEIGHT/2);
			GLabel newLabel = new GLabel(textField.getText());
			newLabel.setColor(new Color(155, 155, 155));
			newLabel.setFont(FONT);
			add(newLabel, a + WIDTH/4 - newLabel.getWidth()/2, b + HEIGHT/4  + newLabel.getHeight()/2);
			boundingRect = getBoundingRect(newLabel);
			label = newLabel;
			boo = true;
		}
	}
	
	
	/**
	 * Cuts up the circles in four steps:
	 * 1. draws initial circle
	 * 2. splits up center circle some number of times 
	 * 3. splits outside of the center for evenness
	 * 4. splits up the points that make up the label
	 */
	
	private void doCircles(){
		initCircle();
//		doCenterCircle();
//		doOutside();	
		doLabel();
	}

	/**
	 * Draws a circle in the center of the screen.
	 */
	
	private void initCircle(){
		GOval circle = new GOval(0, 0, WIDTH, HEIGHT);
		circle.setFilled(true);
		circle.setFillColor(new Color(255, 0, 0));
		circle.setColor(new Color(255, 0, 0));
		add(circle);
		circle.sendToBack();
	}
	
	
	/**
	 * We have a circle of size WIDTH/2 by HEIGHT/2 randomly placed
	 * and slice it up many times. This ensures that the environment
	 * for the label has little whitespace. Otherwise, the algorithm 
	 * might miss parts of the label since it depends on what is behind
	 * that part of the label.
	 */
	
	private void doCenterCircle(){
		for(int i = 0; i < 200; i++){
			while(true){
				double xloc= rgen.nextDouble(0, WIDTH);
				double yloc= rgen.nextDouble(0, HEIGHT);
				GFillable pix = (GFillable) getElementAt(xloc, yloc);
				if(getElementAt(xloc, yloc) != null  && centerCircle.contains(xloc, yloc) && !isBlack(pix.getFillColor())){
					cutUpAtPoint(xloc, yloc);
					break;
				}
			}	
		}
	}
	
	
	/**
	 * Cuts up the outside of the center circle for evenness (not necessary)
	 */
	private void doOutside(){
		for(int i=0; i < 5; i++){
			while(true){
				double xloc= rgen.nextDouble(0, WIDTH);
				double yloc= rgen.nextDouble(0, HEIGHT);
				if(getElementAt(xloc, yloc) != null  && !centerCircle.contains(xloc, yloc) ){
					cutUpAtPoint(xloc, yloc);
					break;
				}
			}
		}
	}
	
	
	/**
	 * Cuts up the points that make up the label
	 */
	private void doLabel(){
		for(int i = (int)boundingRect.getX(); i< boundingRect.getX() + boundingRect.getWidth(); i++){
			for(int j = (int)boundingRect.getY(); j< boundingRect.getY() + boundingRect.getHeight(); j++){
				GFillable pix = (GFillable) getElementAt(i, j);
				if(pix!= null && isBlack(pix.getFillColor())){
					remove((GObject) pix);
					cutUpAtPoint(i, j);
					
				}	
			}
		}
	}

	/**
	 * Makes a screenshot of the entire screen
	 */
	public static BufferedImage createScreenCapture(int x, int y, int width, int height){
		Rectangle rect = new Rectangle(x, y, width, height);
		try {
			return new Robot().createScreenCapture(rect);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * Checks if the color is the original label color.
	 * we us this color because we are unlikely to find it naturally on the screen.
	 */
	private boolean isColor(Color c) {
		if( c.getRed() == 155 && c.getBlue() == 155 && c.getGreen() == 155){
			return true;
		}
		return false;
	}
	
	/**
	 * Checks if a color is black
	 */
	private boolean isBlack(Color c) {
		if( c.getRed() == 0 && c.getBlue() == 0 && c.getGreen() == 0){
			return true;
		}
		return false;
	}
	
	
	/**
	 * Checks if a color is white
	 */
	private boolean isWhite(Color c) {
		if( c.getRed() == 255 && c.getBlue() == 255 && c.getGreen() == 255){
			return true;
		}
		return false;
	}
	
	/**
	 * Cuts up the circle at a given point
	 */
	private void cutUpAtPoint(double x, double y){
		if(getElementAt(x,y) != label && getElementAt(x,y) != null){
			cutUp((GOval)getElementAt(x,y));
		}
	}

	/**
	 * Cuts off a circle into four smaller ones
	 * (this is the core of the program)
	 */
	private void cutUp(GOval circle){
		double x = circle.getX();
		double y = circle.getY();
		double r = circle.getWidth();
		
		remove(circle);
		
		GOval circle_1 = new GOval(x, y, r/2, r/2);
		circle_1.setFilled(true);
		circle_1.setFillColor(getColor1());
//		circle_1.setColor(getColor1());
		add(circle_1);
		circle_1.sendToBack();
		
		
		GOval circle_2 = new GOval(x + r/2, y, r/2, r/2);
		circle_2.setFilled(true);
		circle_2.setFillColor(getColor2());
//		circle_2.setColor(getColor2());
		add(circle_2);
		circle_2.sendToBack();
		
		GOval circle_3 = new GOval(x, y + r/2, r/2, r/2);
		circle_3.setFilled(true);
		circle_3.setFillColor(getColor2());
//		circle_3.setColor(getColor2());
		add(circle_3);
		circle_3.sendToBack();
		
		GOval circle_4 = new GOval(x + r/2, y + r/2, r/2, r/2);
		circle_4.setFilled(true);
		circle_4.setFillColor(Color.WHITE);
		add(circle_4);
		circle_4.sendToBack();
	}
	

	/**
	 * Color at the top left quadrant
	 */
	private Color getColor1(){
		String color = (String) pickColor.getSelectedItem();
		if(color.equals("Red-Orange")) return Color.RED;
		if(color.equals("Green-Blue")) return Color.GREEN;
		if(color.equals("Red-Pink")) return Color.RED;
		if(color.equals("Black-Gray")) return new Color(20, 20, 20);
		if(color.equals("Blue-Orange")) return Color.BLUE;

		return Color.WHITE;
	}
	
	/**
	 * Colors at the top right and bottom left quadrants
	 */
	private Color getColor2(){
		String color = (String) pickColor.getSelectedItem();
		if(color.equals("Red-Orange")) return Color.ORANGE;
		if(color.equals("Green-Blue")) return Color.BLUE;
		if(color.equals("Red-Pink")) return Color.PINK;
		if(color.equals("Black-Gray")) return Color.LIGHT_GRAY;
		if(color.equals("Blue-Orange")) return Color.ORANGE;

		return Color.WHITE;
	}

}

