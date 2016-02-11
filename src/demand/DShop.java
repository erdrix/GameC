/**
 * 
 */
package demand;

/**
 * @author guitt
 *
 */
public class DShop extends DSale{
		// ATTRIBUTS
	protected String city;
	protected int zipCode;
			
		// CONSTRUCTEUR
	public DShop(String c, String a, int z)
	{
		super(a);
		city = c;
		zipCode = z;
	}
		
		// METHODES
	/**
	 * Fonction retournant le nom de la ville du lieu de vente.
	 * @returncity : String représetant le nom de la ville du lieu de vente.
	 */
	public String getCity()
	{
		return city;
	}
		
	/**
	 * Fonction retournant le code postale du lieu de vente.
	 * @return zipCode : int représenant le code postale du lieu de vente.
	 */
	public int getZipCode()
	{
		return zipCode;
	}
}
