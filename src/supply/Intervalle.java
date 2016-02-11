/**
 * 
 */
package supply;

/**
 * @author guitt
 *
 */
public class Intervalle {
		// ATTRIBUTS
	protected float first;
	protected float second;
		
		// CONSTRUCTEUR
	public Intervalle(float f, float s)
	{
		first = Math.min(f, s);
		second = Math.max(f, s);
	}
	
		// METHODES
	/**
	 * Fonction retournant la borne inférieur de l'intervalle
	 * @return first : float représentant la borne inférieur de l'intervalle
	 */
	public float getFirst(){return first;}
	
	/**
	 * Fonction retournant la borne supérieur de l'intervalle
	 * @return second : float représentant la borne supérieur de l'intervalle
	 */
	public float getSecond(){return second;}
}
