package supply;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.TreeMap;
import score.Score;

public class Supply implements Comparable<Supply>{
	
		// ATTRIBUTS
	protected int idOffre;
	protected String urlImg;
	protected int quantite;
	protected int score;			// Score de l'offre par rapport � une demande.
	protected int length_C;			// Nombre de crit�re pr�sent dans l'offre.
	private Score<?> criterion[];	// Ensemble des crit�res correspondant � l'offre.
	private SPrice price;
	private STitle title;
	private SDescription desc;
	private SEditor edit;
	private SMark mark;
	private SReleaseDate rd;
	private SGameType gm;
	private SBuyMethod bm;
	private SDifficulty diff;
	private SLifeTime lt;
	private SGameStyle gst;
	private SStoryType st;
	private SGameSupport gs;
	private SAccessory acce;
	
		// CONSTRUCTEURS
	public Supply()
	{
		idOffre = -1;
		length_C = 13;
		criterion = new Score[length_C];		
		price = new SPrice(0f);
		this.urlImg = "";
		this.quantite = 0;
		this.title = new STitle("");
		this.desc  = new SDescription("");
		this.edit  = new SEditor("");
		this.mark  = new SMark(0f);
		this.rd    = new SReleaseDate(0f);
		this.gm    = new SGameType("");
		this.bm    = new SBuyMethod("");
		this.diff  = new SDifficulty("");
		this.lt    = new SLifeTime("");
		this.gst   = new SGameStyle(""); 
		this.st    = new SStoryType(null);
		this.gs    = new SGameSupport(null);
		this.acce  = new SAccessory(null);
		score = 0; 
	}
	public Supply(int id, String urlImg,int quantite, STitle title, SDescription desc, SEditor edit, SMark mark, SReleaseDate rd, SGameType gm, SBuyMethod bm, SDifficulty diff, SLifeTime lt, SGameStyle gst, SStoryType st, SGameSupport gs, SAccessory acce)
	{
		length_C = 13;
		criterion = new Score[length_C];		
		price = bm.getPrice();
		this.idOffre = id;
		this.urlImg = urlImg;
		this.quantite = quantite;
		this.title = title;
		this.desc  = desc;
		this.edit  = edit;
		this.mark  = mark;
		this.rd    = rd;
		this.gm    = gm;
		this.bm    = bm;
		this.diff  = diff;
		this.lt    = lt;
		this.gst   = gst; 
		this.st    = st;
		this.gs    = gs;
		this.acce  = acce;
		score = 0; 
	}
	
	public String getTitle(){return title.getTitle();}
	public String getDescription(){return desc.getDescription();}
	public String getEditor(){return edit.getEditor();}
	public float getMark(){return mark.getMark();}
	public Calendar getReleaseDate(){return rd.getReleaseDate();}
	public String getGameType(){return gm.getGameType();}
	public String getBuyMethod(){return bm.getBuyMethod();}
	public String getDifficulty(){return diff.getDifficulty();}
	public String getLifeTime(){return lt.getLifeTime();}
	public String getGameStyle(){return gst.getGameStyle();}
	public ArrayList<String> getStoryType(){return st.getStoryType();}
	public TreeMap<String, ArrayList<TreeMap<String, String>>>getGameSupport(){return gs.getSupports();}
	public TreeMap<String, ArrayList<TreeMap<String, String>>>getAccessory(){return acce.getAccessories();}
	public float getPrice(){return price.getPrice();}
	public int getIdOffre(){return idOffre;}
	public String getImage(){return urlImg;}
	public int getQuantite(){return quantite;}
	
	public void setTitle(String value){title.setTitle(value);};
	public void setDescription(String value){desc.setDescription(value);}
	public void setEditor(String value){edit.setEditor(value);}
	public void setMark(float value){mark.setMark(value);}
	public void setReleaseDate(Calendar value){rd.setReleaseDate(value);}
	public void setGameType(String value){gm.setGameType(value);}
	public void setBuyMethod(String value){bm.setBuyMethod(value);}
	public void setDifficulty(String value){diff.setDifficulty(value);}
	public void setLifeTime(String value){lt.setLifeTime(value);}
	public void setGameStyle(String value){gst.setGameStyle(value);}
	public void setStoryType(ArrayList<String> value){st.setStoryType(value);}
	public void addAccessory(TreeMap<String, String> value){acce.addEquipement(value);}
	public void deleteAccessory(TreeMap<String, String> value){acce.deleteEquipement(value);}
	public void setAccessory(ArrayList<TreeMap<String, String>> value){acce.setEquipements(value);}
	public void addSupport(TreeMap<String, String> value){gs.addEquipement(value);}
	public void deleteSupport(TreeMap<String, String> value){gs.deleteEquipement(value);}
	public void setSupport(ArrayList<TreeMap<String, String>> value){gs.setEquipements(value);}
	public void setPrice(float value){price.setPrice(value);}
	public void setIdOffre(int value){idOffre = value;}
	public void setImage(String value){urlImg=value;}
	public void setQuantite(int value){quantite = value;}
		
		// METHODES
	/**
	 * Fonction servant � comparer chaque crit�re de l'offre avec une demande
	 * @param myDemand : DemandMethods Interface impl�ment� par une demande.
	 */
	public void compare(DemandMethods myDemand)
	{
		score = 0;
		criterion[0] = title;
		criterion[1] = desc;
		criterion[2] = edit;
		criterion[3] = mark;
		criterion[4] = rd;
		criterion[5] = gm;
		criterion[6] = bm;
		criterion[7] = diff;
		criterion[8] = lt;
		criterion[9] = gst; 
		criterion[10]= st;
		criterion[11]= gs;
		criterion[12]= acce;
		
		for (int i=0; i< length_C; i++)
			if(criterion[i]!= null)
				score += criterion[i].getScore(myDemand);
	}
	
	/**
	 * Fonction retournant le score d'une offre
	 * @return score : int repr�sentant le score d'une offre.
	 */
	public int getScore()
	{
		return score;
	}
	
	/**
	 * Surd�finition de la m�thode toString() afin d'afficher le score de notre offre lors de l'affichage.
	 */
	public String toString()
	{
		return "\t- Title : "+criterion[0]
			   +"\n\t- Description : "+criterion[1]
	           +"\n\t- Editeur : "+criterion[2]
	           +"\n-------- -------- -------- -------- \n"
	           +"\n\t- Note : "+criterion[3]
	           +"\n\t- Date de sortie : "+criterion[4]
	           +"\n\t- Mode de jeu : "+criterion[5]
	           +"\n\t- Forme de paiement : "+criterion[6]
	           +"\n\t\t-Prix : "+price
	           +"\n-------- -------- -------- -------- \n"
	           +"\n\t- Difficult� : "+criterion[7]
	           +"\n\t- Dur�e de jeu : "+criterion[8]
	           +"\n\t- Style de jeu : "+criterion[9]
	           +"\n\t- Style d'histoire : "+criterion[10]
	           +"\n\t- Support possibles : "+criterion[11]
	           +"\n\t- Accessoires : "+criterion[12]
	           +"\n-------- -------- -------- -------- "
			   +"\n-------- Score : "+score+" -------- "
		 	   +"\n-------- -------- -------- -------- ";
	}
	
	public int compareTo(Supply s){ return score - s.getScore();}


	public static Comparator<Supply> compareSupply = new Comparator<Supply>() {
		public int compare(Supply s1, Supply s2){
			return s1.getScore()-s2.getScore();
			}
		};

}
