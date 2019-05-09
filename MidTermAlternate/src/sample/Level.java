package sample;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javafx.scene.layout.Pane;

public class Level {
	private static Scanner input;
	private String levelname;

	public Level(String levelname) throws IOException{
		setLevelname(levelname);
	}

	public static Pane CreatePane(Tile[] tiles) {

		/*
		 * Pane pane = new Pane(); pane.setPrefSize(400, 400); // Create tiles for (int
		 * i = 0; i < 4; i++) { for (int j = 0; j < 4; j++) { Tile tile = new Tile();
		 * tile.setTranslateX(j * 100); tile.setTranslateY(i * 100);
		 * 
		 * // Add tiles to pane pane.getChildren().addAll(tile);
		 * 
		 * } }
		 * 
		 * return pane;
		 */
		Pane pane = new Pane();
		pane.setPrefSize(400, 400);
		for (Tile tile : tiles) {
			tile.setTranslateX(tile.getRow() * 100);
			tile.setTranslateY(tile.getColumn() * 100);
			pane.getChildren().addAll(tile);
		}
		return pane;
	}

	public  Tile[] ReaderFile() throws FileNotFoundException {
		input = new Scanner(new File("Files/" + getLevelname() + ".txt"));
		input.useDelimiter(",|\n");

		Tile[] tiles = new Tile[0];
		while (input.hasNext()) {
			int id = input.nextInt();
			String type = input.next();
			String specs = input.next();

			Tile newTile = new Tile(id, type, specs);
			tiles = addTile(tiles, newTile);
		}

		return tiles;
	}

	private static Tile[] addTile(Tile[] tiles, Tile tileToAdd) {
		Tile[] newTiles = new Tile[tiles.length + 1];
		System.arraycopy(tiles, 0, newTiles, 0, tiles.length);
		newTiles[newTiles.length - 1] = tileToAdd;

		return newTiles;
	}

	public String getLevelname() {
		return levelname;
	}

	public void setLevelname(String levelname) {
		this.levelname = levelname;
	}

}