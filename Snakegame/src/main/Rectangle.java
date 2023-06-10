package main;

public class Rectangle {
	
	private int posx;
	private int posy;
	
	public static final int rec_width = 25;
	public static final int rec_height = 25;
	
	public Rectangle(int posx, int posy) {
		this.posy = posy;
		this.posx = posx;
	}
	
	public boolean intersects(Rectangle r1) {
		return this.posx == r1.getPosx() && this.posy == r1.getPosy();
	}

	private int getPosy() {
		return posy;
	}

	private int getPosx() {
		return posx;
	}
	
	private void setPosx(int increment) {
		this.posx += increment;
	}
	
	private void setPosy(int increment) {
		this.posy += increment;
	}

}
