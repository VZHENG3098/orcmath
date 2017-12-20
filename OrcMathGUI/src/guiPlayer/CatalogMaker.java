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

	private ArrayList<Pokemon> list;
	static Scanner sc = new Scanner(System.in);
	public CatalogMaker() {
		list = new ArrayList<Pokemon>();
		list.add(new Pokemon("Squirtle","Water",5.00));
		list.add(new Pokemon("Bulbasaur","Grass",5.00));
		list.add(new Pokemon("Charmander","Fire",10.00));
	}
	public String StringGetCSVContent() {
		String data = "Pokemon,Type,Price \n";
		for(Pokemon p:list) {
			data += p+"\n";
		}
		return data;
	}
	public static void main(String[] args) {
		CatalogMaker  x = new CatalogMaker();
		System.out.println(x.StringGetCSVContent());
		System.out.println("What do you want to name to file?");
		List<String> content = x.testFileLoading();
		x.getData(content);
		x.getInput();
		x.testSaveContent("name.csv");
	}
	public  void getInput() {
		String name;
		String type;
		String price;
		System.out.println("Add pokemon name\n");
		name = sc.nextLine();
		System.out.println("Add pokemon type\n");
		type = sc.nextLine();
		System.out.println("Add pokemon price\n");
		price = sc.nextLine();
		addNewItem(name,type,Double.parseDouble(price));

	}
	public void addNewItem(String name, String type, double price) {
		list.add(new Pokemon(name,type,price));
	}
	
	private  void testSaveContent(String fileName) {

		try {

			FileWriter fw = new FileWriter(fileName);

			for(Pokemon a : list) {
				fw.write(a +"\n");
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
		boolean opened = false;

		while (!opened) {

			try {

				System.out.println("Enter a file to open");

				fileName = in.nextLine();

				FileReader fileReader = new FileReader(new File(fileName));

				String line = "";


				BufferedReader br = new BufferedReader(fileReader);

				while ((line = br.readLine()) != null) {

					content.add(line);
				}

				br.close();

				opened = true;

			} catch (IOException e) {

				System.out.println("The file name you specified does not exist.");

			}

		}
		return content;

	}
	
	public void getData(List<String> content) {
		for (String item : content) {

			System.out.println(item);

		}
	}

}
