/**
 * 
 */
package supply;

/**
 * @author guitt
 *
 */
public class Couple<A, B> {
		// ATTRIBUTS
	protected A first;
	protected B second;
		
		// CONSTRUCUTEURS
	public Couple(A f, B s)
	{
		first = f;
		second = s;
	}
		// METHODES
	/**
	 * Fonction retournant le premier élément du couple.
	 * @return first : du type déclaré par A, représente le premier item du couple.
	 */
	public A getFirst()
	{
		return first;
	}
		
	/**
	 * Fonction retournant le second élément du couple.
     * @return first : du type déclaré par B, représente le second item du couple.
	 */
	public B getSecond()
	{
		return second;
	}
}
