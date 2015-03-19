
public class Map 
{
	
	Room [][] rooms = new Room[4][4];
	SpecialArtifact fountain;
	
	Map() //constructor 
	{
		// Create rooms
		// 0,0
		Room gardenArea = new Room();
		gardenArea.name = "Garden Area";
		gardenArea.description = "You are standing at the entrance to a beautiful rose garden.";
		gardenArea.exits = new String[] {"s"};
		
		fountain = new SpecialArtifact("a fountain");
		fountain.description = "The small plaque on the fountain reads: Enjoy the garden!";
		fountain.powerState = true;
		fountain.powerOn = "The small plaque reveals a hidden message.";
		fountain.powerOff = "The hidden message says: Beware of the plant guardians.";
		gardenArea.content = fountain;
		
		// 2,1
		Room draftyRoom = new Room();
		draftyRoom.name = "Drafty Room";
		draftyRoom.description = "The smell of hamburgers wafts through the air.";
		draftyRoom.exits = new String[] {"n", "w"};
		
		Artifact lunch = new Artifact("lunch");
		lunch.description = "The lunch appears to be a hamburger, French fries, and some kind of soda.";
		draftyRoom.content = lunch;
		
		// 2,0
		Room lrgRoom = new Room();
		lrgRoom.name = "Large Room";
		lrgRoom.description = "A picure of the University President adorns the north wall.";
		lrgRoom.exits = new String[] {"e"};
		
		Artifact picture = new Artifact("a picture");
		picture.description = "The picture bears an inscription that reads: President of Cal Poly Pomona.";
		lrgRoom.content = picture;
		
		// 0,1
		Room mercury = new Room();
		mercury.name = "Mercury";
		mercury.description = "This room is sweltering hot with acidic clouds.";
		mercury.exits = new String[] {"e", "s"};
		
		Artifact hotjalapeno = new Artifact("a Flaming Hot Jalapeno");
		hotjalapeno.description = "A flaming hot jalapeno that can be deadly if eaten.";
		mercury.content = hotjalapeno;
		
		// 0,2
		Room venus = new Room();
		venus.name = "Venus";
		venus.description = "A beautiful maiden lies here.";
		venus.exits = new String[] {"e", "w"};
		
		Artifact aphrodite = new Artifact("Goddess Aphrodite");
		aphrodite.description = "The Goddess of love Aphrodite blesses you on your search for love.";
		venus.content = aphrodite;
		
		// 0,3
		Room earth = new Room();
		earth.name = "Earth";
		earth.description = "There is an inscription on the wall that reads: beautiful pale blue dot.";
		earth.exits = new String[] {"w", "sw"};
		
		Artifact mankind = new Artifact("Mankind");
		mankind.description = "Mankind; The only known living organisms in this universe resides here.";
		earth.content = mankind;
		
		// 1, 0
		Room lobby = new Room();
		lobby.name = "Lobby";
		lobby.description = "Sunlight is streaming in through the glass door.";
		lobby.exits = new String[] {"e", "n"};
		
		Artifact sign = new Artifact("a sign");
		sign.description = "(read) This way to the rose garden.";
		lobby.content = sign;
		
		// 1,1
		Room classRoom = new Room();
		classRoom.name = "Class Room";
		classRoom.description = "An old exam lies on a table in the center of the room.";
		classRoom.exits = new String[] {"n", "s", "w"};
		
		Artifact exam = new Artifact("an exam");
		exam.description = "CIS 234 Final Exam... The rest appears unreadable due to a lack of printer toner.";
		classRoom.content = exam;
		
		// 1,2
		Room mars = new Room();
		mars.name = "Mars";
		mars.description = "Mars Curiousity is seen roaming around this room.";
		mars.exits = new String[] {"e", "ne"};
		
		Artifact curiousity = new Artifact("Mars Curiousity rover");
		curiousity.description = "Mars Curiousity has been exploring this planet since 2012.";
		mars.content = curiousity;
		
		// 1,3
		Room jupiter = new Room();
		jupiter.name = "Jupiter";
		jupiter.description = "This room has an incredibly gassy atmosphere";
		jupiter.exits = new String[] {"w", "sw"};
		
		Artifact gas = new Artifact("a gas bubble");
		gas.description = "A gas bubble that smells rather stinky floats pass.";
		jupiter.content = gas;
		
		
		// 2,2
		Room saturn = new Room();
		saturn.name = "Saturn";
		saturn.description = "There is a a shiny object in the center of this room";
		saturn.exits = new String[] {"e", "ne", "se"};
		
		Artifact ring = new Artifact("a gold ring");
		ring.description = "A golden ring with a spectacular shine levitates in the center of the room.";
		saturn.content = ring;
		
		// 2,3
		Room uranus = new Room();
		uranus.name = "Uranus";
		uranus.description = "There seems to be a character from the Harry Potter universe in this room.";
		uranus.exits = new String[] {"w", "s"};
		
		Artifact dobey = new Artifact("a Dobey");
		dobey.description = "A house elf that was released by Sir Harry Potter.";
		uranus.content = dobey;
		
		// 3,0
		Room clearing = new Room();
		clearing.name = "Clearing";
		clearing.description = "A dark cavernous opening in the nearby cliff lies just north of you.";
		clearing.exits = new String[] {"n", "e"};
		
		Artifact paper = new Artifact("a paper");
		paper.description = "The paper reads: Welcome to the Great Cal Poly Underground!";
		clearing.content = paper;
		
		// 3,1
		Room neptune = new Room();
		neptune.name = "Neptune";
		neptune.description = "An almight Curl is seen in this room.. approach with caution, he is too godly.";
		neptune.exits = new String[] {"e", "w"};
		
		SpecialArtifact curl = new SpecialArtifact("Professor Curl");
		curl.description = "An almighty Curl appears!";
		curl.powerState = true;
		curl.powerOn = "Curl says: 'What do you want simpleton, be gone with you!'";
		curl.powerOff = "Curl is now in Super Saiyan mode and refuses to be bothered.";
		neptune.content = curl;
		
		// 3,2
		Room pluto = new Room();
		pluto.name = "Pluto";
		pluto.description = "There is nothing in this room because it is no longer a planet.";
		pluto.exits = new String[] {"e", "w"};

		// 3,3
		Room blackHole = new Room();
		blackHole.name = "Black Hole";
		blackHole.description = "The most powerful force in the universe is drawing you in closer...";
		blackHole.exits = new String[] {"n", "w", "nw"};
		
		SpecialArtifact vortex = new SpecialArtifact("a black hole");
		vortex.description = "The black hole is pulling you into the event horizon.";
		vortex.powerState = true;
		vortex.powerOn = "The black hole is now trasnporting you into another universe...";
		vortex.powerOff = "Somehow an alien spaceship has pulled you out of the black hole";
		blackHole.content = vortex;
		
		// Place rooms on map, above is just building room
		rooms[0][0] = gardenArea; // if room is moved, exits and everything else goes with it
		rooms[0][1] = mercury;
		rooms[0][2] = venus;
		rooms[0][3] = earth;
		rooms[1][0] = lobby;
		rooms[1][1] = classRoom;
		rooms[1][2] = mars;
		rooms[1][3] = jupiter;
		rooms[2][0] = lrgRoom;
		rooms[2][1] = draftyRoom;
		rooms[2][2] = saturn;
		rooms[2][3] = uranus;
		rooms[3][0] = clearing;
		rooms[3][1] = neptune;
		rooms[3][2] = pluto;
		rooms[3][3] = blackHole;
		
	}
	
	void clear()
	{
//		rooms[0][0].content = null;
		for (int xrow = 0; xrow <= 3; xrow++) {
			for (int ycol = 0; ycol <=3; ycol++) {
				if (rooms[xrow][ycol].content != null) {
					rooms[xrow][ycol].content = null;
				}
			}
		}
	}
	
	void setArtifact(String aName, int row, int col)
	{	
		if (aName.equals("fountain"))
			rooms[row][col].content = fountain;
	}
	
	public Artifact getArtifact(String name)
	{
		if (name.equals("fountain")) {
			return fountain;
		} 
		return null;
	}
}
