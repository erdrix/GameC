package demand;

import java.util.ArrayList;

public class DStoryType {
		// ATTRIBUT
	protected int type[];	// Num�ro du choix du style d'histoire.
	
		// CONSTRUCTEUR
	public DStoryType(ArrayList<Integer> t)
	{
		int size = 0;
		if(t!=null)
			size = t.size();
		type = new int[size];
		for(int i=0; i<size; i++)
			type[i] = t.get(i);  
	}
	
		// METHODE
	/**
	 * Fonction retournant le choix du type d'histoire
	 * @return type : int[] repr�sentant l'ensemble des types d'histoire choisit.
	 */
	public int[] getType()
	{
		return type;
	}
}
