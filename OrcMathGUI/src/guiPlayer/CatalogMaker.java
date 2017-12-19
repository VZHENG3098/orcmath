package guiPlayer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CatalogMaker {

	private static ArrayList<Pokemon> list;
	static Scanner sc = new Scanner(System.in);
	public CatalogMaker() {
		list = new ArrayList<Pokemon>();
		list.add(new Pokemon("Squirtle","Water",5.00));
		list.add(new Pokemon("Bulbasaur","Grass",5.00));
		list.add(new Pokemon("Charmander","Fire",10.00));
	}
	
	public static String StringGetCSVContent() {
		String data = "Pokemon,Type,Price \n";
		for(Pokemon p:list) {
			data += p+"\n";
		}
		return data;
	}
	public static void main(String[] args) {
		CatalogMaker  x = new CatalogMaker();
		System.out.println(x.StringGetCSVContent());
		x.testSaveContent("test2.csv");
		getInput();
	}
	public static void getInput() {
		String name;
		String type;
		String price;
		while(!(sc.nextLine().equals("stop"))) {
			System.out.println("Add pokemon name\n");
			name = sc.nextLine();
			System.out.println("Add pokemon type\n");
			type = sc.nextLine();
			System.out.println("Add pokemon price\n");
			price = sc.nextLine();
			addNewItem(name,type,Double.parseDouble(price));
		}

	}
	public static void addNewItem(String name, String type, double price) {
		list.add(new Pokemon(name,type,price));
		System.out.println("Added new Pokemon");
		System.out.println(StringGetCSVContent());
		
	}
	
	private  void testSaveContent(String fileName) {

		try {

			FileWriter fw = new FileWriter(fileName);

			for(Pokemon a : list) {
				fw.write(a.toString());
			}

			fw.close();

			System.out.println("Success! File \"" + fileName + "\" saved!");

		} catch (IOException e) {

			System.out.println(
					"An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");

		}

	}

	private List<String> testFileLoading() {

		Scanner in = new Scanner(System.in);

		String fileName = "";

		List<String> content = new ArrayList<String>();

		// use this boolean to control the while loop. The user should have multiple
		// chances to enter a correct filename

		boolean opened = false;

		while (!opened) {

			try {

				System.out.println("Enter a file to open");

				fileName = in.nextLine();

				FileReader fileReader = new FileReader(new File(fileName));

				String line = "";

				// a BufferedReader enables us to read teh file one line at a time

				BufferedReader br = new BufferedReader(fileReader);

				while ((line = br.readLine()) != null) {

					content.add(line);

					/*
					 * 
					 * useful later:
					 * 
					 * split only a comma that has an even number of quotes ahead of it
					 * 
					 * String[] row = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
					 * 
					 */

				}

				br.close();

				opened = true;

			} catch (IOException e) {

				System.out.println("The file name you specified does not exist.");

			}

		}

		// close the Scanner

		in.close();

		return content;

	}
	

}
