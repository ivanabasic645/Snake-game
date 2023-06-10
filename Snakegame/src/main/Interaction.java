package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.JButton;

public class Interaction extends JPanel {
	
	private static final Color c = Color.LIGHT_GRAY;
	public static final JButton pause = new JButton("Pause");
	public static final JButton reset = new JButton("Reset");
	public JTextPane score = new JTextPane();
	
	private Main window;
	
	public Interaction(Main window) {
		this.window = window;
		
		//to stop buttons from flickering
		setDoubleBuffered(false);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(c);
		//setPreferredSize(new Dimension(this.window.getWidth(), this.window.getHeight()/6));
		populate();
	}
	

	private void populate() {
		score.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		
		add(score);
		add(pause);
		add(reset);
		
		revalidate();
		repaint();
	}
	
	@Override
	public void paintComponents(Graphics g) {
		super.paintComponents(g);
	}

}
