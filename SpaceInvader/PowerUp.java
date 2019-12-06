package SpaceInvader;

public class PowerUp {
	
	double locx;
	double locy;
	public boolean spawn;
	
	public PowerUp(double x, double y) {
		this.locx = x;
		this.locy = y;
	}

	public double getLocx() {
		return locx;
	}

	public double getLocy() {
		return locy;
	}
	
	public void moveDown() {
		locy += 1;
	}
	public boolean checkKollisjon(Player player) {
		double x = player.getLocX();
		double y = player.getLocY();
		
		if (locx < x && locx + 10 > x && locy < y && locy > y) {
			return true;
		}
		else if (x < locx && x + 80 > locx && y - 50 < locy && y + 30 > locy) {
			return true;
		}
		else if (locx < x && locx + 10 > x && locy > y && locy < y + 30) {
			return true;
		}
		else if (locx > x && locx < x + 80 && locy < y && locy + 10 > y) {
			return true;
		}
		else {
			return false;
		}
	
	}
}
