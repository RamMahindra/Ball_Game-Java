package base;

import gameobjects.Buddy;
import gameobjects.Enemy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class GamePanel extends JPanel implements KeyListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Buddy buddy = new Buddy();
	Enemy enemy1 = new Enemy();
	Enemy enemy2 = new Enemy();
	Enemy enemy3 = new Enemy();
	Enemy enemy4 = new Enemy();
	
	long lStartTime; // start time
	long lEndTime;
	long difference = 0;
	long temp1;
	long temp2;
	long temp3 = 0;
	
	
	public GamePanel()
	{
		addKeyListener(this);
		setFocusable(true);
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		
		super.paint(g);
		g.setColor(Color.BLUE);
		g.drawRect(0, 0, 542, 542);
		Graphics2D g2D = (Graphics2D)g;
		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		buddy.paint(g2D);
		buddy.look(g2D);
	}
	
	
	public void update()
	{
		lStartTime = new Date().getTime();
		buddy.setTarget(new Point(enemy1.getX(),enemy1.getY()));
		buddy.setTarget(new Point(enemy2.getX(),enemy2.getY()));
		buddy.setTarget(new Point(enemy3.getX(),enemy3.getY()));
		buddy.setTarget(new Point(enemy4.getX(),enemy4.getY()));
		while(true)//game loop
		{
			temp1 = new Date().getTime();
			while(buddy.paus())
			{
				try {
					Thread.sleep(24);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				temp2 = new Date().getTime();
				difference = temp2 - temp1;
			}
			temp3 = temp3+difference;
			difference = 0;
			buddy.loc();
			repaint();
			buddy.update();
			
			
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(buddy.isGameOver())
			{
				lEndTime = new Date().getTime();
				lEndTime = lEndTime- temp3;
				temp3 = lEndTime - lStartTime;
				JOptionPane.showMessageDialog(this, "Game Over\n Your score is "+(temp3/100));
				break;
			}
			
			
			
		}
	}

	public void pauso()
	{
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
			buddy.keyPressed(e);
		
		

	}
	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		buddy.KeyReleased(e);

	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
