package demand;

public class DKeywords {
	protected String field;
	
	public DKeywords(String s){
		field = new String(s);
	}
	
	public void setField(String s){
		field = s;
	}
	
	public String getField(){
		return field;
	}
}
