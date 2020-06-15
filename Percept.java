
public class Percept {
	
	private int location; 
	private boolean isDirty;
	
	public Percept(int location, boolean dirty) {
		this.location = location;
		this.isDirty = dirty;
	}
	
	public int getLocation() {
		
		return location; 
		
	}
	
	public void setLocation(int location) {
		this.location = location; 
	}
	
	public boolean isDirty() {
		return isDirty; 
		
	}
	public void setDirty(boolean isDirty) { 
		if(isDirty) {
			isDirty = true;
			
		}
		else {
			isDirty = false;
		}
		
	}

}
