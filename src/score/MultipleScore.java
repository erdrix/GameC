/**
 * 
 */
package score;

import java.util.ArrayList;

import supply.DemandMethods;

/**
 * @author guitt
 *
 */
public abstract class MultipleScore extends Score<int[]>{
	protected ArrayList<String> elements;
	public abstract ArrayList<String> getType();
	public MultipleScore()
	{
		super();
		scoreMax = 100;
	}
	public int getScore(DemandMethods myDemand) {

		int[] field = extractD(myDemand);
		if(field.length == 0) return score = 0;
		ArrayList<String> typeS = getType();
		int cpt = 0;
		boolean find;
		
		if(field == null ||elements == null) return 0;
		
		for(int i : field)
		{
			find = false;
			for(String s : elements)
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
}
