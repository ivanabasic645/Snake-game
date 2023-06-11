package main;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Interaction extends JPanel implements KeyListener{
	
	private static final Color c = Color.LIGHT_GRAY;
	private JButton pause;
	private JButton reset;
	public JLabel score;
	
	private ImageIcon iconStart = new ImageIcon(getClass().getResource("/images/start.png"), "START");
	private ImageIcon iconPause = new ImageIcon(getClass().getResource("/images/pause.png"), "PAUSE");
	private ImageIcon iconReset = new ImageIcon(getClass().getResource("/images/reset.png"), "RESET");
	private ImageIcon iconSound = new ImageIcon(getClass().getResource("/images/sound.png"), "SOUND ON");
	private ImageIcon iconMuted = new ImageIcon(getClass().getResource("/images/muted.png"), "MUTED");
	
	private Main window;
	
	public Interaction(Main window) {
		this.window = window;
		
		populate();
		//to stop buttons from flickering
		setDoubleBuffered(false);
	}	

	private void populate() {
		this.setBackground(c);
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		score = new JLabel("Score: 0");
		score.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		add(score);
		
		pause = new JButton(iconPause);
		pause.setToolTipText("Pause");
		pause.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(pause);
		
		reset = new JButton(iconReset);
		reset.setToolTipText("Reset");
		reset.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(reset);
		
		addListeners();
		
		revalidate();
		repaint();
	}
	
	private void addListeners() {
		pause.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Interaction.this.window.requestFocus();
				Interaction.this.window.togglePause();
				updatePauseButton();
			}
			
		});
		
		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Interaction.this.window.requestFocus();
				Interaction.this.window.resetGame();
			}
			
		});
		
		
	}
	
	public void updatePauseButton() {
		boolean paused = Interaction.this.window.getPaused();
		if(paused) {
			pause.setToolTipText("Start");
			pause.setIcon(iconStart);
		} else {
			pause.setToolTipText("Pause");
			pause.setIcon(iconPause);
		}
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		this.window.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
	
	public void updateScore() {
		this.score.setText("Score: " + Integer.toString(this.window.snake.getScore()));
	}

}
