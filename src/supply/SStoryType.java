package supply;

import java.util.ArrayList;
import score.MultipleScore;

public class SStoryType extends MultipleScore{
	
		//ATTRIBUTS
	static private ArrayList<String> typeS;
	
		// CONSTRUCTEUR
	public SStoryType(ArrayList<String> type){super(); elements = type;}
	
		// METHODES
	public static void Init(ArrayList<String> stories){typeS = stories;}
	public static ArrayList<String> getOptions(){return typeS;}
	public ArrayList<String> getType(){return typeS;}

	@Override
	public int[] extractD(DemandMethods myDemand) {
		return myDemand.getStoryType();
	}
	
	public ArrayList<String> getStoryType(){return elements;}
	public void setStoryType(ArrayList<String> value){elements= value;}
}
