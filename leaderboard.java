import java.util.ArrayList;
import java.util.Collections;

public class leaderboard {

	public static ArrayList<Double> highScores = new ArrayList<Double>();
	
	public static void addScores(double s)
	{
		if(highScores.size() < 3)
			highScores.add(s);
		else
		{
			for(int i = 0; i < highScores.size(); i++)
			{
				if(s < highScores.get(i))
				{
					highScores.remove(i);
					highScores.add(s);
					break;
				}
			}
		}
	}
	public static void print()
	{
		Collections.sort(highScores);
		System.out.println("---------------");
		System.out.println("| Leaderboard |");
		System.out.println("---------------");
		for(int i = 0; i < highScores.size(); i++)
		{
			System.out.println(i+1 + ") " + highScores.get(i) + " sec");
		}
	}
}
