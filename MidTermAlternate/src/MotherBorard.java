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



class Level extends StackPane {
public Level() {
}
}