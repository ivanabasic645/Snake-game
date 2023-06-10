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

	public int getPosy() {
		return posy;
	}

	public int getPosx() {
		return posx;
	}
	
	public void setPosx(int increment) {
		this.posx += increment;
	}
	
	public void setPosy(int increment) {
		this.posy += increment;
	}

}
