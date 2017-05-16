import java.io.File;
import java.nio.file.*;
import java.lang.Exception;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Category {
	private String time = "test";
	private int minutes;
	private String name;
	private File file;
	
	//creates an empty Category
	public Category(String nameIn) {
		name = nameIn;
		time = "00:00:00";
		minutes = 0;
		file = new File(name);

		Path path = Paths.get(name);
		
		if (Files.notExists(path)) {
			try {
				file.createNewFile();
			} catch(IOException e) {
				System.out.println(e);
			}
			
		} else {
			this.readFile();
		}
	}
	
	//method returns formatted time as a String
	public String getTime() {
		return time;
	}
	
	//method returns minutes as an int
	//not used in this program, but might as well write it, just in case.
	public int getMinutes() {
		return minutes;
	}
	
	//sets the local variables minutes and time using given input
	public void setTime(String timeIn) {
		if (timeIn != "") {
			//adding input time (int minutes) to total minutes
			try {
				minutes += Integer.parseInt(timeIn);
			} catch (NumberFormatException e) { }
			
			
			//converting minutes back to formatted time 
			int minute = minutes % 60;
			int hour = minutes / 60 % 24;
			int day = minutes / 60 / 24;
			time = "" + day + ":" + hour + ":" + minute;
			
			this.writeFile();
		}
	}
	
	//reads data from file and sets local variables
	public void readFile() {
		try {
			BufferedReader in = new BufferedReader(new FileReader(name));
			String line = in.readLine();
			if (line != null) {
				String[] interim = line.split("[.]"); //I wanted to use ".' to split the string,
													  //but since ".' is a metacharacter, i needed
													  //to express it as a literal character, thus
													  //the [] around it. 
				System.out.println(interim.length);
				time = interim[0];
				minutes = Integer.parseInt(interim[1]);
				in.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//updates the save files using the local variables
	public void writeFile() {
		//delete everything in file
		try {
			PrintWriter pw = new PrintWriter(name);
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//writing time
		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
								name, true)));
			out.print(time + "." + minutes);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
