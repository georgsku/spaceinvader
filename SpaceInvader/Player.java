package SpaceInvader;

public class Player {
	
	public static int locx, locy;
	public static boolean dead = false;
	int romskipwidth = 60;
	int romskiphight = 40;
	
	public Player(int x, int y) {
		locx = x;
		locy = y;
	}

	public int getLocX() {
		return locx;
	}

	public int getLocY() {
		return locy;
	}
	
	public void Left() {
		locx -= 2;
		if (locx < 0) {
			locx = 0;
		}
	}
	
	public void Right() {
		locx += 2;
		if (locx > 540) {
			locx = 540;
		}
	}
	public static boolean isDead() {
		return dead; 
	}
	
	public int getWidth() {
		return this.romskipwidth;
	}
	public int getHight() {
		return this.romskiphight;
	}

	
	
}
