package mainPackage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class Main extends Application {
	Stage window;



	public void start(Stage primaryStage) throws Exception {

		
		window = primaryStage;
		Level level1 = new Level("level5");
		window.setScene(new Scene(CreatePane(level1.ReaderFile())));
		window.show();
		
		
	}
	public static Pane CreatePane(Tile[] tiles) {

		Pane pane = new Pane();
		pane.setPrefSize(400, 400);
		for (Tile tile : tiles) {
			tile.setTranslateX(tile.getColumn() * 100);
			tile.setTranslateY(tile.getRow() * 100);
			pane.getChildren().addAll(tile);
			System.out.println(tile.getRow()+" "+tile.getColumn()+" "+tile.getType()+tile.getSpec());
		}
		return pane;
	}

	public static void main(String[] args) {
		launch(args);
	}
}



