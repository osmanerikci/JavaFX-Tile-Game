import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.scene.Parent;
import javafx.scene.layout.Pane;

public class Level {
	private static Scanner input;

public Level(String levelname) throws FileNotFoundException {
	input = new Scanner(new File("Files/"+levelname+".txt"));
	input.useDelimiter(",|\n");

	Tile[] tiles = new Tile[0];
	while (input.hasNext()) {
		int location = input.nextInt();
		String type = input.next();
		String specs = input.next();
		

		Tile newTile = new Tile(location, type, specs);
		tiles = addTile(tiles, newTile);
	}

	for (Tile tile : tiles) {
		System.out.println(tile);
	}
}



private static Tile[] addTile(Tile[] tiles, Tile tileToAdd) {
	Tile[] newTiles = new Tile[tiles.length + 1];
	System.arraycopy(tiles, 0, newTiles, 0, tiles.length);
	newTiles[newTiles.length - 1] = tileToAdd;

	return newTiles;
}

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

}
