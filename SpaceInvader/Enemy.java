package SpaceInvader;

public class Enemy {
	
	private int locx, locy;
	int step = 0;
	int counter = 420;
	int move = 0;
	
	public Enemy(int x, int y, int health) {
		locx = x;
		locy = y;
	}
	
	public int getLocX() {
		return locx;
	}

	public int getLocY() {
		return locy;
	}
	public void move()  {
		if (move == 0) {
			locx += 1;
		} else if (move == 50){
			locy += 1;
		} else if (move == 100) {
			locx -= 1;
		}else if (move == 150) {
			locy += 1;
		}
		
		counter -= 1;
		
		if (counter < 0) {
			counter = 420;
			move += 50;
			if (move > 150) {
				move = 0;
			}
		}
			
	}
}
