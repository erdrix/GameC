package supply;

import score.IntervalleScore;

public class SPrice extends IntervalleScore{
		// CONSTRUCTEUR
	public SPrice(float item){super(item); desc = true; scoreMax = 100;}
		
		// METHODES
	public Intervalle extractD(DemandMethods myDemand){return myDemand.getPrice();}
	
	public float getPrice(){return val;}
	public void setPrice(float value){val = value;}
	public static int[] getLimits(){
		int limits[] = {0,100};
		return limits;
		}
}
