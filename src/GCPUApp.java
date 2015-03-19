import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GCPUApp {
	public static void main(String[] args) 
	{
		// Declare and initialize variables
		Scanner scan = new Scanner(System.in); 
		
		// Starting location
		int row = 3;
		int col = 0;
		
		// Create an instance of a map
		Map map = new Map();
		
		// Begin user dialog
		System.out.println("Welcome to the Great Cal Poly Underground!");
		String input = "";
		
		Backpack pack = new Backpack();
		map.rooms[row][col].enterRoom();
		while (!input.equalsIgnoreCase("y"))
		{
			System.out.print("\n> ");
			input = scan.nextLine();
			
			if (input.equals("e"))
				if (map.rooms[row][col].isValidExit("e")) {
					col++;
					map.rooms[row][col].enterRoom();
				}
			else {
				System.out.println("You can't go that way.");
			}
			
			else
			if (input.equals("w")) {
				if (map.rooms[row][col].isValidExit("w")) {
					col--;
					map.rooms[row][col].enterRoom();
				}
				else {
					System.out.println("You can't go that way.");
				}
			}
			else
			if (input.equals("s")) {
				if(map.rooms[row][col].isValidExit("s")) {
					row++;
					map.rooms[row][col].enterRoom();
				}
				else {
					System.out.println("You can't go that way.");
				}
			}
			else
			if (input.equals("n")) {
				if(map.rooms[row][col].isValidExit("n")) {
					row--;
					map.rooms[row][col].enterRoom();
				}
				else {
					System.out.println("You can't go that way");
				}
			}
			else
			if (input.equals("nw")) {
				if(map.rooms[row][col].isValidExit("nw")) {
						row--;
						col--;
						map.rooms[row][col].enterRoom();
					}
				else {
					System.out.println("You can't go that way");
				}
			}
			else
				if (input.equals("ne")) {
					if(map.rooms[row][col].isValidExit("ne")) {
						row--;
						col++;
						map.rooms[row][col].enterRoom();
					}
					else {
						System.out.println("You can't go that way");
					}
			}
			else
				if (input.equals("sw")) {
					if(map.rooms[row][col].isValidExit("sw")) {
						row++;
						col--;
						map.rooms[row][col].enterRoom();
					}
					else {
						System.out.println("You can't go that way");
					}
			}
			else
				if (input.equals("se")) {
					if(map.rooms[row][col].isValidExit("se")) {
						row++;
						col++;
						map.rooms[row][col].enterRoom();
					}
					else {
						System.out.println("You can't go that way");
					}
		}			
		else
			if (input.equals("drop"))
			{	
					if (map.rooms[row][col].content == null) 
					{ // > 0 for multiple artifacts 
						map.rooms[row][col].content = pack.removeArtifact(); // get first item in backpack & transform to room
						System.out.println("You have dropped " + map.rooms[row][col].content.name);
					}
					else
					{
						Artifact anyArtifact = map.rooms[row][col].content; // move artifact, local variable
						map.rooms[row][col].content = pack.removeArtifact(); // get first item in backpack & transform to room
						pack.setArtifact(anyArtifact); // get artifact
						System.out.println("You have dropped " + map.rooms[row][col].content.name);
					}
					
			}
			else
			if (input.equals("examine")) {
				System.out.println(map.rooms[row][col].examine());
			}
			else
			if (input.equals("look")) {
				map.rooms[row][col].lookRoom();
			}
			else
			if (input.equals("touch")) {
				map.rooms[row][col].content.touch();
				
			}
			else
			if (input.equals("inventory")) {
				pack.list();
			}
				else
					if (input.equals("restore"))
					{	
						
						File file = new File("/volumes/macintosh hd/users/amyta/desktop/files/GCPU2.txt");
						try (	FileReader reader = new FileReader(file);
								BufferedReader buffer = new BufferedReader(reader);)
						{	
							map.clear();
							String line = buffer.readLine();
							while (line!=null)
							{
								String[] data = line.split(",");
								String key = data[0];
								if (key.equals("Start Location"))
								{
								row = Integer.parseInt(data[1]);
								col = Integer.parseInt(data[2]);
								}
								else
								if (key.equals("Artifact"))
								{
									String name = data[1];
									int artifactRow = Integer.parseInt(data[2]);
									int artifactCol = Integer.parseInt(data[3]);
									map.setArtifact(name, artifactRow, artifactCol);
								}
								else if (key.equals("Inventory"))
								{
									String item = data[1];
									pack.contents.add(map.getArtifact(item));
									
								}
								line = buffer.readLine();
								
								}
							map.rooms[row][col].enterRoom(); 
						}
						catch (IOException e)
						{
							System.out.println("This file does not exist. Please save first.");
						}
					}
						else
						if (input.equals("save"))
						try {
							String save = "y";
							
							File file = new File("/volumes/macintosh hd/users/amyta/desktop/files/GCPU2.txt");
							FileWriter writer = new FileWriter(file);
							BufferedWriter buffer = new BufferedWriter(writer);
							PrintWriter pw = new PrintWriter(writer);
							
							if (file.exists()) {
								System.out.println("This file already exists. Would you like to overwrite? (Y/N)");
								Scanner saveInput = new Scanner(System.in);
								save = saveInput.nextLine();
							}
							if (save.equalsIgnoreCase("y")) {
								pw.println("Start Location" + "," + row + "," + col);
								for (int xrow = 0; xrow <= 3; xrow++) {
									for (int ycol = 0; ycol <=3; ycol++) {
										if (map.rooms[xrow][ycol].content != null) {
											pw.println("Artifact," + map.rooms[xrow][ycol].content.name + "," + xrow + "," + ycol);
										}
									}
								}
								
								for (int i=0; i < pack.contents.size(); i++) {
									if (pack.contents != null) {
										pw.println("Inventory," + pack.contents.get(i).name);
									}
								}
								
								buffer.close();
								pw.close();
							}
							map.rooms[row][col].enterRoom();
						}
						catch (IOException e)
						{
							System.out.println(e.getMessage());
						}
					
						else if (input.equals("take"))
						{

							if (map.rooms[row][col].content != null) {
								pack.setArtifact(map.rooms[row][col].content);
								map.rooms[row][col].content = null;
							} else {
								System.out.println("This room is empty.");
							}
			
			}
			else if (input.equalsIgnoreCase("quit")) {
				System.out.print("Do you wish to leave the Underground (Y/N)? > ");
				input = scan.nextLine();
				if (input.equalsIgnoreCase("n")) {
					map.rooms[row][col].enterRoom();
				}
			}
			else System.out.println("I don't understand " + "'" + input + "'.");
			
		}
		System.out.println("Thank you for visiting The Great Cal Poly Underground.");
		scan.close();
	}
}