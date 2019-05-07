import java.io.File;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MotherBorard extends Application {
	Stage window;

	private Parent createContent() {
		Pane pane = new Pane();
		pane.setPrefSize(400, 400);
		// Create tiles
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				Tile tile = new Tile();
				tile.setTranslateX(j * 100);
				tile.setTranslateY(i * 100);

				// Add tiles to pane
				pane.getChildren().addAll(tile);

			}
		}

		return pane;
	}

	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setScene(new Scene(createContent()));
		window.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}

class Tile extends StackPane {

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
		File file = new File("/home/ev/git/midtermalternate/MidTermAlternate/src/Images/"+jpgfile);
		Image image = new Image(file.toURI().toString());
		ImageView iv = new ImageView(image);
		return iv;
	}

}

class Level extends StackPane {
public Level() {
}
}