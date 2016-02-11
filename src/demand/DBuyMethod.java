package demand;

public class DBuyMethod {
		// ATTRIBUTS
	protected DPrice price;	// Prix du jeu.
	protected int method;	// Numéro du mode de paiement.
	
		// CONSTRUCTEURS
	public DBuyMethod(DPrice prix, int m)
	{
		price = prix;
		method = m;
	}

		// METHODES
	/**
	 * Fonction retournant le numéro correspondant à la méthode de paiement utilisée.
	 * @return method : entier représenant le choix du mode de paiement.
	 */
	public int getMethod()
	{
		return method;
	}
	
	/**
	 * Fonction retournant un object Dprice correspondant au prix du jeu.
	 * @return price : DPirce objet représentant le prix du jeu.
	 */
	public DPrice getPrice()
	{
		return price;
	}
}

