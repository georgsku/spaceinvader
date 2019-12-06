package SpaceInvader;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Launcher extends Application implements ActionListener {
	
	static Pane root;
	private JButton btn;
	
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		StartGame();
	}
	public void StartGame() {
		JFrame f = new JFrame();
		spaveInvader d = new spaveInvader();
		
		f.setSize(600, 800);
		f.setTitle("Georgs Space invader");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		f.add(d);
		f.setVisible(true);
	}
	
	public void GameMenu() {
		JFrame f = new JFrame();
		f.setSize(600,800);
		f.setTitle("Georgs Space invader");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(new JLabel(new ImageIcon("src/bilder/background.jpeg")));
		
		btn = new JButton("Start Game");
		btn.setBounds(250, 250, 100, 100);
		btn.setBackground(Color.BLACK);
		btn.addActionListener(this);
		f.add(btn);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn) {
			StartGame();
		}
		
	}
}
