import java.util.HashMap;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileInputStream;

class FriendList {
	private static HashMap<String, ArrayList<String>> readInput(String filename) throws FileNotFoundException {
		Scanner inputStream = new Scanner(new FileInputStream(filename));
		HashMap<String, ArrayList<String>>  map = new HashMap<String, ArrayList<String>>();
		while(inputStream.hasNextLine()) {
			String line = inputStream.nextLine();
			String[] names = line.split("\t");
			if(!map.containsKey(names[0])) {
				map.put(names[0], new ArrayList<String>());
			}
			map.get(names[0]).add(names[1]);
			if(!map.containsKey(names[1])) {
				map.put(names[1], new ArrayList<String>());
			}
			map.get(names[1]).add(names[0]);
		}
		inputStream.close();
		return map;
	}
	
	private static void writeOutput(String filename, HashMap<String, ArrayList<String>> map) throws FileNotFoundException {
		PrintWriter outputStream = new PrintWriter(new FileOutputStream(filename));		
		for(String name: map.keySet()) {
			outputStream.print(name + ": ");
			for(String friend : map.get(name)) {
				outputStream.print(friend + " ");
			}
			outputStream.println();
		}
		outputStream.close();
	}
	
	private static void twoHopFriends(HashMap<String, ArrayList<String>> map) {
		for(String name: map.keySet()) {
			System.out.print(name + ": ");
			ArrayList<String> friends = map.get(name);
			for(String friend : friends) {
				ArrayList<String> ffriends = map.get(friend);
				for (String ffriend : ffriends){
					if(!friends.contains(ffriend) && !name.equals(ffriend)){
						System.out.print(ffriend + " ");
					}
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		HashMap<String, ArrayList<String>> map = null;
		
		try {
			map = readInput("input.txt");
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found");
			System.exit(0);
		}

		twoHopFriends(map);
		
		try {
			writeOutput("output.txt", map);
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found");
			System.exit(0);
		}
	}
}