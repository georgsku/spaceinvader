package SpaceInvader;

public class Skudd {
	private int locx, locy;
	public boolean player;
	
	public Skudd(int d, int e, boolean hvem) {
		locx = d;
		locy = e;
		player = hvem;
			
	}

	public int getLocx() {
		return locx;
	}

	public int getLocy() {
		return locy;
	}
	
	public boolean checkKollisjon(Player player) {
		double x = player.getLocX();
		double y = player.getLocY();
		int h = player.getHight();
		int w = player.getWidth();
		
		if (locx < x && locx + 3 > x && locy < y && locy + 3 > y) {
			return true;
		}
		else if (x < locx && x + w > locx && y < locy && y + h > locy) {
			return true;
		}
		else if (locx < x && locx + 3 > x && locy > y && locy < y + h) {
			return true;
		}
		else if (locx > x && locx < x + w && locy < y && locy + 3 > y) {
			return true;
		}
		else {
			return false;
		}
	
	}
	public boolean checkKollisjon(Enemy enemy) {
		double x = enemy.getLocX();
		double y = enemy.getLocY();
		
		if (locx < x && locx + 3 > x && locy < y && locy + 3 > y) {
			return true;
		}
		else if (x < locx && x + 25 > locx && y < locy && y + 15 > locy) {
			return true;
		}
		else if (locx < x && locx + 3 > x && locy > y && locy < y + 15) {
			return true;
		}
		else if (locx > x && locx < x + 25 && locy < y && locy + 3 > y) {
			return true;
		}
		else {
			return false;
		}
	
	}
	public void moveSkudd() {
		if (player) { 
			locy -=2;
	} else {
		locy += 2;
		}
	
	}
	
}
