package main;

import java.util.Random;
import java.util.TimerTask;

import static main.Rectangle.rec_height;
import static main.Rectangle.rec_width;

public class Apple extends TimerTask {
	
	private int posx;
	private int posy;
	private Snake snake;
	
	public int getPosx() {
		return posx;
	}
	
	public int getPosy() {
		return posy;
	}
	
	public Apple(Snake snake) {
		this.snake = snake;
	}
	
	public Apple() {
		posx = rec_width * new Random().nextInt(18);
		posy = rec_height * new Random().nextInt(18);
	}

	@Override
	public void run() {
		if(this.snake.getApple() == null) {
			this.snake.setApple(new Apple());
		}
	}
	
	

}
