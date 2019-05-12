package packOS;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;

public class HandleOsman extends Main {

	public static Dragboard db;
    public static ClipboardContent clipboard, cb;
    
    
    public static String[] path(){
        String[] path = new String[10];       
        for (int i = 1; i < path.length; i++){
            path[i] = "puzzle/resource/0"+i+".jpg";
        }
        return path;
    }
    
    public static ArrayList<ImageView> listOfImagesForPuzzle() throws IOException{
            Level level1 = new Level("level5");   		
            Tile[] tileList =  level1.ReaderFile();
            ArrayList<ImageView> imageView = new ArrayList<>();
        for (int i = 1; i < tileList.length; i++){
            imageView.add(JpgToTile(tileList[i].getType()+tileList[i].getSpec()+""));           
        }
        
        for (int i = 0; i < imageView.size(); i++){
            ImageView source = (ImageView)imageView.get(i);
            ImageView target = (ImageView)imageView.get(i);
            
                source.setOnDragDetected((MouseEvent event) -> {
                    db = source.startDragAndDrop(TransferMode.MOVE);
                    clipboard = new ClipboardContent();
                    clipboard.putImage(source.getImage());
                    db.setContent(clipboard);
                    
                    event.consume();
                });
                
                target.setOnDragOver((DragEvent event) -> {
                    if (event.getGestureSource() != target 
                            && event.getDragboard().hasImage()){
                        event.acceptTransferModes(TransferMode.MOVE);
                    }
                    event.consume();
                });
                
                target.setOnDragEntered((DragEvent event) -> {
                    if (event.getGestureSource() != target 
                            && event.getDragboard().hasImage()){
                        target.setStyle("-fx-effect: innershadow(gaussian, #00a8ff, 40, 0.5, 0, 0)");
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
                    
                    boolean suces = false;
                    if (db.hasImage()){
                        target.setImage(db.getImage());
                        
                        suces = true;
                    }
                    event.setDropCompleted(suces);
                    event.consume();
                });
                
                source.setOnDragDone((DragEvent event) -> {
                    if (event.getTransferMode() == TransferMode.MOVE)
                    source.setImage(cb.getImage());
                });
        }
        
        return imageView; 
    }
    private static ImageView JpgToTile(String image) {
    	
    	
    	ImageView iv = new ImageView(new Image(new File("res/"+image+".jpg").toURI().toString()));
    	return iv;
    }


}

