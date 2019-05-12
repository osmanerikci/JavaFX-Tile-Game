package packOS;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
//Level class creates level objects and creates arrays that stores all basic information of tiles of a level. 
//All program is running and creating by those Tile[] arrays and its elements as tiles.
public class Level {

	private static Scanner input;
	private String levelname;
	String line;

	public Level(String levelname) throws IOException {
		setLevelname(levelname);
	}
	//ReaderFile method takes level txt file ,reads line by line, and creates tile array read info.
	//ATTENTION: The input txt files has caused an error, that was while reading files "useDelimiter" method wasn't working properly.
	//I accidently discovered deleting "Enter sign"(\n) at first of every line and again enter "Enter" solved problem. 
	//But We've lost a few days because of that error.
	public Tile[] ReaderFile() throws IOException {
		input = new Scanner(new File("Files/" + getLevelname() + ".txt"));
		input.useDelimiter(",|\n\\s*");

		Tile[] tiles = new Tile[0];

		while (input.hasNext()) {

			int id = input.nextInt();
			String type = input.next();
			String spec = input.next();
			Tile newTile = new Tile(id, type, spec);
			tiles = addTile(tiles, newTile);

		}

		return tiles;
	}
//addTile is a method add tile element to end of the tileArray actually used instead of ArrayList.
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