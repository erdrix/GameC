package supply;

import java.util.ArrayList;
import score.MultipleScore;

public class SStoryType extends MultipleScore<int[]>{
	
		//ATTRIBUTS
	protected ArrayList<String> storyType;
	static private ArrayList<String> typeS;
	
		// CONSTRUCTEUR
	public SStoryType(ArrayList<String> type){super(); storyType = type;}
	
		// METHODES
	public static void Init(ArrayList<String> stories){typeS = stories;}
	public static ArrayList<String> getOptions(){return typeS;}
	
	@Override
	public int getScore(DemandMethods myDemand) {

		int[] field = extractD(myDemand);
		
		int cpt = 0;
		boolean find;
		
		if(field == null ||storyType == null) return 0;
		
		for(int i : field)
		{
			find = false;
			for(String s : storyType)
			{
				if(	s.equals(typeS.get(i)) && !find)
				{
					cpt++;
					find = true; // On se prot�ge contre la pr�sence de doublon dans l'offre.
				}
			}
		}
		return score = (100*cpt)/field.length;
	}

	@Override
	public int[] extractD(DemandMethods myDemand) {
		return myDemand.getStoryType();
	}
	
	public ArrayList<String> getStoryType(){return storyType;}
	public void setStoryType(ArrayList<String> value){storyType = value;}
}
