package base;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GameBase {

	
	
	public static void main(String args[])
	{
		JFrame win  = new JFrame("Goal 1");
		JOptionPane.showMessageDialog(null, "Use Arrow Keys to move buddy");
		GamePanel panel = new GamePanel();
		win.add(panel);
		win.setMinimumSize(new Dimension(550,550));
		win.setBackground(Color.BLUE);
		win.setResizable(false);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setVisible(true);
		win.getContentPane().setBackground(Color.RED);
		panel.update();
		win.dispose();

	}
	
}

