package main;

import java.util.Random;
import java.util.TimerTask;

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
		posx = 25 * new Random().nextInt(19);
		posy = 25 * new Random().nextInt(19);
	}

	@Override
	public void run() {
		if(this.snake.getApple() == null) {
			this.snake.setApple(new Apple());
		}
	}
	
	

}
