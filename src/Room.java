
public class Room 
{
	String name, description, exits[], getsExits;
	Artifact content;

	
	boolean isValidExit(String anExit)
	{
		boolean result = false; // assume you don't know anything
		
		int index = 0;
		while (result==false && index < exits.length)
		{
			if (exits[index].equals(anExit))
				result = true;
			
			index++;
		}
		return result;
	}
	
	String examine()
	{
		if (content !=null)
			return content.examine();
		else
			return "There is nothing here";
	}
	
	void getExits() 
	{
		
		String result = "";
		for (String exit : exits) {
			switch (exit) {
			case "s": result += " (south)";
			break;
			case "n": result += " (north)";
			break;
			case "w": result += " (west)";
			break;
			case "e": result += " (east)";
			break;
			case "ne" : result += " (northeast)";
			break;
			case "nw" : result += " (northwest)";
			break;
			case "sw" : result += " (southwest)";
			break;
			case "se" : result += " (southeast)";
			break;
			}
		}
		
		if (!result.equals("")) {
			System.out.println("There is an opening to the" + result + ".");
		} else {
			System.out.println("There are no exits you noob");
		}
		
	}
	
	void enterRoom()
	{
		System.out.println("\n" + this.name);
		System.out.println("\nYou have entered " + this.name + ".");
		if (content != null) {
		System.out.println(this.content.description);
		}
		this.getExits(); // Shows Exits
	}

	 void lookRoom()
	 {
		System.out.println(this.name);
		this.getExits();
		if (content !=null) {
		System.out.println("There is " + this.content.name + " here.");
		}
	 }
}
