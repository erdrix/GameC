package supply;

import java.util.ArrayList;
import java.util.TreeMap;
import score.StyleScore;

public class SGameStyle extends StyleScore{
	private static TreeMap<String, String> options = new TreeMap<>();
	public SGameStyle(String s1) { super(s1); scoreMax = 170;}
	
	public String extractD(DemandMethods myDemand) { return myDemand.getGameStyle();} 
	public String getGameStyle(){return s_style;}
	public void setGameStyle(String value){s_style = value;}
	
	@SafeVarargs
	public static void Init(Couple<String, String> ...items)
	{
		for(Couple<String, String> c : items)
			options.put(c.getFirst(), c.getSecond());
	}
	public static void Init(ArrayList<Couple<String, String>> items)
	{
		for(Couple<String, String> c : items)
			options.put(c.getFirst(), c.getSecond());
	}
	public TreeMap<String, String> getListe(){return options;}
	public static TreeMap<String, String> getOptions(){return options;}
	
}