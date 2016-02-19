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
public class SLifeTime extends EcartScore{
	private static ArrayList<String> options = new ArrayList<String>();
		// CONSTRUCTEUR
	public SLifeTime(String c){super(c,0.3,options); scoreMax = 80;}
	
		// METHODE
	/**
	 * Methode permettant d'extraire la valeur du critère correspondant dans la demande.
	 * @return myDemand.getDifficulty() : int correspondant à la difficulté demandé par le client.
	 */
	public Integer extractD(DemandMethods myDemand){return myDemand.getDLifeTime();}
	
	public String getLifeTime(){return val;}
	public void setLifeTime(String value){val = value;}
	
	static public void Init(String ...items)
	{
		for(String s : items)
			options.add(s);
	}
	static public ArrayList<String> getOptions(){return options;}

}
