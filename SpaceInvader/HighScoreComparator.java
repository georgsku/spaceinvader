package SpaceInvader;

import java.util.Comparator;

public class HighScoreComparator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		return Integer.parseInt(o2) - Integer.parseInt(o1);
	}

}
