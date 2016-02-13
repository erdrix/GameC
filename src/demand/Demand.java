
/**
 * @author guitt
 *
 */

package demand;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.TreeMap;
import supply.DemandMethods;
import supply.Intervalle;


/* Titre - Description - Editeur - Prix -
Note du jeu - Date de sortie - Mode de jeu - 
Mode de paiement - Difficulté - Durée de vie - 
Style de l'histoire - Support de jeu - Jouable avec accessoires - Lieu d'achat - Type de jeu*/ 

public class Demand implements DemandMethods{
		// ATTRIBUTS
	private DTitle dtitle;		// Eléments présent dans le titre du jeu.
	private DDescription ddesc;	// Eléments présent dans la descrition.
	private DEditor dedit;		// Eléments présent dans le nom de l'éditeur.
	
	private DMark dmark;		// Intervalle de note du jeu.
	private DReleaseDate drd;	// Intervalle de sortie du jeu.
	
	private DGameType dgt;		// Choix du mode de jeu.
	private DBuyMethod dbm;		// Choix de la forme de paiement (Licenses | abonnement).
	
	private DDifficulty ddiff;	// Choix de la difficuluté du jeu.
	private DLifeTime dlt;		// Durée moyenne de vie du jeu.
	
	private DGameStyle dgst;	// Choix du style de jeu (AA | A-RPG | Action ...)
	
	private DStoryType dst;		// Ensemble des styles d'histoire.
	private DGameSupport dgs;	// Ensemble des supports compatibles avec le jeu.
	private DAccessory dacce;	// Ensemble des accessoires permettant de jouer au jeu.
	private DSale[] dsa;		// Ensemble des lieux de vente acceptés.

		// CONSTRUCTUEUR
	public Demand(){
		
	}
	/**
	 * Constructeur initialisant la demande du client avec l'ensemble des champs d'une offre (champs pouvant potentiellement être nuls)
	 * @param title : DTitle objet contenant les mots-clefs du titre du jeu.
	 * @param desc  : DDescription objet contenant les mots-clefs de la description.
	 * @param edit  : DEditor objet contenant les mots-clefs de l'éditeur.
	 * @param mark  : DMark objet contenant un intervalle de note pour le jeu.
	 * @param rd    : DReleaseDate objet contenant un intervalle de date (timestamp) pour la date de sortie du jeu.
	 * @param gt    : DGameType objet contenant le mode de jeu.
	 * @param bm    : DBuyMethod objet contenant la forme de paiement.
	 * @param diff  : DDifficulty objet contenant le choix de la difficulté.
	 * @param lt    : DLifeTime objet contenant le choix de la durée moyenne de jeu.
	 * @param gst   : DGameStyle objet contenant le choix du style de jeu.
	 * @param st    : DStoryType objet contenant l'ensemble des styles d'histoire.
	 * @param gs    : DGameSupport objet contenant l'ensemblre des supports voulus.
	 * @param acce  : DAccessory objet contenant l'ensemblre des accessoire voulus.
	 * @param sa    : DSale objet contenant l'ensemblre des lieu de ventes voulus.
	 * @param nSale : int nombre de lieux de ventes sélectionnés par le client.
	 */
	public Demand(DTitle title, DDescription desc, DEditor edit, DMark mark, DReleaseDate rd, DGameType gt, DBuyMethod bm, DDifficulty diff, DLifeTime lt, DGameStyle gst, DStoryType st, DGameSupport gs, DAccessory acce, DSale[] sa, int nSale)
	{
		dtitle = title;
		ddesc  = desc;
		dedit  = edit;
		dmark  = mark;
		drd    = rd;
		dgt    = gt;
		dbm    = bm;
		ddiff  = diff;
		dlt    = lt;
		dgst   = gst;
		dst    = st;
		dgs    = gs;
		dacce  = acce;
		
		dsa = new DSale[nSale];
		for (int i=0; i < nSale; i++)
			dsa[i] = sa[i];
	}

	// METHODES
	public String getTitle()
	{
		return dtitle.getField();
	}
	
	public String getDescription()
	{
		return ddesc.getField();
	}
	
