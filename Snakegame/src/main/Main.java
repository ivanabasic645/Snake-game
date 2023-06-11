package main;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import javax.swing.border.Border;


public class Main extends JFrame implements KeyListener, ActionListener {

    Snake snake;
    Interaction interactionBoard;
    boolean paused = false;

    public Main() {
        // create the snake
        this.snake = new Snake(this);
        this.interactionBoard = new Interaction(this);

        // timer for redrawing the screen
        Timer timer = new Timer(150, this);
        timer.start();

        // timer for drawing apples on the screen
        java.util.Timer drawApples = new java.util.Timer();
        Apple st = new Apple(this.snake);
        drawApples.schedule(st,0,3000);

        // window creation & drawing
        populateWindow();
        setTitle("Snake Game");
        setSize(525, 525);
        this.addKeyListener(this);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        requestFocus();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


	private void populateWindow() {
    	
    	add(this.interactionBoard, BorderLayout.NORTH);
    	add(this.snake, BorderLayout.CENTER);
		
	}


	@Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyReleased(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {
    	requestFocus();

        int c = e.getKeyCode();

        if(!paused) {
        	if (c == 39 && !this.snake.getDirection().equals("left")) {
                this.snake.setDirection("right"); // right arrow pressed
            }

            else if (c == 37 && !this.snake.getDirection().equals("right")) {
                this.snake.setDirection("left"); // left arrow pressed
            }

            else if (c == 38 && !this.snake.getDirection().equals("down")) {
                this.snake.setDirection("up"); // up arrow pressed
            }

            else if (c == 40 && !this.snake.getDirection().equals("up")) {
                this.snake.setDirection("down"); // down arrow pressed
            }
        }
        
        if (c == 32) {
        	togglePause();
        	this.interactionBoard.updatePauseButton();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // redraw the screen
    	this.interactionBoard.updateScore();
    	repaint();
    }
    
    public void togglePause() {
    	if(paused) {
    		paused = false;
    		repaint();
    	} else {
    		paused = true;
    	}
    }

	public boolean getPaused() {
		return paused;
	}
    
    public void resetGame() {
    	this.snake.newSnake();
    	repaint();
    }

    public static void main(String[] args) {
        new Main();
    }

}