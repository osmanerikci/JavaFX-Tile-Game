package mainPackage;
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

	

	public  Tile[] ReaderFile() throws FileNotFoundException {
		input = new Scanner(new File("Files/" + getLevelname() + ".txt"));
		input.useDelimiter(",|\n\\s*");

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