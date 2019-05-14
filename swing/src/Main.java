import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.net.URL;

public class Main extends Application {

    Scene scene1,scene2;
    Stage window;


    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;

        AnchorPane anchorPane1 = new AnchorPane();
        AnchorPane anchorPane2 = new AnchorPane();

        scene1 = new Scene(anchorPane1,1023,637);

        FileInputStream input = new FileInputStream("E:\\swing\\src\\background.jpg");
        Image image = new Image(input);
        BackgroundImage backgroundimage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background background = new Background(backgroundimage);

        final ImageView imv1 = new ImageView();
        final Image image1 = new Image(Main.class.getResourceAsStream("logo.png"));
        imv1.setImage(image1);
        imv1.setFitHeight(250);
        imv1.setFitWidth(600);
        imv1.setLayoutY(0);
        imv1.setLayoutX(200);


        final ImageView imv2 = new ImageView();
        final Image image2 = new Image(Main.class.getResourceAsStream("Watermelonfruit.png"));
        imv2.setImage(image2);
        imv2.setFitHeight(100);
        imv2.setFitWidth(100);
        imv2.setLayoutY(400);
        imv2.setLayoutX(450);

        Timeline watermelonRotation = new Timeline(
                new KeyFrame(Duration.millis(10), e -> imv2.setRotate(imv2.getRotate() + 1))
        );

        watermelonRotation.setCycleCount(Timeline.INDEFINITE);
        watermelonRotation.play();




       Label start = new Label("Start");
       start.setTextFill(Color.web("lime"));
       start.setFont(new Font(30));
       start.setLayoutY(520);
       start.setLayoutX(475);
       start.setOnMouseClicked(e->window.setScene(scene2));


        final URL resource = getClass().getResource("starting_background_music.mp3");
        final Media media = new Media(resource.toString());
        final MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();


        final ImageView imv3 = new ImageView();
        final Image image3 = new Image(Main.class.getResourceAsStream("sound.png"));
        imv3.setImage(image3);
        imv3.setFitHeight(50);
        imv3.setFitWidth(50);
        imv3.setLayoutY(550);
        imv3.setLayoutX(0);


        final ImageView imv4 = new ImageView();
        final Image image4 = new Image(Main.class.getResourceAsStream("soundOff.png"));
        imv4.setImage(image4);
        imv4.setFitHeight(50);
        imv4.setFitWidth(50);
        imv4.setLayoutY(550);
        imv4.setLayoutX(0);
        imv4.setVisible(false);

        imv3.setOnMouseClicked(e->{
            imv4.setVisible(true);
            imv3.setVisible(false);
            mediaPlayer.stop();

        });

        imv4.setOnMouseClicked(e->{
            imv3.setVisible(true);
            imv4.setVisible(false);
            mediaPlayer.play();

        });


        anchorPane1.setBackground(background);

        anchorPane1.getChildren().addAll(imv1,imv2,start,imv3,imv4);

   ///////////////////////////////////////////////////////////////////////////////////////////////////////


        scene2 = new Scene(anchorPane2,1023,637);

        FileInputStream input1 = new FileInputStream("E:\\swing\\src\\background.jpg");
        Image imagee = new Image(input1);
        BackgroundImage backgroundimagee = new BackgroundImage(imagee,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background backgroundd = new Background(backgroundimagee);


        final ImageView imv5 = new ImageView();
        final Image image5 = new Image(Main.class.getResourceAsStream("logo.png"));
        imv5.setImage(image5);
        imv5.setFitHeight(250);
        imv5.setFitWidth(600);
        imv5.setLayoutY(0);
        imv5.setLayoutX(200);


        final ImageView imv6 = new ImageView();
        final Image image6 = new Image(Main.class.getResourceAsStream("back.png"));
        imv6.setImage(image6);
        imv6.setFitHeight(60);
        imv6.setFitWidth(60);
        imv6.setLayoutY(550);
        imv6.setLayoutX(300);
        imv6.setOnMouseClicked(e->window.setScene(scene1));



        anchorPane2.setBackground(backgroundd);

        anchorPane2.getChildren().addAll(imv5,imv6);


        window.setScene(scene1);
        window.show();
    }
}
