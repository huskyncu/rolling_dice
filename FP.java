package fp;
import java.net.MalformedURLException;
import java.nio.file.FileSystems;


import javafx.application.*;
import javafx.fxml.*;
import javafx.geometry.Rectangle2D;
import javafx.scene.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.*;

public class FP extends Application{
	public static Stage currentStage;
	public static Scene menuScene;
	static MediaPlayer player1;
	static MediaPlayer player2;
	@Override	
	public void start(Stage stage) throws Exception{
		currentStage=stage;
		Parent root=FXMLLoader.load(getClass().getResource("fp2.fxml"));
		menuScene=new Scene(root);
		currentStage.setScene(menuScene);
		currentStage.setTitle("澳門線上賭場");
		currentStage.setResizable(false);
		currentStage.show();  
		Rectangle2D primScreenBounds=Screen.getPrimary().getVisualBounds();
		currentStage.setX((primScreenBounds.getWidth()-currentStage.getWidth())/2);
		currentStage.setY((primScreenBounds.getHeight()-currentStage.getHeight())/2);
		
//		Parent root2=FXMLLoader.load(getClass().getResource("fp2.fxml"));
//		Scene scene2=new Scene(root2);
//		var stage2=new Stage();
//		stage2.setScene(scene2);
//		stage2.setTitle("遊戲規則");
//		stage2.show();

	}
	public static void main(String[] args) throws MalformedURLException {		
//			System.out.println(FileSystems.getDefault().getPath("pic/rule.mp3"));
			player1 = new MediaPlayer(new Media(FileSystems.getDefault().getPath("pic/rule.mp3").toUri().toURL().toString()));
			player1.setCycleCount(-1);
			player1.play();
		
		launch(args);
	}

}
