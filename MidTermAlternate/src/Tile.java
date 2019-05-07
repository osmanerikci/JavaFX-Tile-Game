import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends StackPane {
	
	private int location;
	private String type;
	private String spec;
	private static Scanner input;
	public Tile(int location, String type, String  spec) {

		setLocation(location);
		setType(type);
		setSpec(spec);
		
		
		Rectangle border = new Rectangle(100, 100);
		border.setFill(null);
		border.setStroke(Color.BLACK);
		setAlignment(Pos.CENTER);
		getChildren().addAll(border);

		setOnMouseClicked(e -> {
			if (MouseButton.PRIMARY == e.getButton())
				setFree(JpgToTile("EmptyFree.jpg"));
		});
		
	}

	
	public int getLocation() {
		return location;
	}


	public void setLocation(int location) {
		this.location = location;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getSpec() {
		return spec;
	}


	public void setSpec(String spec) {
		this.spec = spec;
	}


	private void setFree(ImageView pic) {

		setMinSize(0, 0);
		pic.fitWidthProperty().bind(widthProperty()); // image size binded to the button
		pic.fitHeightProperty().bind(heightProperty());
		getChildren().add(pic);
		

	}
	
	Image curved00 = new Image(new File("res/Curved00.jpg").toURI().toString());
	Image curved01 = new Image(new File("res/Curved01.jpg").toURI().toString());
	Image curved10 = new Image(new File("res/Curved10.jpg").toURI().toString());
	Image empty = new Image(new File("res/Empty.jpg").toURI().toString());
	Image endHorizontal = new Image(new File("res/EndHorizontal.jpg").toURI().toString());
	Image endVertical = new Image(new File("res/EndVertical.jpg").toURI().toString());
	Image freeTile = new Image(new File("res/FreeTile.jpg").toURI().toString());
	Image pipeHorizontal = new Image(new File("res/PipeHorizontal.jpg").toURI().toString());
	Image pipeStaticHorizontal = new Image(new File("res/PipeStaticHorizontal.jpg").toURI().toString());
	Image pipeVertical = new Image(new File("res/PipeVertical.jpg").toURI().toString());
	Image starterHorizontal = new Image(new File("res/starterHorizontal.jpg").toURI().toString());
	Image starterVertical = new Image(new File("res/starterVertical.jpg").toURI().toString());

	private ImageView JpgToTile(String jpgFile) {
		//File file = new File("/home/ev/git/midtermalternate/MidTermAlternate/src/Images/"+jpgfile);
		
		ImageView iv = new ImageView(jpgFile);
		return iv;
	}

	
	



}