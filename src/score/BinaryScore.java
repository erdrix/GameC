package score;

import java.util.ArrayList;

import supply.DemandMethods;

public abstract class BinaryScore extends Score<Integer>{
		// ATTRIBUTS
	ArrayList<String> elements;	// Contients les deux choix possibles pour un crit�re.
	protected String val;					// Valeur encapsul�e par l'offre.
	
		// CONSTRUCTEURS
	public BinaryScore(String value, ArrayList<String> item)
	{
		super();
		elements = item;
		val      = value;
		scoreMax  = 50;
	}
	
		// METHODES
	/**
	 * D�finition de la m�thode h�rit� de Score.
	 * @return score : int correspondant au score de ce champ.
	 */
	public int getScore(DemandMethods myDemand) {
		Integer field = extractD(myDemand);
		
		//V�rifie si le crit�re de l'offre correspond � la demande.
		return score = (val.equals(elements.get(field)))? scoreMax+getScoreSpe(myDemand) : 0+getScoreSpe(myDemand);	
	}
	
	public String toString(){
		return val+"("+score+")";
	}
	
	public abstract int getScoreSpe(DemandMethods myDemand);
}
