import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
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
		Level("level1");
	}

	public static void main(String[] args) {
		launch(args);
	}
}



