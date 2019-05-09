package sample;
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

		idToLocation(id);
		setType(type);
		setSpec(spec);

		Rectangle border = new Rectangle(100, 100);
		border.setFill(null);
		border.setStroke(Color.BLACK);
		setAlignment(Pos.CENTER);
		getChildren().addAll(border);
		setImage(JpgToTile(type));

	/*	setOnMouseClicked(e -> {
			if (MouseButton.PRIMARY == e.getButton())
				setImage(JpgToTile("EmptyFree.jpg"));
		});
		*/

	}

	private void setImage(ImageView pic) {

		setMinSize(0, 0);
		pic.fitWidthProperty().bind(widthProperty()); // image size binded to the button
		pic.fitHeightProperty().bind(heightProperty());
		getChildren().add(pic);

	}

	Image curved00 = new Image(new File("res/Curved00.jpg").toURI().toString());
	Image curved01 = new Image(new File("res/Curved01.jpg").toURI().toString());
	Image curved10 = new Image(new File("res/Curved10.jpg").toURI().toString());
	Image curved11 = new Image(new File("res/Curved11.jpg").toURI().toString());
	Image empty = new Image(new File("res/Empty.jpg").toURI().toString());
	Image emptyFree = new Image(new File("res/Empty.jpg").toURI().toString());
	Image endHorizontal = new Image(new File("res/EndHorizontal.jpg").toURI().toString());
	Image endVertical = new Image(new File("res/EndVertical.jpg").toURI().toString());
	Image freeTile = new Image(new File("res/FreeTile.jpg").toURI().toString());
	Image pipeHorizontal = new Image(new File("res/PipeHorizontal.jpg").toURI().toString());
	Image pipeStaticHorizontal = new Image(new File("res/PipeStaticHorizontal.jpg").toURI().toString());
	Image pipeVertical = new Image(new File("res/PipeVertical.jpg").toURI().toString());
	Image starterHorizontal = new Image(new File("res/StarterHorizontal.jpg").toURI().toString());
	Image starterVertical = new Image(new File("res/StarterVertical.jpg").toURI().toString());

	private ImageView JpgToTile(String jpgFile) {
		// File file = new
		// File("/home/ev/git/midtermalternate/MidTermAlternate/src/Images/"+jpgfile);

		ImageView iv = new ImageView("" + jpgFile);
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