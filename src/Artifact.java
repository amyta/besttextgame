public class Artifact {

	String name, description;

	Artifact()
	{

	}
	
	Artifact(String aName)

	{
		this.name = aName; // instance of a name
	}

	Artifact(String aName, String aDescription) //overloading??

	{
		this(aName);
		this.description = aDescription;
	}
	
	String examine()
	{
		return description;
	}

	public void touch() {
		System.out.println(this.description);
	}
	
}
