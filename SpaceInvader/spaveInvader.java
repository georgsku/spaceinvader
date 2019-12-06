package SpaceInvader;

import javax.swing.Timer;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import javafx.scene.control.Button;


public class spaveInvader extends JPanel implements ActionListener, KeyListener {
	
	Player p;
	Pane root;
	Timer t = new Timer(5, this);
	fil fil = new fil();
	ArrayList<Skudd> skudd = new ArrayList<Skudd>();
	ArrayList<Enemy> Enemies = new ArrayList<Enemy>();
	ArrayList<PowerUp> powerup = new ArrayList<PowerUp>();
	ArrayList<String> highscore = new ArrayList<String>();
	private boolean left, right, space, bomb;
	private boolean engang = true;
	private int forgjeskudd = 100;
	public int score = 0;
	int Aliens = 108;
	Image image;
	Image background;
	Image aliens;
	Image missile;
	
	public spaveInvader() {
		p = new Player(285, 740);
		t.start();
		addKeyListener(this);
		setFocusable(true);; 
		setFocusTraversalKeysEnabled(false);
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 1; j++) {
				Enemies.add(new Enemy(13 + i * 50, 25 + j * 45, 1));
				
			}
		}
	}
	
	
	public void lagPowerUp() {
		Random rand = new Random();
		int value = rand.nextInt(590);
		powerup.add(new PowerUp(value, 0));
	}
	
	public void lagbombe() {
		
	}
	
	public void lagSkudd() {
		Skudd b = new Skudd(p.getLocX() + 28, p.getLocY() - 60, true);
		skudd.add(b);
	}
	public void lagSkudd2() {
		//Skudd b = new Skudd(p.getLocX() + 50, p.getLocY() - 10, true);
		//skudd.add(b);
	}
	public boolean Level1() {
		if (Aliens == 96) {
			return true;
		}
			return false;
	}
	public boolean Level2() {
		if (Aliens == 60) {
			return true;
		}
			return false;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		String loose = "GAME OVER";
		String cleared = "LEVEL CLEARED";
		String win = "YOU WIN";
		Graphics2D g2 = (Graphics2D) g;	
		ImageIcon ii = new ImageIcon("src/bilder/background.jpeg");
		background = ii.getImage();
		g.drawImage(background, 0,0, null);		
		ImageIcon i = new ImageIcon("src/bilder/romskip.png");
		image = i.getImage();
		g.drawImage(image, p.getLocX(), p.getLocY() - 60, null);
		for (Skudd b : skudd) {
			if (! b.player) {
				g2.setColor(Color.RED);
				g2.fill(new Ellipse2D.Double(b.getLocx(), b.getLocy(), 5, 5));
			} else {
				ImageIcon m = new ImageIcon("src/bilder/Missile.png");
				missile = m.getImage();
				g.drawImage(missile, b.getLocx(), b.getLocy(), null);
			}
		}
		for (Enemy e : Enemies) {
			ImageIcon iii = new ImageIcon("src/bilder/aliens.png");
			aliens = iii.getImage();
			g.drawImage(aliens, e.getLocX(), e.getLocY(), null);
			
			//g2.setColor(Color.PINK);
			//g2.fill(new Ellipse2D.Double(e.getLocX(), e.getLocY(), 15, 15));
		}
		for (PowerUp pu : powerup) {
			g2.setColor(Color.YELLOW);
			g2.fill(new Rectangle2D.Double(pu.getLocx(),pu.getLocy(), 10, 10));
		}		
		g2.setColor(Color.BLACK);
		g2.setFont(new Font("Helvetica", Font.BOLD, 20));
		g2.drawString("Score: " + score, 0, 20);
		g2.setColor(Color.RED);
		g2.setFont(new Font("Helvetica", Font.BOLD, 30));
		if (Player.isDead()) {
			g2.drawString(loose, 215, 350);
			g2.setColor(Color.RED);
			g2.setFont(new Font("Helvetica", Font.BOLD, 15));
			g2.drawString("Score: " + score, 275, 390);
			g2.setColor(Color.BLACK);
			g2.drawString("HighScore:", 215, 420);
			try {
			for (int j = 0; j < 5; j++) {
				g2.drawString(highscore.get(j), 215, 435 + 15*j);
				}
			} catch (Exception e) {
				for (int j = 0; j < highscore.size(); j++) {
					g2.drawString(highscore.get(j), 50, 215 + 15*j);
				}
			}
			 	
		}
		if(Aliens == 96 || Aliens == 60) {
			g2.setColor(Color.GREEN);
			g2.setFont(new Font("Helvetica", Font.BOLD, 30));
			g2.drawString(cleared, 190, 350);
			g2.setColor(Color.GREEN);
			g2.setFont(new Font("Helvetica", Font.BOLD, 15));
			g2.drawString("Score: " + score, 275, 390);	
		}
		if (Aliens == 0) {
			g2.setColor(Color.GREEN);
			g2.setFont(new Font("Helvetica", Font.BOLD, 30));
			g2.drawString(win, 240, 350);
			g2.setColor(Color.GREEN);
			g2.setFont(new Font("Helvetica", Font.BOLD, 15));
			g2.drawString("Score: " + score, 275, 390);	
		}

	}
	
	public void dead() {
		if (Player.isDead()) {
			Player.locx = 285;
			skudd.clear();
		}
	}
	
	public void skrivTilHighScore() {
		if (Player.isDead() && engang) {
			fil.SkrivTilFil(score);
			highscore = fil.LeseFraFil();
			engang = false;
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if (left == true) {
			p.Left();
		}
		if (right == true) {
			p.Right();
		}
		if (space == true && forgjeskudd < 0) {
			lagSkudd();
			lagSkudd2();
			forgjeskudd = 100;
		}
		if (bomb == true) {
			lagbombe();
		}
		for (Skudd s : skudd) {
			if (s.checkKollisjon(p) && s.player == false) {
				Player.dead = true;
			}
		
		}
		
		
		dead();
		skrivTilHighScore();
		
		if (Level1() && Enemies.size() == 0) {
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 3; j++) {
					Enemies.add(new Enemy(12 + i * 48, 25 + j * 45, 1));
				}
			}
			skudd.clear();
			Player.locx = 285; 
		}
		if (Level2() && Enemies.size() == 0) {
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 5; j++) {
					Enemies.add(new Enemy(12 + i * 48, 25 + j * 45, 1));
				}
			}
			skudd.clear();
			Player.locx = 285; 
		}
		
		int skuddTeller = skudd.size();
		int enemiesTeller = Enemies.size();

		ArrayList<Integer> fjernenemy = new ArrayList<Integer>();
		ArrayList<Integer> fjernskudd = new ArrayList<Integer>();
		ArrayList<PowerUp> fjernpowerup = new ArrayList<PowerUp>();
		
		forgjeskudd -= 2;
		
		for (int i = 0; i < skuddTeller; i++) {
			Skudd s = skudd.get(i);
			s.moveSkudd();
		
			for (int j = 0; j < enemiesTeller; j++) {
				Enemy n = Enemies.get(j);
				if (s.checkKollisjon(n) && s.player == true) {
					score += 50;
					fjernenemy.add(j);
					fjernskudd.add(i);
				}
			}
		}
		
		for (PowerUp pu : powerup) {
			pu.moveDown();
			if (pu.checkKollisjon(p)) {
				fjernpowerup.add(pu);
			}
		}
		
		if (Math.random() < 0.0001) {
			lagPowerUp();
		}
		for (Enemy i : Enemies) {
			//i.move();
			if (Math.random() < 0.001) {
				skudd.add(new Skudd(i.getLocX() + 3, i.getLocY(), false));
			}
		}
		
		for (PowerUp i : fjernpowerup) {
				powerup.remove(i);
			
		}
		
		for (int i : fjernenemy) {
			if (i < Enemies.size()) {
				Enemies.remove(i);
				Aliens -= 1;
			}
		}
		for (int i : fjernskudd) {
			if (i < skudd.size()) {
				skudd.remove(i);
			}
		}
		
		repaint();
	}

	
	public void keyPressed(KeyEvent e) {
		int s = e.getKeyCode();
		
		if (s == KeyEvent.VK_A) {
			left = true;
		}
		if (s == KeyEvent.VK_D) {
			right = true;
		}
		if (s == KeyEvent.VK_SPACE) {
			space = true;
		}
		if (s == KeyEvent.VK_W) {
			bomb = true;
		}
	}
	public void keyReleased(KeyEvent e) {
		int s = e.getKeyCode();
		
		if (s == KeyEvent.VK_A) {
			left = false;
		}
		if (s == KeyEvent.VK_D) {
			right = false;
		}
		if (s == KeyEvent.VK_SPACE) {
			space = false;
		}
		if (s == KeyEvent.VK_W) {
			bomb = false;
		}
	}
	
	public void keyTyped(KeyEvent e) {
		int s = e.getKeyCode();
		if (s == KeyEvent.VK_SPACE) {
			lagSkudd();
		}
	}
	
}
