/**
 * 
 */
package supply;

import java.util.ArrayList;

import score.EcartScore;

/**
 * @author guitt
 *
 */
public class SDifficulty extends EcartScore{
		// CONSTRUCTEUR
	private static ArrayList<String> options = new ArrayList<String>();
	
	public SDifficulty(String c) {super(c,0.3, options);}
	
		// METHODE
	/**
	 * Methode permettant d'extraire la valeur du critère correspondant dans la demande.
	 * @return myDemand.getDifficulty() : int correspondant à la difficulté demandé par le client.
	 */
	public Integer extractD(DemandMethods myDemand){ return myDemand.getDifficulty(); }
	
	public String getDifficulty(){return val;}
	public void setDifficulty(String value){val = value;}
	
	public static ArrayList<String>getOptions(){return options;}
	static public void Init(String ...items)
	{
		for(String s : items)
			options.add(s);
	}
}
