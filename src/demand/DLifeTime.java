package demand;

public class DLifeTime {
		// ATTRIBUT
	protected int time;
	
		// CONSTRUCTEUR
	public DLifeTime(int t)
	{
		time= t;
	}
	
		// METHODE
	/*
	 * Fonction retournant le temps moyen de durée du jeu.
	 */
	public int getTime()
	{
		return time;
	}
}
