/**
 * 
 */
package score;

import supply.DemandMethods;

/**
 * @author guitt
 *
 */
public abstract class MultipleScore<A> extends Score<A>{
	public MultipleScore()
	{
		super();
		scoreMax = 100;
	}
	public abstract int getScore(DemandMethods myDemand);
}
