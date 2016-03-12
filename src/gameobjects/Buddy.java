package gameobjects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;


public class Buddy extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int headX=5;
	private int headY=5;
	private boolean pressed = false;
	private int directionX=1;
	private int directionY=0; 
	private ArrayList<Integer> targetX= new ArrayList<Integer>();
	private ArrayList<Integer> targetY= new ArrayList<Integer>();
	private ArrayList<Integer> posX= new ArrayList<Integer>();
	private ArrayList<Integer> posY= new ArrayList<Integer>();
	private boolean gameover = false;
	private boolean pause = false;
	Random randy1= new Random();
	
	public void keyPressed(KeyEvent e)						//key pressed
	{
		if(!pressed)
		{
			pressed = true;
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
			{
				if(directionY != 1)
				{
					directionY = -1;
				}
					directionX =0;
			}
				break;
				
			case KeyEvent.VK_DOWN:
			{
				if(directionY != -1)
				{
					directionY = 1;
				}
					directionX =0;
			}
				break;
			case KeyEvent.VK_LEFT:
			{
				if(directionX != 1)
				{
					directionX = -1;
				}
					directionY =0;
			}
				break;
			case KeyEvent.VK_RIGHT:
			{
				if(directionX != -1)
				{
					directionX = 1;
				}
					directionY =0;
			}
				break;
				
			case KeyEvent.VK_SPACE:
			{
				
				fun();	
			}
				break;
			default:
				break;
			}
		}
	}
	public void KeyReleased(KeyEvent e)						//key released
	{
		pressed = false;
	}
	
	public void update()
	{
		collision();
		headX+= directionX;
		headY+= directionY;
	}
	
	public void setTarget(Point p)
	{
		if(targetX.isEmpty()&&targetY.isEmpty())
		{
			targetX.add(p.x);
			targetY.add(p.y);
			posX.add(1);
			posY.add(1);
		}
		else
		{
			targetX.add(p.x);
			targetY.add(p.y);
			posX.add(1);
			posY.add(1);
		}
	}
	
	public void movTarget(Point p)
	{
		if(targetX.isEmpty()&&targetY.isEmpty())
		{
			targetX.add(p.x);
			targetY.add(p.y);
		}
		else
		{
			targetX.add(p.x);
			targetY.add(p.y);
		}
	}
	
	public void loc()
	{
		for(int i=0;i<targetX.size();i++)
		{
			if(targetX.get(i) + posX.get(i) < 0)
				posX.set(i,1);
			if (targetX.get(i) + posX.get(i) > 512)
				posX.set(i,-1);
			if (targetY.get(i) + posY.get(i) < 0)
				posY.set(i,1);
			if (targetY.get(i) + posY.get(i) > 512)
				posY.set(i,-1);
		
			targetX.set(i,targetX.get(i) + posX.get(i));
			targetY.set(i,targetY.get(i) + posY.get(i));
		}
	}

	private boolean isSatisfied(int x,int y) // distance formula
	{
		return headX>x-25&&headX<x+25&&headY>y-25&&headY<y+25;
	}
	
	private void fun()
	{
		pause = !pause;
		
	}
	
	public boolean paus()
	{
		return pause;
	}
	
	private void collision()					//collision
	{
		for(int i=0;i<targetX.size();i++)
		{
			if(isSatisfied(targetX.get(i),targetY.get(i)))
			{
				gameover= true;
				break;
			}	
		}
		if(headX<=0||headX>512||headY<=0||headY>512)
			gameover = true;
	}
	
	public boolean isGameOver()
	{
		return gameover;
	}
	
	
	public void paint(Graphics2D g)				//color the buddy
	{
		g.setColor(Color.BLACK);
		g.fillOval(headX, headY, 30, 30);
	}
	
	public void look(Graphics2D g)				//color the enemy
	{
		for(int i=0;i<targetX.size();i++)
		{
			g.setColor(Color.LIGHT_GRAY);
			g.fillOval(targetX.get(i),targetY.get(i), 30, 30);
		}
	}
	
}
