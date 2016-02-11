package supply;

import java.util.ArrayList;
import score.MultipleScore;

public class SStoryType extends MultipleScore<int[]>{
	
		//ATTRIBUTS
	protected String[] storyType;
	static private ArrayList<String> typeS;
	
		// CONSTRUCTEUR
	public SStoryType(String ...type){super(); storyType = (type.length == 0)? null : type;}
	
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
					find = true; // On se protège contre la présence de doublon dans l'offre.
				}
			}
		}
		return score = (100*cpt)/field.length;
	}

	@Override
	public int[] extractD(DemandMethods myDemand) {
		return myDemand.getStoryType();
	}
	
	public String[] getStoryType(){return storyType;}
	public void setStoryType(String[] value){storyType = value;}
}
