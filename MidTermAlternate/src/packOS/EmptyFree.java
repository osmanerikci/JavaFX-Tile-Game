package packOS;

public class EmptyFree extends Tile {

	public EmptyFree(int id, String type, String spec) {
		super(id, type, spec);
		setImage(JpgToTile("EmptyFree"));
	}

}
