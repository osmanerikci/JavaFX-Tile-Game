package mainPackage;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Starter extends Tile{
	Image StarterHorizontal = new Image(new File("res/StarterHorizontal.jpg").toURI().toString());
	Image StarterVertical = new Image(new File("res/StarterVertical.jpg").toURI().toString());
	public Starter(int id, String type, String spec) {
		super(id, type, spec);
		if(getSpec()=="Horizontal") {
			
			ImageView starterHorizontaliv = new ImageView(StarterHorizontal);
			getChildren().add(starterHorizontaliv);
		}
		else if (getSpec()=="Vertical") {
			ImageView starterVerticaliv = new ImageView(StarterVertical);
			getChildren().add(starterVerticaliv);

		}

	}

}
