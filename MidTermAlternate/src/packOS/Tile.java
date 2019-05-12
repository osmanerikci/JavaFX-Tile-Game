package packOS;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
//Tile class creates StackPanes they have id(between1-16),type and spec'ification values. 
//It is to easy create tiles and get their images with a string contains type+spec".jpg"

public class Tile extends StackPane {
	private int row;
	private int column;

	private int tileId;
	private String type;
	private String spec;


	public Tile(int id, String type, String spec) {
		
		idToLocation(id);
		setType(type);
		setSpec(spec);	
		setAlignment(Pos.CENTER);
		
		
	
	}
//This method adds a ImageView object to tile and fits size properties.
	protected void setImage(ImageView pic) {

		setMinSize(0, 0);
		pic.fitWidthProperty().bind(widthProperty()); // image size binded to the button
		pic.fitHeightProperty().bind(heightProperty());
		getChildren().add(pic);

	}
	

	//idToLocation sets row and column values according to id number.
	//It works between 0-16 at least. Tiles are placed to GridPane by row and column values.
	private void idToLocation(int id) {
		// return cell[id/4][id%4];

		if (id % 4 != 0) {

			setRow(id / 4);
			setColumn(id % 4 - 1);
			
		} 
		else if (id % 4 == 0) {
			
			setRow(id / 4 - 1);
			setColumn(3);
		}
	}

	
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int d) {
		this.column = d;
	}

	public int getTileId() {
		return tileId;
	}

	public void setTileId(int tileId) {
		this.tileId = tileId;
	}



}