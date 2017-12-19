package MyStuff;

import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextField;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen{

	private TextField descriptionField;
	private TextField pokemonField;
	private Button addButton;
	public CatalogScreen(int width, int height){
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		descriptionField = new TextField(40,40,200,30,"Charmander","Fire Type");
		
		pokemonField = new TextField(240,40,200,30,"Squirtle","Water Type");
		
		addButton = new Button(440,40,200,30,"Button",  new Action() {
			
			public void act() {
				pokemonField.setText("hahahah");
				
			}
		});
		
		viewObjects.add(descriptionField);
		viewObjects.add(pokemonField);
		viewObjects.add(addButton);
	}

}
