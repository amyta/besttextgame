import java.util.ArrayList;

public class Backpack {
	public ArrayList <Artifact> contents = new ArrayList <Artifact> ();
	
	
	public void setArtifact(Artifact anyArtifact)
	{
		if (contents.size() < 3) {
			contents.add(anyArtifact);
			System.out.println("You added " + anyArtifact.name);
		} else {
			System.out.println("Your backpack is full, sorry :(");
		}
	}
	
	public void list()
	{	
		if (contents.size() > 0) {
			String carry = "You are carrying ";
			for (Artifact item : contents) {
				carry += item.name + " ";
			}
			System.out.println(carry);
		} else {
			System.out.println("Your backpack is empty.");
		}

	}
	
	public Artifact removeArtifact() //service, user interface is GCPUApp
	{
		return contents.remove(0);
	}
	
	public int count() // find out if pack is empty
	{
		return contents.size();
	}
	
	public void addItem(Artifact item) {
		contents.add(item);
	}
	
	
}