/**
 * 
 */
package supply;
import java.util.ArrayList;

import score.BinaryScore;

/**
 * @author guitt
 *
 */
public class SBuyMethod extends BinaryScore{
		//	ATTRIBUTS
	protected SPrice price;
	protected static ArrayList<String> options = new ArrayList<>();
	
		//CONSTRUCTEURS
	/**
	 * Constructeur par défaut.
	 * @param prix : prix du jeu.
	 * @param c    : forme de paiement pour ce jeu.c
	 */
	public SBuyMethod(String c){super(c, options);}
	public SBuyMethod(SPrice prix, String c){ super(c, options); price = prix; scoreMax = 50;}

		// METHODES
	/**
	 * Methode permettant d'extraire la valeur du critère correspondant dans la demande.
	 * @return myDemand.getDBuyMethod() : int correspondant au choix du client pour la forme de paiement.
	 */
	public Integer extractD(DemandMethods myDemand){ return myDemand.getDBuyMethod();}
	
	/**
	 * Methode permettant d'appeler la methode getScore() de l'objet SPrice encapsulé par cette classe.
	 * @return price.getScore(myDemand) : int représentant le score du prix de l'offre par rapport à la demande.
	 */
	public int getScoreSpe(DemandMethods myDemand) {return price.getScore(myDemand);}
	
	/**
	 * Méthode donnant accès à l'objet SPrice encapsulé.
	 * @return price : SPrice étant le prix de l'offre.
	 */
	public SPrice getPrice(){ return price;}
	public void setPrice(SPrice p){ price = p;}
	
	public String getBuyMethod(){return val;}
	public void setBuyMethod(String value){val = value;}
	
	public static void Init(String ...items){
		for(String s : items)
			options.add(s);
	}
	
	public static ArrayList<String> getOptions(){return options;}
}
