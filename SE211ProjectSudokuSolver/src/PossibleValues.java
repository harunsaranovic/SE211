import java.util.ArrayList;

public class PossibleValues {
	
	public ArrayList values = new ArrayList();
	public ArrayList clones = new ArrayList();
	
	public PossibleValues(){
		
		for(int i=1; i<10; i++) {
			values.add(""+i);
		}
		
	}
	
	public void cloneValues() {
		clones.clear();
		clones.addAll(values);
	}
	
	public void removeFromClones(String toBeRemoved) {
		clones.remove(toBeRemoved);
	}
	
}
