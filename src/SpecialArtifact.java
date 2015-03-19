
public class SpecialArtifact extends Artifact
{

	String powerOn, powerOff;
	boolean powerState;
	
	SpecialArtifact()
	{
		this.powerState = true;
	}
	public void toggle()
	{
		this.powerState = !this.powerState;
	}
	
	SpecialArtifact(String aName)
	{
		super(aName);
	}
	
	String examine()
	{	this.toggle();
		if (!powerState) // making paper glow
			return this.description;
		else
			return this.powerOff;
	}
	
	public void touch()
	{
		if (!powerState) {
			System.out.println(this.powerOn);
		}
		else {
			System.out.println(this.description);
		}
	}
}
