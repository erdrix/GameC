package demand;

public class DLifeTime {
		// ATTRIBUT
	protected int time;
	
		// CONSTRUCTEUR
	public DLifeTime(Integer t)
	{
		time= t;
	}
	
		// METHODE
	/*
	 * Fonction retournant le temps moyen de dur�e du jeu.
	 */
	public int getTime()
	{
		return time;
	}
}
