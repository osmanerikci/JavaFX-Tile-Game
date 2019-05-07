import java.io.File;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends StackPane {

	public Tile() {

		
		
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

	
	private void setFree(ImageView pic) {

		setMinSize(0, 0);
		pic.fitWidthProperty().bind(widthProperty()); // image size binded to the button
		pic.fitHeightProperty().bind(heightProperty());
		getChildren().add(pic);
		

	}
	private ImageView JpgToTile(String jpgfile) {
		//File file = new File("/home/ev/git/midtermalternate/MidTermAlternate/src/Images/"+jpgfile);
		
		Image freeTile = new Image(new File("res/FreeTile.jpg").toURI().toString());
		ImageView iv = new ImageView(freeTile);
		return iv;
	}

}