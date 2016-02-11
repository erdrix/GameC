package supply;

import score.IntervalleScore;

public class SMark extends IntervalleScore{
		// CONSTRUCTEUR
	public SMark(float m){super(m); desc = false;}
	
		// METHODE
	public Intervalle extractD(DemandMethods myDemand){return myDemand.getMark();}
	
	public float getMark(){return val;}
	public void setMark(float value){val = value;}
	public static int[] getLimits(){
		int limits[] = {0,20};
		return limits;
		}
}
