/**
 * 
 */
package supply;

/**
 * @author guitt
 *
 */
public class Triplet<A,B,C> extends Couple<A,B>{
		// ATTRIBUTS
	private C third;
	
		// CONSTRUCUTEURS
	public Triplet(A f, B s, C t)
	{
		super(f,s);
		third = t;
	}
	
		// METHODES
	/**
	 * Fonction retournant le troisième élément du couple.
	 * @return first : du type déclaré par C, représente le troisième item du couple.
	 */
	public C getThird()
	{
		return third;
	}
}
