package supply;

public class SEditor extends SKeywords{
	public SEditor(String s){ super(s); scoreMax = 50;}
	
	public String extractD(DemandMethods myDemand){ return myDemand.getEditor();}
	public String getEditor(){return element;}
	public void setEditor(String value){element = value;}
}
