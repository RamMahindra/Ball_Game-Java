package gameobjects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Enemy {
	
	//set starting point
	Random randy= new Random();
	private int x;
	private int y;
	
	public Enemy()
	{
		x=Math.abs(randy.nextInt()%512);
		y=Math.abs(randy.nextInt()%512);
		
	}
	
	//getters 
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void life(Graphics2D g)
	{
			g.setColor(Color.GREEN);
			g.fillOval(x, y, 30, 30);
	}
	
	
}
