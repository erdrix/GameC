package demand;

public class DGameType {
		// ATTRIBUTS
	private int type;	// Numéro contenant le Mode de jeu.
	
		// CONSTRUCTUEUR
	public DGameType(int item)
	{
		type = item;
	}
	
		// METHODE
	/**
	 * Fonction retournant le numéro du type de jeu dont il s'agit (En ligne | Hors ligne).
	 * @return type : entier représentant le choix du type de jeu.
	 */
	public int getType()
	{
		return type;
	}
}
