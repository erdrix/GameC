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
public class SGameType extends BinaryScore {
	// CONSTRUCTEURS
	static ArrayList<String> options = new ArrayList<>();
	public SGameType(String m){super(m, options);}

	public Integer extractD(DemandMethods myDemand) {return myDemand.getDGameType();}

	@Override
	public int getScoreSpe(DemandMethods myDemand) {return 0;}
	
	public String getGameType(){return val;}
	public void setGameType(String value){val = value;}
	
	static public void Init(String ...items)
	{
		for(String s : items)
			options.add(s);
	}
	public static ArrayList<String> getOptions(){return options;}
}
