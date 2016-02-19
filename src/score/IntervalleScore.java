/**
 * 
 */
package score;

import supply.DemandMethods;
import supply.Intervalle;

/**
 * @author guitt
 *
 */
public abstract class IntervalleScore extends Score<Intervalle> {
		// ATTRIBUTS
	protected float val;		// Contient la valeur encapsulée par un objet IntervalleScore.
	protected boolean desc;		// Définit l'état dans lequel on est entre : une valeur inférieur est moins grave qu'une valeure supérieur ou inverse.
	protected float ratioNeg;	// Ratio appliqué si on va vers des valeurs peu intéressante.
	protected float ratioPos;	// Ratio applique si on va vers des valeurs dont c'est moins grave.
		// CONSTRUCTEUR
	public IntervalleScore(float item)
	{
		super();
		val      = item;
		scoreMax = 100;
		ratioNeg = (float) 0.5;
		ratioPos   = 1;
	}
	
		// METHODES 
	/**
	 * Fonction de calcul du score pour les critères par intervalle.
	 * @return scoreMax : dans le cas où la valeur de l'offre est comprise dans l'intervalle souhaité. 
	 * @return scoreMax - 0.5*diff : dans le cas ou l'intervalle dépassé (sup à la borne sup ou ing à la borne inf) est mois grave le score décrément 2 fois moins vite (>=0).
	 * @return scoreMax - diff : dans le cas ou l'intervalle dépassé (sup à la borne sup ou ing à la borne inf)est plus grave le socre décrément 2 fois moins vite (>=0).
	 */
	public int getScore(DemandMethods myDemand)
	{
		Intervalle field = extractD(myDemand);
		if(field==null) return score = 0;
		// Si la valeur est dans l'intervalle demandé.
		if(val >= field.getFirst() && val<=field.getSecond())
			return score = scoreMax;
		else
		{
			// Si une valeur inférieure à la borne inférieur est moins grave.
			if(desc)
				return score = (val< field.getFirst())? (int) Math.max((ratioPos*scoreMax*(val/field.getFirst())),0):(int)Math.max(ratioNeg*scoreMax*(field.getSecond()/val),0);
				// Si une valeur supérieur à la borne suppérieur est monis grave.
			else
				return score = (val< field.getFirst())? (int) Math.max((ratioNeg*scoreMax*(val/field.getFirst())),0):(int)Math.max(ratioPos*scoreMax*(field.getSecond()/val),0);				
		}
	}
	
	public String toString(){
		return val+"("+score+")";
	}
}
