package demand;

public class DDifficulty {
		// ATTRIBUTS
	protected int difficulty;	// Numéro de la difficulté.
	
		// CONSTRUCTEUR
	public DDifficulty(int d)
	{
		difficulty = d;
	}
	
		// METHODES
	/**
	 * Fonction retournant le numéro correspondant à la difficulté du jeu.
	 * @return difficulty : entier représentant le choix de la difficulté.
	 */
	public int getDifficulty()
	{
		return difficulty;
	}
}
