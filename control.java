package fp;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.util.Arrays;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.scene.input.*;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Screen;
import javafx.util.Duration;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class control implements Initializable {

	@FXML
	private Button dice;

	@FXML
	void act(ActionEvent event) {
		dice1.setImage(null);
		dice2.setImage(null);
		dice3.setImage(null);
		if (M == 0) {
    		try {
    			enter= new MediaPlayer(new Media(FileSystems.getDefault().getPath("pic","enter.m4a").toUri().toURL().toString()));
    			enter.play();
    		} catch (MalformedURLException e) {
    			
    			e.printStackTrace();
    		};
			screen.setText("下注拉");
			return;
		}
		screen.clear();
		cMoney.setText(String.valueOf(p1.getm()));
		yMoney.setText(String.valueOf(p2.getm()));
		if (turn == true) {
			cPoint.clear();
			yPoint.clear();

		}
		dg1.setVisible(true);
		dg2.setVisible(true);
		dg3.setVisible(true);
		try {
			dicesound = new MediaPlayer(new Media(
					FileSystems.getDefault().getPath("pic", "dice.mp3").toUri().toURL().toString()));
			dicesound.play();
		} catch (MalformedURLException e) {

			e.printStackTrace();
		};
		
		PauseTransition pause = new PauseTransition(Duration.seconds(1));
		pause.setOnFinished(evt -> {
			dice(M, p1, p2);
			
			if (p1.getm() <= 0 || p2.getm() <= 0) {
				
				endpane.setVisible(true);
				FP.player2.stop();
				if (p1.getm() <= 0) {
					try {
		    			pw2= new MediaPlayer(new Media(FileSystems.getDefault().getPath("pic","pw2.m4a").toUri().toURL().toString()));
		    			pw2.play();
		    		} catch (MalformedURLException e) {
		    			
		    			e.printStackTrace();
		    		};
					endtext.setText(p2.getn() + "獲勝!");
				} else {
					try {
		    			pl2= new MediaPlayer(new Media(FileSystems.getDefault().getPath("pic","cw2.m4a").toUri().toURL().toString()));
		    			pl2.play();
		    		} catch (MalformedURLException e) {
		    			
		    			e.printStackTrace();
		    		};
					endtext.setText("電腦獲勝!");
				}

			}
			if(gif.isVisible()==true || gif2.isVisible()==true) {
				PauseTransition pause2 = new PauseTransition(Duration.seconds(2));
				pause2.setOnFinished(evt2 -> {
					gif.setVisible(false);
					gif2.setVisible(false);}
				);
				pause2.play();
			}
		});
		pause.play();
		
		
		
		
	}
	@FXML
    private Pane rulep;
	@FXML
	private ImageView dice1;
	@FXML
	private ImageView dice2;

	@FXML
	private ImageView dice3;
	@FXML
	private Pane frame;
	@FXML
	private Button back;

	@FXML
	private TextField yMoney;

	@FXML
	private TextField cMoney;

	@FXML
	private TextField pMoney;

	@FXML
	private TextField cPoint;

	@FXML
	private TextField yPoint;

	@FXML
	private TextArea screen;

	@FXML
	private TextField scan;

	@FXML
	private TextField cb;

	@FXML
	private TextField yb;

	@FXML
	private Pane endpane;

	@FXML
	private TextField endtext;

	@FXML
	private Button againbuttom;

	@FXML
	private Button closebuttom;
	@FXML
	private Button scare;

	@FXML
    private Button see;

	@FXML
    private Button offr;
	@FXML
    private ImageView gif;
	@FXML
    private ImageView gif2;
	@FXML
    private ImageView dg1;

    @FXML
    private ImageView dg2;

    @FXML
    private ImageView dg3;
	@FXML
	void click(MouseEvent event) {
		
		try {
			Click = new MediaPlayer(new Media(
					FileSystems.getDefault().getPath("pic", "Click.mp3").toUri().toURL().toString()));
			Click.play();
		} catch (MalformedURLException e) {

			e.printStackTrace();
		}
		;

	}

	Player p1, p2;

	@FXML
	void key(KeyEvent event) {
		if (event.getCode().equals(KeyCode.ENTER)) {
			dice1.setImage(null);
			dice2.setImage(null);
			dice3.setImage(null);
			try {
				M = Integer.parseInt(scan.getText());
			}
			catch(NumberFormatException ex) {
				if(M>0) {
					screen.setText("按骰拉揍你喔");
					return;
				}
				screen.setText("wtf 會不會下注啦?");
				scan.clear();
				
				try {
					enter2 = new MediaPlayer(new Media(
							FileSystems.getDefault().getPath("pic", "enter2.m4a").toUri().toURL().toString()));
					enter2.play();
				} catch (MalformedURLException e) {

					e.printStackTrace();
				};
				return;
			}
			if (M > p2.getm() || M <= 0) {
				if (M <= 0) {
					screen.setText("wtf 會不會下注啦?");
				} else {
					screen.setText("You don't have\nenough money");
				}
				scan.clear();
				M = 0;
				try {
					enter2 = new MediaPlayer(new Media(
							FileSystems.getDefault().getPath("pic", "enter2.m4a").toUri().toURL().toString()));
					enter2.play();
				} catch (MalformedURLException e) {

					e.printStackTrace();
				};
				return;
			}
			
			pMoney.setText(scan.getText());
			scan.clear();
			scan.setEditable(false);
			screen.clear();
			cMoney.setText(String.valueOf(p1.getm()));
			yMoney.setText(String.valueOf(p2.getm()));
			if (turn == true) {
				cPoint.clear();
				yPoint.clear();

			}
			dg1.setVisible(true);
			dg2.setVisible(true);
			dg3.setVisible(true);
			try {
				dicesound = new MediaPlayer(new Media(
						FileSystems.getDefault().getPath("pic", "dice.mp3").toUri().toURL().toString()));
				dicesound.play();
			} catch (MalformedURLException e) {

				e.printStackTrace();
			};
			PauseTransition pause = new PauseTransition(Duration.seconds(1));
			pause.setOnFinished(evt -> {
				dice(M, p1, p2);
				
				if (p1.getm() <= 0 || p2.getm() <= 0) {
					
					endpane.setVisible(true);
					FP.player2.stop();
					if (p1.getm() <= 0) {
						try {
			    			pw2= new MediaPlayer(new Media(FileSystems.getDefault().getPath("pic","pw2.m4a").toUri().toURL().toString()));
			    			pw2.play();
			    		} catch (MalformedURLException e) {
			    			
			    			e.printStackTrace();
			    		};
						endtext.setText(p2.getn() + "獲勝!");
					} else {
						try {
			    			pl2= new MediaPlayer(new Media(FileSystems.getDefault().getPath("pic","cw2.m4a").toUri().toURL().toString()));
			    			pl2.play();
			    		} catch (MalformedURLException e) {
			    			
			    			e.printStackTrace();
			    		};
						endtext.setText("電腦獲勝!");
					}

				}
				if(gif.isVisible()==true || gif2.isVisible()==true) {
					PauseTransition pause3 = new PauseTransition(Duration.seconds(2));
					pause3.setOnFinished(evt3 -> {
						gif.setVisible(false);
						gif2.setVisible(false);}
							);
					pause3.play();
				}
			}

			);
			pause.play();
			
				
			
		}
	}

	@FXML
	void key_name(KeyEvent event) {
		if (event.getCode().equals(KeyCode.ENTER)) {
			p2.setn(yb.getText());
			yb.setEditable(false);
		}
	}

	void dice(int m, Player p1, Player p2) {
		Random rand = new Random();
		int r1, r2, r3;
		dg1.setVisible(false);
		dg2.setVisible(false);
		dg3.setVisible(false);
		while (true) {
			r1 = rand.nextInt(6) + 1;
			r2 = rand.nextInt(6) + 1;
			r3 = rand.nextInt(6) + 1;
			int[] rr = new int[3];
			rr[0] = r1;
			rr[1] = r2;
			rr[2] = r3;
			showdice(r1, r2, r3);
			Arrays.sort(rr);

			if (r1 == r2 && r2 == r3) {

				if (turn == true) {
					cPoint.setText("豹子!");
					p1.setm(m);
					p2.setm(m * -1);
					cMoney.setText(String.valueOf(p1.getm()));
					yMoney.setText(String.valueOf(p2.getm()));
					screen.setText("電腦贏錢!");
					M = 0;
					pMoney.clear();
					scan.setEditable(true);
					turn = true;
					gif.setVisible(true);
					if (p1.getm() <= 0 || p2.getm() <= 0) {
						break;
					}
					try {
						cb1 = new MediaPlayer(new Media(
								FileSystems.getDefault().getPath("pic", "cb1.m4a").toUri().toURL().toString()));
						cb1.play();
					} catch (MalformedURLException e) {

						e.printStackTrace();
					}
					;
				} else {
					yPoint.setText("豹子!");
					p1.setm(m * -1);
					p2.setm(m);
					screen.setText("玩家贏錢!");
					cMoney.setText(String.valueOf(p1.getm()));
					yMoney.setText(String.valueOf(p2.getm()));
					M = 0;
					pMoney.clear();
					scan.setEditable(true);
					turn = true;
					gif2.setVisible(true);
					if (p1.getm() <= 0 || p2.getm() <= 0) {
						break;
					}
					try {
						pb1 = new MediaPlayer(new Media(
								FileSystems.getDefault().getPath("pic", "pb1.m4a").toUri().toURL().toString()));
						pb1.play();
					} catch (MalformedURLException e) {

						e.printStackTrace();
					}
					;
				}
				
				
				break;
			}

			else if (rr[0] == 4 && rr[1] == 5 && rr[2] == 6) {

				if (turn == true) {
					cPoint.setText("骰規!");
					p1.setm(m);
					p2.setm(m * -1);
					screen.setText("電腦贏錢!");
					gif.setVisible(true);
				} else {
					yPoint.setText("骰規!");
					p1.setm(m * -1);
					p2.setm(m);
					screen.setText("玩家贏錢!");
					gif2.setVisible(true);
				}
				cMoney.setText(String.valueOf(p1.getm()));
				yMoney.setText(String.valueOf(p2.getm()));
				M = 0;
				pMoney.clear();
				scan.setEditable(true);
				turn = true;
				try {
					sg1 = new MediaPlayer(new Media(
							FileSystems.getDefault().getPath("pic", "sg.m4a").toUri().toURL().toString()));
					sg1.play();
				} catch (MalformedURLException e) {

					e.printStackTrace();
				}
				
				break;
			} else if (rr[0] == 1 && rr[1] == 2 && rr[2] == 3) {

				if (turn == true) {
					cPoint.setText("逼機!");
					p1.setm(m * -1);
					p2.setm(m);
					screen.setText("玩家贏錢!");
					cMoney.setText(String.valueOf(p1.getm()));
					yMoney.setText(String.valueOf(p2.getm()));
					M = 0;
					pMoney.clear();
					scan.setEditable(true);
					turn = true;
					gif2.setVisible(true);
					if (p1.getm() <= 0 || p2.getm() <= 0) {
						break;
					}
					try {
						cg1 = new MediaPlayer(new Media(
								FileSystems.getDefault().getPath("pic", "cg1.m4a").toUri().toURL().toString()));
						cg1.play();
					} catch (MalformedURLException e) {

						e.printStackTrace();
					}
					;
				} else {
					yPoint.setText("逼機!");
					p1.setm(m);
					p2.setm(m * -1);
					screen.setText("電腦贏錢!");
					cMoney.setText(String.valueOf(p1.getm()));
					yMoney.setText(String.valueOf(p2.getm()));
					M = 0;
					pMoney.clear();
					scan.setEditable(true);
					turn = true;
					gif.setVisible(true);
					if (p1.getm() <= 0 || p2.getm() <= 0) {
						break;
					}
					try {
						pg1 = new MediaPlayer(new Media(
								FileSystems.getDefault().getPath("pic", "pg1.m4a").toUri().toURL().toString()));
						pg1.play();
					} catch (MalformedURLException e) {

						e.printStackTrace();
					}
					;
				}
				
				
				break;
			} else if (r1 != r2 && r2 != r3 && r1 != r3) {

				if (turn == false) {
					screen.setText("再骰一次!");
					dice.requestFocus();
					break;
				}
				else {
//					PauseTransition pause4 = new PauseTransition(Duration.seconds(1));
//					pause4.setOnFinished(evt -> {
//						System.out.print("o");}
//							);
//					pause4.play();
					continue;
				}
			} else {
				if (turn == true) {

					if (r1 == r2) {
						cdice = r3;
					} else if (r1 == r3) {
						cdice = r2;
					} else {
						cdice = r1;
					}
					cPoint.setText(String.valueOf(cdice));
					screen.setText("換玩家骰!");
					
					turn = false;
					
				} else {

					int ydice;
					if (r1 == r2) {
						ydice = r3;
					} else if (r1 == r3) {
						ydice = r2;
					} else {
						ydice = r1;
					}
					yPoint.setText(String.valueOf(ydice));
					if (ydice > cdice) {
						screen.setText("玩家贏錢!");
						p1.setm(m * -1);
						p2.setm(m);
						cMoney.setText(String.valueOf(p1.getm()));
						yMoney.setText(String.valueOf(p2.getm()));
						gif2.setVisible(true);
						if (p1.getm() <= 0 || p2.getm() <= 0) {
							break;
						}
						try {
							pw1 = new MediaPlayer(new Media(FileSystems.getDefault().getPath("pic", "pw1.m4a")
									.toUri().toURL().toString()));
							pw1.play();
						} catch (MalformedURLException e) {

							e.printStackTrace();
						}
						;
					} else if (ydice < cdice) {
						screen.setText("電腦贏錢!");
						p1.setm(m);
						p2.setm(m * -1);
						cMoney.setText(String.valueOf(p1.getm()));
						yMoney.setText(String.valueOf(p2.getm()));
						gif.setVisible(true);
						if (p1.getm() <= 0 || p2.getm() <= 0) {
							break;
						}
						try {
							pl1 = new MediaPlayer(new Media(FileSystems.getDefault().getPath("pic", "pl2.m4a")
									.toUri().toURL().toString()));
							pl1.play();
						} catch (MalformedURLException e) {

							e.printStackTrace();
						}
						;
					} else {
						screen.setText("平手!");
						try {
							same = new MediaPlayer(new Media(FileSystems.getDefault().getPath("pic", "same.m4a")
									.toUri().toURL().toString()));
							same.play();
						} catch (MalformedURLException e) {

							e.printStackTrace();
						}
						;
					}
					turn = true;
					M = 0;
					scan.setEditable(true);
					pMoney.clear();
					
					
				}
			}
			break;
		}
	}

	void showdice(int s1, int s2, int s3) {
		switch (s1) {
		case 1:
			Image image1;
			try {
				image1 = new Image(
						FileSystems.getDefault().getPath("pic", "dice1.jpg").toUri().toURL().toString());
				dice1.setImage(image1);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
			Image image2;
			try {
				image2 = new Image(
						FileSystems.getDefault().getPath("pic", "dice2.jpeg").toUri().toURL().toString());
				dice1.setImage(image2);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 3:
			Image image3;
			try {
				image3 = new Image(
						FileSystems.getDefault().getPath("pic", "dice3.jpeg").toUri().toURL().toString());
				dice1.setImage(image3);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 4:
			Image image4;
			try {
				image4 = new Image(
						FileSystems.getDefault().getPath("pic", "dice4.jpeg").toUri().toURL().toString());
				dice1.setImage(image4);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 5:
			Image image5;
			try {
				image5 = new Image(
						FileSystems.getDefault().getPath("pic", "dice5.jpeg").toUri().toURL().toString());
				dice1.setImage(image5);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 6:
			Image image6;
			try {
				image6 = new Image(
						FileSystems.getDefault().getPath("pic", "dice6.jpeg").toUri().toURL().toString());
				dice1.setImage(image6);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		switch (s2) {
		case 1:
			Image image1;
			try {
				image1 = new Image(
						FileSystems.getDefault().getPath("pic", "dice1.jpg").toUri().toURL().toString());
				dice2.setImage(image1);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
			Image image2;
			try {
				image2 = new Image(
						FileSystems.getDefault().getPath("pic", "dice2.jpeg").toUri().toURL().toString());
				dice2.setImage(image2);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 3:
			Image image3;
			try {
				image3 = new Image(
						FileSystems.getDefault().getPath("pic", "dice3.jpeg").toUri().toURL().toString());
				dice2.setImage(image3);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 4:
			Image image4;
			try {
				image4 = new Image(
						FileSystems.getDefault().getPath("pic", "dice4.jpeg").toUri().toURL().toString());
				dice2.setImage(image4);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 5:
			Image image5;
			try {
				image5 = new Image(
						FileSystems.getDefault().getPath("pic", "dice5.jpeg").toUri().toURL().toString());
				dice2.setImage(image5);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 6:
			Image image6;
			try {
				image6 = new Image(
						FileSystems.getDefault().getPath("pic", "dice6.jpeg").toUri().toURL().toString());
				dice2.setImage(image6);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		switch (s3) {
		case 1:
			Image image1;
			try {
				image1 = new Image(
						FileSystems.getDefault().getPath("pic", "dice1.jpg").toUri().toURL().toString());
				dice3.setImage(image1);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
			Image image2;
			try {
				image2 = new Image(
						FileSystems.getDefault().getPath("pic", "dice2.jpeg").toUri().toURL().toString());
				dice3.setImage(image2);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 3:
			Image image3;
			try {
				image3 = new Image(
						FileSystems.getDefault().getPath("pic", "dice3.jpeg").toUri().toURL().toString());
				dice3.setImage(image3);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 4:
			Image image4;
			try {
				image4 = new Image(
						FileSystems.getDefault().getPath("pic", "dice4.jpeg").toUri().toURL().toString());
				dice3.setImage(image4);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 5:
			Image image5;
			try {
				image5 = new Image(
						FileSystems.getDefault().getPath("pic", "dice5.jpeg").toUri().toURL().toString());
				dice3.setImage(image5);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 6:
			Image image6;
			try {
				image6 = new Image(
						FileSystems.getDefault().getPath("pic", "dice6.jpeg").toUri().toURL().toString());
				dice3.setImage(image6);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
	}

	@FXML
	void againpressed(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("fp2.fxml"));
		Scene scene = new Scene(root);
		scene.getRoot().requestFocus();
		FP.currentStage.setScene(scene);
		FP.player2.stop();
		Rectangle2D primScreenBounds=Screen.getPrimary().getVisualBounds();
		FP.currentStage.setX((primScreenBounds.getWidth()-FP.currentStage.getWidth())/2);
		FP.currentStage.setY((primScreenBounds.getHeight()-FP.currentStage.getHeight())/2);

		FP.player1.setCycleCount(-1);
		FP.player1.play();
	}

	@FXML
	void closepressed(ActionEvent event) {

		FP.currentStage.close();
	}

	@FXML
	void pressscare(ActionEvent event) throws IOException{
		Parent root=FXMLLoader.load(getClass().getResource("fp3.fxml"));
		Scene scene=new Scene(root);
		scene.getRoot().requestFocus();
		FP.currentStage.setScene(scene);
		Rectangle2D primScreenBounds=Screen.getPrimary().getVisualBounds();
		FP.currentStage.setX((primScreenBounds.getWidth()-FP.currentStage.getWidth())/2);
		FP.currentStage.setY((primScreenBounds.getHeight()-FP.currentStage.getHeight())/2);


		
	}

	@FXML
	void pressback(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("fp2.fxml"));
		Scene scene = new Scene(root);
		scene.getRoot().requestFocus();
		FP.currentStage.setScene(scene);
		FP.player2.stop();
		Rectangle2D primScreenBounds=Screen.getPrimary().getVisualBounds();
		FP.currentStage.setX((primScreenBounds.getWidth()-FP.currentStage.getWidth())/2);
		FP.currentStage.setY((primScreenBounds.getHeight()-FP.currentStage.getHeight())/2);

		FP.player1.setCycleCount(-1);
		FP.player1.play();
	}
	@FXML
    void pressoffr(ActionEvent event) {
		rulep.setVisible(false);
    }
	@FXML
    void presssee(ActionEvent event) {
		rulep.setVisible(true);
    }
	@FXML
    void leavesee(MouseEvent event) {
        see.setPrefHeight(41);
        see.setPrefWidth(84);
        see.setLayoutX(14);
        see.setLayoutY(468);
//        playsee.stop();
    }

    @FXML
    void touchdice(MouseEvent event) {
        try {
            playsee= new MediaPlayer(new Media(FileSystems.getDefault().getPath("pic","packun_eating.mp3").toUri().toURL().toString()));
            playsee.play();
        } catch (MalformedURLException e) {

            e.printStackTrace();
        };
        dice.setPrefHeight(60);
        dice.setPrefWidth(60);
        dice.setLayoutX(418);
        dice.setLayoutY(381);
    }

    @FXML
    void leavedice(MouseEvent event) {
        dice.setPrefHeight(48);
        dice.setPrefWidth(53);
        dice.setLayoutX(421);
        dice.setLayoutY(384);
    }

    @FXML
    void touchsee(MouseEvent event) {
        try {
            playsee= new MediaPlayer(new Media(FileSystems.getDefault().getPath("pic","packun_eating.mp3").toUri().toURL().toString()));
            playsee.play();
        } catch (MalformedURLException e) {

            e.printStackTrace();
        };
        see.setLayoutX(4);
        see.setLayoutY(463);
        see.setPrefHeight(48);
        see.setPrefWidth(104);
    }

    @FXML
    void leaverestart(MouseEvent event) {
        back.setLayoutX(794);
        back.setLayoutY(468);
        back.setPrefHeight(41);
        back.setPrefWidth(84);
    }

    @FXML
    void touchrestart(MouseEvent event) {
        try {
            playsee= new MediaPlayer(new Media(FileSystems.getDefault().getPath("pic","packun_eating.mp3").toUri().toURL().toString()));
            playsee.play();
        } catch (MalformedURLException e) {

            e.printStackTrace();
        };
        back.setLayoutX(787);
        back.setLayoutY(458);
        back.setPrefHeight(55);
        back.setPrefWidth(98);
    }
    @FXML
    void touchoffr(MouseEvent event) {
        try {
            playsee= new MediaPlayer(new Media(FileSystems.getDefault().getPath("pic","packun_eating.mp3").toUri().toURL().toString()));
            playsee.play();
        } catch (MalformedURLException e) {

            e.printStackTrace();
        };
        offr.setLayoutX(472);
        offr.setLayoutY(25);
        offr.setPrefHeight(55);
        offr.setPrefWidth(60);
    }
    @FXML
    void leaveoffr(MouseEvent event) {
        offr.setLayoutX(478);
        offr.setLayoutY(32);
        offr.setPrefHeight(41);
        offr.setPrefWidth(47);
    }
    @FXML
    void touchagainbottom(MouseEvent event) {
    	try {
            playsee= new MediaPlayer(new Media(FileSystems.getDefault().getPath("pic","packun_eating.mp3").toUri().toURL().toString()));
            playsee.play();
        } catch (MalformedURLException e) {

            e.printStackTrace();
        };
        againbuttom.setLayoutX(265);
        againbuttom.setLayoutY(387);
        againbuttom.setPrefHeight(55);
        againbuttom.setPrefWidth(104);
    }
    @FXML
    void leaveagainbottom(MouseEvent event) {
    	againbuttom.setLayoutX(271);
        againbuttom.setLayoutY(394);
        againbuttom.setPrefHeight(41);
        againbuttom.setPrefWidth(91);
    }
    @FXML
    void touchclosebuttom(MouseEvent event) {
    	try {
            playsee= new MediaPlayer(new Media(FileSystems.getDefault().getPath("pic","packun_eating.mp3").toUri().toURL().toString()));
            playsee.play();
        } catch (MalformedURLException e) {

            e.printStackTrace();
        };
        closebuttom.setLayoutX(506);
        closebuttom.setLayoutY(387);
        closebuttom.setPrefHeight(55);
        closebuttom.setPrefWidth(104);
    }
    @FXML
    void leaveclosebuttom(MouseEvent event) {
    	closebuttom.setLayoutX(512);
        closebuttom.setLayoutY(394);
        closebuttom.setPrefHeight(41);
        closebuttom.setPrefWidth(91);
    }
    @FXML
    void touchscare(MouseEvent event) {
    	try {
            playsee= new MediaPlayer(new Media(FileSystems.getDefault().getPath("pic","packun_eating.mp3").toUri().toURL().toString()));
            playsee.play();
        } catch (MalformedURLException e) {

            e.printStackTrace();
        };
        scare.setLayoutX(376);
        scare.setLayoutY(380);
        scare.setPrefHeight(69);
        scare.setPrefWidth(111);
    }
    @FXML
    void leavescare(MouseEvent event) {
    	scare.setLayoutX(388);
        scare.setLayoutY(387);
        scare.setPrefHeight(55);
        scare.setPrefWidth(98);
    }
	public boolean turn;
	public int cdice, M;
	
	static MediaPlayer pb1;
	static MediaPlayer pg1;
	static MediaPlayer pw1;
	static MediaPlayer pl1;
	static MediaPlayer cb1;
	static MediaPlayer cg1;
	static MediaPlayer same;
	static MediaPlayer dicesound;
	static MediaPlayer enter;
	static MediaPlayer pl2;
	static MediaPlayer pw2;
	static MediaPlayer enter2;
	static MediaPlayer playsee;
	static MediaPlayer sg1;
	static MediaPlayer Click;
	@Override
	public void initialize(URL url, ResourceBundle rb) {

		p1 = new Player("computer");
		p2 = new Player("可憐沒名字");
		cb.setText("BOSS");
		cMoney.setText(String.valueOf(p1.getm()));
		yMoney.setText(String.valueOf(p2.getm()));
		turn = true;
		screen.setText("在輸入區下注喔喔!");

//	     try {
//			player_dice= new MediaPlayer(new Media(FileSystems.getDefault().getPath("src","fp","laugth.mp3").toUri().toURL().toString()));
//			player_dice.play();
//		} catch (MalformedURLException e) {
//			
//			e.printStackTrace();
//		};
//		new Delay(5000);
	}
}
