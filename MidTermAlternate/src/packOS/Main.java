package packOS;

import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;

import com.sun.corba.se.pept.transport.Acceptor;
import com.sun.corba.se.pept.transport.Connection;
import com.sun.corba.se.pept.transport.EventHandler;
import com.sun.corba.se.spi.orbutil.threadpool.Work;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application implements EventHandler {
	Stage window;
	Scene scene;
	static GridPane pane;
	private int column;
    private int row;
	public void start(Stage primaryStage) throws Exception {
		Level level1 = new Level("level5");
		
		window = primaryStage;
		window.setTitle(level1.getLevelname());
		GridPane pane = CreatePane(level1.ReaderFile());
		window.setScene(new Scene(pane));
		palcingImageToStage();
		window.show();

	}

	public static GridPane CreatePane(Tile[] tiles) {

		pane = new GridPane();
		pane.setPrefSize(400, 400);
		for (Tile tile : tiles) {
			tile.setTranslateX(tile.getColumn() * 100);
			tile.setTranslateY(tile.getRow() * 100);
			Rectangle border = new Rectangle(100, 100);
			
			border.setFill(null);
			border.setStroke(Color.BLACK);
			border.setStrokeWidth(3);
			border.setTranslateX(tile.getColumn()* 100);
			border.setTranslateY(tile.getRow()* 100);
			

	//		newTile.getChildren().addAll(border);
			pane.getChildren().addAll(tile,border);
			System.out.println(tile.getRow() + " " + tile.getColumn() + " " + tile.getType() + tile.getSpec());
	       

		}
		return pane;
	}


    public void palcingImageToStage() throws IOException{  
        for (int i = 0; i <=  HandleOsman.listOfImagesForPuzzle().size()-1; i++){
            column = i;
            row = 0;

            if (column >= 3) {
                row = 1;
                column = i - 3;
            }
            if (column >= 3){
                row = 2;
                column = i - 6;
            }          
            pane.add((Node)HandleOsman.listOfImagesForPuzzle().get(i), column, row);
        }
    }
	public static void main(String[] args) throws IOException {

		launch(args);
	}
	
	

	
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
}
