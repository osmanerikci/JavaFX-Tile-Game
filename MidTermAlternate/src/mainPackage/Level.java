package mainPackage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Level {
	private static Scanner input;
	private String levelname;
	String line;
	public Level(String levelname) throws IOException{
		setLevelname(levelname);
	}

	

	public  Tile[] ReaderFile() throws IOException {
		input = new Scanner(new File("Files/" + getLevelname() + ".txt"));	
    	input.useDelimiter(",|\n\\s*");

		Tile[] tiles = new Tile[0];
		
		while (input.hasNext()) {
		    	int id = input.nextInt();
				String type = input.next();
				String spec = input.next();
				String unique = ""+type+spec;
				System.out.println(unique+" ERROR1");
				if(unique.equalsIgnoreCase("StarterVertical")) {
					StarterVertical newTile = new StarterVertical(id, type, spec);
					tiles = addTile(tiles, newTile);

				}
				if(unique.equalsIgnoreCase("StarterHorizontal")) {
					StarterHorizontal newTile = new StarterHorizontal(id, type, spec);
					tiles = addTile(tiles, newTile);

				}
				else if(unique.equalsIgnoreCase("EndVertical")) {
					EndVertical newTile = new EndVertical(id, type, spec);
					tiles = addTile(tiles, newTile);

				}
				else if(unique.equalsIgnoreCase("EndHorizontal")) {
					EndHorizontal newTile = new EndHorizontal(id, type, spec);
					tiles = addTile(tiles, newTile);

				}
				else if(unique.equalsIgnoreCase("Emptynone")) {
					Emptynone newTile = new Emptynone(id, type, spec);
					tiles = addTile(tiles, newTile);

				}
				else if(unique.equalsIgnoreCase("EmptyFree")) {
					EmptyFree newTile = new EmptyFree(id, type, spec);
					tiles = addTile(tiles, newTile);

				}
				else if(unique.equalsIgnoreCase("PipeStaticVertical")) {
					PipeStaticVertical newTile = new PipeStaticVertical(id, type, spec);
					tiles = addTile(tiles, newTile);

				}
				else if(unique.equalsIgnoreCase("PipeStaticHorizontal")) {
					PipeStaticHorizontal newTile = new PipeStaticHorizontal(id, type, spec);
					tiles = addTile(tiles, newTile);

				}
				else if(unique.equalsIgnoreCase("PipeVertical")) {
					PipeVertical newTile = new PipeVertical(id, type, spec);
					tiles = addTile(tiles, newTile);

				}
				else if(unique.equalsIgnoreCase("PipeHorizontal")) {
					PipeHorizontal newTile = new PipeHorizontal(id, type, spec);
					tiles = addTile(tiles, newTile);

				}
				else if(unique.equalsIgnoreCase("Pipe00")) {
					Pipe00 newTile = new Pipe00(id, type, spec);
					tiles = addTile(tiles, newTile);

				}
				else if(unique.equalsIgnoreCase("Pipe01")) {
					Pipe01 newTile = new Pipe01(id, type, spec);
					tiles = addTile(tiles, newTile);

				}
				else if(unique.equalsIgnoreCase("Pip10")) {
					Pipe10 newTile = new Pipe10(id, type, spec);
					tiles = addTile(tiles, newTile);

				}
				else if(unique.equalsIgnoreCase("Pipe11")) {
					Pipe11 newTile = new Pipe11(id, type, spec);
					tiles = addTile(tiles, newTile);

				}
				else {
					System.out.println(type+spec+" ERROR2");
				}
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