package mainPackage;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Emptynone extends Tile {
	Image EmptyFree = new Image(new File("res/EmptyFree.jpg").toURI().toString());
	Image Emptynone = new Image(new File("res/Emptynone.jpg").toURI().toString());
	public Emptynone(int id, String type, String spec) {
		super(id, type, spec);
		setImage(JpgToTile("Emptynone"));


	}

}
