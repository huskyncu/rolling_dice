package fp;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.util.ResourceBundle;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class Fp3 implements Initializable{
	@FXML
    private MediaView ghost;
	static MediaPlayer player_dice;
	static MediaPlayer foot;
//	static MediaPlayer shout;
	public void initialize(URL url, ResourceBundle rb) {
		try {
			foot = new MediaPlayer(
					new Media(FileSystems.getDefault().getPath("pic", "gift.mp3").toUri().toURL().toString()));
			foot.setCycleCount(-1);
			foot.play();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			};
			PauseTransition pause = new PauseTransition(Duration.seconds(3));
			pause.setOnFinished(evt -> {			
				foot.stop();
//				try {
//					shout = new MediaPlayer(
//							new Media(FileSystems.getDefault().getPath("src", "fp", "ghost.mp3").toUri().toURL().toString()));
//					
//					shout.play();
//				} catch (MalformedURLException e) {
//					e.printStackTrace();
//				};
				try {
					player_dice = new MediaPlayer(
							new Media(FileSystems.getDefault().getPath("pic", "ghostv.mp4").toUri().toURL().toString()));
					ghost.setMediaPlayer(player_dice);
					player_dice.play();
				} catch (MalformedURLException e) {
					e.printStackTrace();
				};		
				PauseTransition pause2 = new PauseTransition(Duration.seconds(2));
				pause2.setOnFinished(evt2 -> {
					FP.currentStage.close();}
				);
				pause2.play();
			});
			pause.play();
	}
}
