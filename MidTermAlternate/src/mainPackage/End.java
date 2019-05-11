package mainPackage;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class End extends Tile {
	Image EndHorizontal = new Image(new File("res/EndHorizontal.jpg").toURI().toString());
	Image EndVertical = new Image(new File("res/EndVertical.jpg").toURI().toString());
	public End(int id, String type, String spec) {
		super(id, type, spec);
		if(getSpec()=="Horizontal") {
			
			ImageView endHorizontaliv = new ImageView(EndHorizontal);
			getChildren().add(endHorizontaliv);
		}
		else if (getSpec()=="Vertical") {
			ImageView endVerticaliv = new ImageView(EndVertical);
			getChildren().add(endVerticaliv);

		}

	}

}
