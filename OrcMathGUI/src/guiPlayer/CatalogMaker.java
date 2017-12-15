package guiPlayer;

import java.util.ArrayList;
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
		getInput();
	}
	public static void getInput() {
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
	public static void addNewItem(String name, String type, double price) {
		list.add(new Pokemon(name,type,price));
		System.out.println("Added new Pokemon");
		System.out.println(StringGetCSVContent());
		
	}
	
}
