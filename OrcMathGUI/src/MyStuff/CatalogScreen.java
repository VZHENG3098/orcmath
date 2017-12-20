package MyStuff;

import java.awt.Color;
import java.util.List;

import guiPlayer.CatalogMaker;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextField;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen{

	private TextField descriptionField;
	private TextField pokemonField;
	private TextField priceField;
	
	
	private TextArea textArea;
	private Button addButton;
	private CatalogMaker catalog;
	
	public CatalogScreen(int width, int height){
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		catalog = new CatalogMaker();
		descriptionField = new TextField(40,40,200,30,"Water","Type");
		pokemonField = new TextField(40,90,200,30,"Squirtle","Pokemon");
		priceField = new TextField(40,140,200,30,"50","Price");
		
		priceField.setInputType(TextField.INPUT_TYPE_NUMERIC);
		
		textArea = new TextArea(540, 50, 300, 200,"");
		
		addButton = new Button(40,200,200,30,"Button",  new Action() {
				
		public void act() {
				addButtonClick();
			}
		});
		
		viewObjects.add(descriptionField);
		viewObjects.add(pokemonField);
		viewObjects.add(addButton);
		viewObjects.add(priceField);
		viewObjects.add(textArea);
	}

	protected void addButtonClick() {
		pokemonField.setBackgroundColor(Color.WHITE);
		descriptionField.setBackgroundColor(Color.WHITE);
		priceField.setBackgroundColor(Color.WHITE);
		if( pokemonField.getText().equals("") ||  descriptionField.getText().equals("") || priceField.getText().equals("")) {
			if(pokemonField.getText().equals("")) {
				pokemonField.setBackgroundColor(Color.RED);
			}
			if(descriptionField.getText().equals("")) {
				descriptionField.setBackgroundColor(Color.RED);
			}
			if(priceField.getText().equals("")) {
				priceField.setBackgroundColor(Color.RED);
			}
			
			return;
		}
		String poke = pokemonField.getText();
		String type = descriptionField.getText();
		double price = Double.parseDouble(priceField.getText());
		String sd = textArea.getText() + poke +" " + type + " "+price+"\n";
		textArea.setText(sd);
		catalog.addNewItem(poke, type, price);
		
		pokemonField.setText("");
		descriptionField.setText("");
		priceField.setText("");
	}

}
