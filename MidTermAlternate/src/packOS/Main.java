//OSMAN ERİKCİ 150117038
//ERDEM AÇILDI 
//This JavaFX program is supposed to be a puzzle game on a 4x4 tile board 
//which tiles moves only via mouseDragEvent. If the tile road is okay for the bounce ball 
//should go its way end finish the level.

package packOS;

import java.io.File;
import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;

import com.sun.corba.se.pept.transport.Acceptor;
import com.sun.corba.se.pept.transport.Connection;
import com.sun.corba.se.pept.transport.EventHandler;
import com.sun.corba.se.spi.orbutil.threadpool.Work;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
/*The main class has the vital variables and JavaFX elements. 
 * 
 *  */
public class Main extends Application implements EventHandler {
	Stage window;
	Scene scene1;

	static GridPane pane;
	private int column;
	private int row;
	static Tile[] tileArray1;
	static Tile[] tileArray2;
	static Tile[] tileArray3;
	static Tile[] tileArray4;
	static Tile[] tileArray5;

	int levelNotifier = 1;
//In start method levels,pane, scene,stage and button click actions are implemented.
	public void start(Stage primaryStage) throws Exception {

		Level level1 = new Level("level1");
		Level level2 = new Level("level2");
		Level level3 = new Level("level3");
		Level level4 = new Level("level4");
		Level level5 = new Level("level5");
		tileArray1 = level1.ReaderFile();
		tileArray2 = level2.ReaderFile();
		tileArray3 = level3.ReaderFile();
		tileArray4 = level4.ReaderFile();
		tileArray5 = level5.ReaderFile();

		window = primaryStage;
		window.setTitle("TileSTRUGGLE");

		pane = new GridPane();
		pane.setPrefSize(400, 400);

		Button firstButton = new Button("1st Level");
		Button secondButton = new Button("2nd Level");
		Button thirdButton = new Button("3rd Level");
		Button fourthButton = new Button("4th Level");
		Button fifthButton = new Button("5th Level");

		pane.add(firstButton, 0, 4);
		pane.add(secondButton, 1, 4);
		pane.add(thirdButton, 2, 4);
		pane.add(fourthButton, 3, 4);
		pane.add(fifthButton, 2, 5);

		firstButton.setOnAction(e -> {
			try {
				placingImageToStage(tileArray1);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		});
		secondButton.setOnAction(e -> {
			try {
				placingImageToStage(tileArray2);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		});
		thirdButton.setOnAction(e -> {
			try {
				placingImageToStage(tileArray3);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		});

		fourthButton.setOnAction(e -> {
			try {
				placingImageToStage(tileArray4);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		});
		fifthButton.setOnAction(e -> {
			try {
				placingImageToStage(tileArray5);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		});

		placingImageToStage(tileArray1);

		scene1 = new Scene(pane);
		window.setScene(scene1);

		window.show();

	}
//The placingImageToStage method takes tileArray
//and decides row and column according to tileArray's index number.
	public void placingImageToStage(Tile[] tileArray) throws IOException {
		for (int i = 0; i < HandlerIV.listOfImagesForPuzzle(tileArray).size(); i++) {
			int id = i + 1;
			column = i;
			row = 0;

			if (id % 4 != 0) {

				row = (id / 4);

				column = (id % 4 - 1);
			} else if (id % 4 == 0 && id >= 4) {
				row = (id / 4 - 1);
				column = (3);
			} else if (id % 4 == 0 && id == 0) {

			}

			Rectangle border = new Rectangle(100, 100);
			border.setFill(null);
			border.setStroke(Color.BLACK);
			border.setStrokeWidth(3);
			HandlerIV.listOfImagesForPuzzle(tileArray).get(i).fitHeightProperty();
			pane.add(HandlerIV.listOfImagesForPuzzle(tileArray).get(i), column, row);
			pane.add(border, column, row);
			pane.setAlignment(Pos.CENTER);
		}
	}

	public static void main(String[] args) throws IOException {

		launch(args);
	}
//These methods are below are not used myself.
//They've come with implementing EventHandler and IDE shows error if I delete them.
	@Override
	public void setUseSelectThreadToWait(boolean x) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean shouldUseSelectThreadToWait() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SelectableChannel getChannel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getInterestOps() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setSelectionKey(SelectionKey selectionKey) {
		// TODO Auto-generated method stub

	}

	@Override
	public SelectionKey getSelectionKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void handleEvent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setUseWorkerThreadForEvent(boolean x) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean shouldUseWorkerThreadForEvent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setWork(Work work) {
		// TODO Auto-generated method stub

	}

	@Override
	public Work getWork() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Acceptor getAcceptor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}
//JpgToFile method is a simple ImageView creation method 
//that takes string name of saved image and returns ImageView
	static ImageView JpgToTile(String image) {

		ImageView iv = new ImageView(new Image(new File("res/" + image + ".jpg").toURI().toString()));
		return iv;
	}
}
//The reason of I've seperated HandlerIV is more clean read :)) 
//The HandlerIV has ArrayList<ImageView> listOfImagesForPuzzle method takes tileArray -which's product of Level creation- and 
//creates path array to store image files int first for loop.
//Second for loop is to store  temporary and proccess the exchange of mouse dragged tiles' imageviews .
// We got inspired for this methodology from github repository @Loborg and modified for this game's purposes and machanisms.
class HandlerIV extends Main {

	public static Dragboard db;
	public static ClipboardContent clipboard, cb;

	public static String[] path(Tile[] tileArray) {
		String[] path = new String[tileArray.length];
		for (int i = 0; i < path.length; i++) {
			path[i] = "res/" + tileArray[i].getType() + tileArray[i].getSpec() + ".jpg";
		}
		return path;
	}

	public static ArrayList<ImageView> listOfImagesForPuzzle(Tile[] tileArray) throws IOException {
		String[] path = path(tileArray);
		ArrayList<ImageView> imageView = new ArrayList<>();
		for (int i = 0; i < path.length; i++) {
			ImageView iv = new ImageView(path[i]);
			iv.setFitWidth(100);
			;
			iv.setFitHeight(100);
			imageView.add(iv);
		}

		for (int i = 0; i < imageView.size(); i++) {
			ImageView source = (ImageView) imageView.get(i);
			ImageView target = (ImageView) imageView.get(i);

			source.setOnDragDetected((MouseEvent event) -> {
				db = source.startDragAndDrop(TransferMode.MOVE);
				clipboard = new ClipboardContent();
				clipboard.putImage(source.getImage());
				db.setContent(clipboard);

				event.consume();
			});

			target.setOnDragOver((DragEvent event) -> {
				if (event.getGestureSource() != target && event.getDragboard().hasImage()) {
					event.acceptTransferModes(TransferMode.MOVE);
				}
				event.consume();
			});

			target.setOnDragEntered((DragEvent event) -> {
				if (event.getGestureSource() != target && event.getDragboard().hasImage()) {
				}
				event.consume();
			});

			target.setOnDragExited((DragEvent event) -> {
				target.setStyle("");

				event.consume();
			});

			target.setOnDragDropped((DragEvent event) -> {
				cb = new ClipboardContent();
				cb.putImage(target.getImage());

				boolean success = false;
				if (db.hasImage()) {
					target.setImage(db.getImage());

					success = true;
				}
				event.setDropCompleted(success);
				event.consume();
			});

			source.setOnDragDone((DragEvent event) -> {
				if (event.getTransferMode() == TransferMode.MOVE)
					source.setImage(cb.getImage());
			});
		}

		return imageView;
	}

}
