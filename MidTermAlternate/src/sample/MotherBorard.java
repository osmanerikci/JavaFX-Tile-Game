package sample;
import java.io.FileReader;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Level;
public class MotherBorard extends Application {
	Stage window;

/*	private Parent createContent() {
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
	}*/

	public void start(Stage primaryStage) throws Exception {
		Level level1 = new Level("level1");
		
		window = primaryStage;
		window.setScene(new Scene(ReaderFil));
		window.show();
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}



