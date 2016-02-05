package supply;

import score.IntervalleScore;

public class SPrice extends IntervalleScore{
		// CONSTRUCTEUR
	public SPrice(float item){super(item); desc = true;}
		
		// METHODES
	public Intervalle extractD(DemandMethods myDemand){return myDemand.getPrice();}
	
	public float getPrice(){return val;}
	public void setPrice(float value){val = value;}
}
