
package demand;

/**
 * @author guitt
 *
 */
public abstract class DSale {
	// CLASSE A REVOIR PROBLEME LIE AU SCORE MULTIPLE.
		// ATTRIBUT
	String address;	
	
		// CONSTRUCTEUR
	public DSale( String a)
	{
		address = a;		
	}
	
		// METHODE
	/**
	 * Fonction retournant l'adresse du lieu de vente (par internet ou physique)
	 * @return address : String représentant l'adresse du lieu de vente.
	 */
	public String getAddress()
	{
		return address;
	}
}
