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
	 * Constructeur par d�faut.
	 * @param prix : prix du jeu.
	 * @param c    : forme de paiement pour ce jeu.c
	 */
	public SBuyMethod(String c){super(c, options);}
	public SBuyMethod(SPrice prix, String c){ super(c, options); price = prix;}

		// METHODES
	/**
	 * Methode permettant d'extraire la valeur du crit�re correspondant dans la demande.
	 * @return myDemand.getDBuyMethod() : int correspondant au choix du client pour la forme de paiement.
	 */
	public Integer extractD(DemandMethods myDemand){ return myDemand.getDBuyMethod();}
	
	/**
	 * Methode permettant d'appeler la methode getScore() de l'objet SPrice encapsul� par cette classe.
	 * @return price.getScore(myDemand) : int repr�sentant le score du prix de l'offre par rapport � la demande.
	 */
	public int getScoreSpe(DemandMethods myDemand) {return price.getScore(myDemand);}
	
	/**
	 * M�thode donnant acc�s � l'objet SPrice encapsul�.
	 * @return price : SPrice �tant le prix de l'offre.
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
