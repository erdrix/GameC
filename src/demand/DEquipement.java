/**
 * 
 */
package demand;
import java.util.ArrayList;
import java.util.TreeMap;


/**
 * @author guitt
 *
 */
public abstract class DEquipement {
		// ATTRIBUTS
	protected ArrayList<TreeMap<String, String>> equipements;	// Contient l'ensemble des équipements souhaités (constructeur, nom, type).
		
		// CONSTRUCTEUR 
	public DEquipement (ArrayList<TreeMap<String, String>> items)
	{
		if(items == null)
			equipements = null;
		else
			equipements = items;
	}
		
		// METHODES 
	/**
	 * Fonction getName retourne le nom de l'accessoire.
	 * @return string : nom de l'accessoire.
	 */
	public ArrayList<TreeMap<String, String>> getEquipements()
	{
		return equipements;
	}
}
