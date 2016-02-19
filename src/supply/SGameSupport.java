/**
 * 
 */
package supply;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * @author guitt
 *
 */
public class SGameSupport extends SEquipement{
		// ATTRIBUTS
	static protected ArrayList<String> typeE;
	static protected TreeMap<String, ArrayList<TreeMap<String, String>>> assoc;
	
		// CONSTRUCTEUR
	public SGameSupport(ArrayList<TreeMap<String, String>> items) {super(items); scoreMax = 100;}
	
		// METHODES
	static public void Init(ArrayList<TreeMap<String, String>> items)
	{
		typeE = new ArrayList<String>();
		ArrayList<TreeMap<String, String>> init = new ArrayList<>();
		assoc = new TreeMap<String, ArrayList<TreeMap<String, String>>>();
		
		// Création du TreeMap contenant en clé les noms des type d'équipements et en valeur un ArrayList de couple représentant le Constructeur et le nom.
		if(items == null)
			assoc = null;
		
		for(TreeMap<String, String> item : items)
		{
			init = new ArrayList<>();
			// si il y a une clé "type".
			if(item.containsKey("type"))
			{
				String type = item.get("type");
				item.remove("type");
				// Si on rencontre pour la première fois ce type d'équipement.
				if(!assoc.containsKey(type))
				{
					typeE.add(type);
					init.add(item);	
					assoc.put(type,init);	// On initialise la nouvelle entrée avec un premier couple (constructeur, nom).
				}
				else // Sinon 
					assoc.get(type).add(item);	// On ajoute un couple (constructeur, nom).
			}
		}
	}

	@Override
	public ArrayList<String> getTypeE(){return typeE;}
	public static ArrayList<String> getTypeSupports(){return typeE;}
	public static TreeMap<String, ArrayList<TreeMap<String, String>>> getOptions(){return assoc;}
	
	public ArrayList<TreeMap<String, String>> extractD(DemandMethods myDemand) {
		return myDemand.getGameSupportEquipements();
	}
	
	public TreeMap<String, ArrayList<TreeMap<String, String>>> getSupports(){return equipements;}
}
