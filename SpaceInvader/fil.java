package SpaceInvader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class fil implements filhåndtering{
	
	ArrayList<String> highscore = new ArrayList<String>();
	
	@Override
	public void SkrivTilFil(int score) {
		PrintWriter writer;
		String file = new File("").getAbsolutePath();
		try {
			FileWriter fileWriter = new FileWriter(file + "/src/SpaceInvader/HighScore.txt", true);
			writer = new PrintWriter(fileWriter);
			writer.println(score);
			writer.flush();
			writer.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public  ArrayList<String> LeseFraFil() {
		String file = new File("").getAbsolutePath() + "/src/SpaceInvader/HighScore.txt";
		Scanner scanner;
		try {
			scanner = new Scanner(new File(file));
			while(scanner.hasNextLine()) {
				String s = scanner.nextLine();
				highscore.add(s);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();	
		}
		HighScoreComparator comparator = new HighScoreComparator();
		Collections.sort(highscore, comparator);		
		return highscore;
	}
}
