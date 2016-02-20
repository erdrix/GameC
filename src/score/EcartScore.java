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
public abstract class EcartScore extends Score<Integer>{
		// ATTRIBUTS
	protected ArrayList<String> elements;	/** Tableau contenant l'ensemble des choix possibles pour les critères implémentant ce score.*/
	protected String val;						/** choix pour une offre précise.*/
	protected double transition[];			/** Tableau contenant le coup des transitions entre deux "états" consécutifs (entre "Débutant" et "intermédiaire" par exemple).*/
	protected double firstTransition;
		// CONSTRUCTEUR
	public EcartScore(String v, double firstTransit, ArrayList<String> item)
	{
		super();
		elements = item;
		val = v;
		scoreMax = 100;
		firstTransition = firstTransit;
	}
		// METHODES
	public int getScore(DemandMethods myDemand) {
		int field = extractD(myDemand);
		//if(field == 0) return score = 0;
		score = scoreMax;
		
		// Construction du tableau de transition
		int nbTransitions = elements.size()-1;
		transition = new double[nbTransitions];
		
		transition[0]= firstTransition;
		double rest = 1.0-firstTransition;

		for(int i=1; i < nbTransitions-1; i++)
		{
			transition[i] = rest-rest/nbTransitions;
			rest = rest/nbTransitions;
		}
		transition[nbTransitions-1] = rest;
		
		// Si la demande ne correspond pas l'offre.
		if(!val.equals(elements.get(field)))
		{
			int first = 0;
			
			// Si on decend dans le tableau (offre< demande).
			if(elements.indexOf(val) < field)
				first = elements.size()-1;
				
			// Calcul du score
			for(int j=Math.abs(field-first) ; j <Math.abs(elements.indexOf(val)-first); j++)
				score -= (int)(scoreMax*transition[j]);
		}
		return score;
	}
	
	public String toString(){return val+"("+score+")";}
}
