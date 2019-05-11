package mainPackage;
import java.io.File;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends StackPane {
	private int row;
	private int column;

	private int tileId;
	private String type;
	private String spec;

	
	public Tile(int id, String type, String spec) {
		
	//	setImage(JpgToTile("EndHorizontal"));
		idToLocation(id);
		setType(type);
		setSpec(spec);
	
		Rectangle border = new Rectangle(100, 100);
		border.setFill(null);
		border.setStroke(Color.BLACK);
		setAlignment(Pos.CENTER);
		getChildren().addAll(border);
		
		
	
	}

	protected void setImage(ImageView pic) {

		setMinSize(0, 0);
		pic.fitWidthProperty().bind(widthProperty()); // image size binded to the button
		pic.fitHeightProperty().bind(heightProperty());
		getChildren().add(pic);

	}

/*	Image Pipe00 = new Image(new File("res/Pipe00.jpg").toURI().toString());
	Image Pipe01 = new Image(new File("res/Pipe01.jpg").toURI().toString());
	Image Pipe10 = new Image(new File("res/Pipe10.jpg").toURI().toString());
	Image Pipe11 = new Image(new File("res/Pipe11.jpg").toURI().toString());
	Image Emptynone = new Image(new File("res/Emptynone.jpg").toURI().toString());
	Image EmptyFree = new Image(new File("res/EmptyFree.jpg").toURI().toString());
	Image EndHorizontal = new Image(new File("res/EndHorizontal.jpg").toURI().toString());
	Image EndVertical = new Image(new File("res/EndVertical.jpg").toURI().toString());
	Image PipeHorizontal = new Image(new File("res/PipeHorizontal.jpg").toURI().toString());
	Image PipeVertical = new Image(new File("res/PipeVertical.jpg").toURI().toString());
	Image PipeStaticHorizontal = new Image(new File("res/PipeStaticHorizontal.jpg").toURI().toString());
	Image PipeStaticVertical = new Image(new File("res/PipeStaticVertical.jpg").toURI().toString());
	Image StarterHorizontal = new Image(new File("res/StarterHorizontal.jpg").toURI().toString());
	Image StarterVertical = new Image(new File("res/StarterVertical.jpg").toURI().toString());
*/
	protected ImageView JpgToTile(String image) {
		
		
		ImageView iv = new ImageView(new Image(new File("res/"+image+".jpg").toURI().toString()));
		return iv;
	}

	private void idToLocation(int id) {
		// return cell[id/4][id%4];

		if (id % 4 != 0) {

			setRow(id / 4);
			;
			setColumn(id % 4 - 1);
		} else if (id % 4 == 0) {
			setRow(id / 4 - 1);
			setColumn(3);
		}
		// System.out.println(id+" "+ row+" "+column+"\n\n");
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

	public void setColumn(int column) {
		this.column = column;
	}

	public int getTileId() {
		return tileId;
	}

	public void setTileId(int tileId) {
		this.tileId = tileId;
	}

}