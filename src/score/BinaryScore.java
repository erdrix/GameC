package score;

import java.util.ArrayList;

import supply.DemandMethods;

public abstract class BinaryScore extends Score<Integer>{
		// ATTRIBUTS
	ArrayList<String> elements;	// Contients les deux choix possibles pour un critère.
	protected String val;					// Valeur encapsulée par l'offre.
	
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
	 * Définition de la méthode hérité de Score.
	 * @return score : int correspondant au score de ce champ.
	 */
	public int getScore(DemandMethods myDemand) {
		Integer field = extractD(myDemand);
		
		//Vérifie si le critère de l'offre correspond à la demande.
		return score = (val.equals(elements.get(field)))? scoreMax+getScoreSpe(myDemand) : 0+getScoreSpe(myDemand);	
	}
	
	public String toString(){
		return val+"("+score+")";
	}
	
	public abstract int getScoreSpe(DemandMethods myDemand);
}