	public String getEditor()
	{
		return dedit.getField();
	}
	
	/**
	 * Fonction retournant l'intervalle de prix souhaités par la demande.
	 * @return dprice.getPrice() : Intervalle (double) représentant le prix du jeu.
	 */
	public Intervalle getPrice()
	{
		DPrice price = (dbm ==null)? null:dbm.getPrice();
		return (price ==null)? null:price.getPrice();
	}
	
	/**
	 * Fonction retournant l'intervalle de notes souhaités par la demande.
	 * @return dmark.getRange() : Intervalle (double) représentant la note du jeu.
	 */
	public Intervalle getMark()
	{
		return (dmark ==null)? null:dmark.getRange();
	}
	
	/**
	 * Fonction retournant l'intervalle de dates de sortie souhaitées par la demande.
	 * @return drd.getRange() : Intervalle (double) représentant la date de sortie du jeu.
	 */
	public Intervalle getReleaseDate()
	{
		return (drd ==null)? null:drd.getRange();
	}
	
	/**
	 * Fonction retournant le choix pour le type de jeu (solo ou multi)
	 * @return dgt.DGameType() : int symbolisant un type de jeu.
	 */
	public int getDGameType()
	{
		return (dgt ==null)? null:dgt.getType();
	}
	
	/**
	 * Fonction retournant le choix pour la forme de paiement (abonnement, licence)
	 * @return dbm.getMethod() : int symbolisant la forme de paiement du jeu.
	 */
	public int getDBuyMethod()
	{
		return (dbm ==null)? null:dbm.getMethod();
	}
	
	/**
	 * Fonction retournant le choix pour la difficulté du jeu (facile | intermédiaire | expérimenté).
	 * @return dlt.getDifficulty() : int symbolisant une difficulté.
	 */
	public int getDifficulty()
	{
		return (ddiff ==null)? null:ddiff.getDifficulty();
	}
	
	/**
	 * Fonction retournant le choix pour la durée de vie du jeu (court | moyen | long).
	 * @return dlt.getTime() : int symbolisant un type de durée de vie.
	 */
	public int getDLifeTime()
	{
		return (dlt ==null)? null:dlt.getTime();
	}
	
	/**
	 * Fonction retournant le choix pour le style de jeu
	 * @return dgst.DGameStyle() : int symbolisant un style de jeu.
	 */
	public String getGameStyle()
	{
		return (dgst ==null)? null:dgst.getStyle();
	}
	
	/**
	 * Fonction retournant l'ensemble des choix pour le style d'histoire du jeu.
	 * @return dst.getType() : int[] symbolisant les styles d'histoires choisis.
	 */
	public int[] getStoryType()
	{
		return (dst ==null)? null:dst.getType();
	}

	/**
	 * Fonction retournant l'ensemble des choix pour les supports compatibles.
	 * @return dgs.getEquipements() :  Triplet<String, String, Integer>[] symbolisant les supports compatibles choisis (constructeur, nom, type).
	 */
	public ArrayList<TreeMap<String, String>> getGameSupportEquipements()
	{
		
		return (dgs == null)?null : dgs.getEquipements();
	}
	
	
	/**
	 * Fonction retournant l'ensemble des choix pour les accessoires compatibles.
	 * @return dgs.getEquipements() :  Triplet<String, String, Integer>[] symbolisant les accessoires compatibles choisis (constructeur, nom, type).
	 */
	public ArrayList<TreeMap<String, String>> getAccessoryEquipements()
	{
		return (dacce ==null)? null:dacce.getEquipements();
	}
	
	public void setField(String classe, Object s){
		try {
			Field [] fields = Class.forName("demand.Demand").getDeclaredFields();
			for(Field f : fields){
				if(f.toString().contains(classe)){
					Class<?> crit_class = Class.forName("demand."+classe);
					Constructor<?> constructors = crit_class.getDeclaredConstructor(s.getClass()); 
					Object criteria = constructors.newInstance(s);
					f.setAccessible(true);
					f.set(this,criteria);		
				}
			}		
		} catch (InvocationTargetException | IllegalAccessException | InstantiationException | IllegalArgumentException | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
