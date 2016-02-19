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
public class SAccessory extends SEquipement {
		// ATTRIBUTS
	static protected ArrayList<String> typeE;
	static protected TreeMap<String, ArrayList<TreeMap<String, String>>> assoc;
	
		// CONSTRUCTEUR
	public SAccessory(ArrayList<TreeMap<String, String>>items) {super(items); scoreMax = 70;}
	
		// METHODES
	static public void Init(ArrayList<TreeMap<String, String>> items)
	{
		typeE = new ArrayList<String>();
		ArrayList<TreeMap<String, String>> init = new ArrayList<>();
		assoc = new TreeMap<String, ArrayList<TreeMap<String, String>>>();
		
		// Cr�ation du TreeMap contenant en cl� les noms des type d'�quipements et en valeur un ArrayList de couple repr�sentant le Constructeur et le nom.
		if(items == null)
			assoc = null;
		
		for(TreeMap<String, String> item : items)
		{
			init = new ArrayList<>();
			// si il y a une cl� "type".
			if(item.containsKey("type"))
			{
				String type = item.get("type");
				item.remove("type");
				// Si on rencontre pour la premi�re fois ce type d'�quipement.
				if(!assoc.containsKey(type))
				{
					typeE.add(type);
					init.add(item);	
					assoc.put(type,init);	// On initialise la nouvelle entr�e avec un premier couple (constructeur, nom).
				}
				else // Sinon 
					assoc.get(type).add(item);	// On ajoute un couple (constructeur, nom).
			}
		}
	}

	
	public ArrayList<String> getTypeE(){return typeE;}
	public static ArrayList<String> getTypeAccessories(){return typeE;}
	public static TreeMap<String, ArrayList<TreeMap<String, String>>> getOptions(){return assoc;}

	public ArrayList<TreeMap<String, String>> extractD(DemandMethods myDemand) {
		return myDemand.getAccessoryEquipements();
	}
	
	public TreeMap<String, ArrayList<TreeMap<String, String>>> getAccessories(){return equipements;}
}
