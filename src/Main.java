

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.DuplicateFormatFlagsException;
import java.util.HashMap;


public class Main extends Application {
    private Stage window;
    private Scene scene;
    private Image logo = new Image("Photo/van.png");
    public Label reservationsLabel;
    public Label basicLabel;
    public Label standardLabel;
    public Label luxuryLabel;
    public Label logOutLabel;
    public ArrayList <AutoCamper>autoCampers = new ArrayList<>();
    public HashMap<Node,AutoCamper> autocamperLabels = new HashMap<>();
    public BorderPane root = new BorderPane();
    public VBox rightSide = new VBox();
    public Button reserveButton = new Button("Reserve");

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Create basic Scene

        window = primaryStage;
        window.setTitle("Auto Camper - Rental Service");

        root.setPadding(new Insets(10,10,10,10));
        scene = new Scene(root);
        scene.getStylesheets().setAll("Style.css");
        root.getStyleClass().add("sceneColor");

        //Top
        HBox topHbox = new HBox();
        root.setTop(topHbox);
        Label title = new Label("AutoCamper");
        title.getStyleClass().add("titleStyle");
        ImageView vanLogo = new ImageView(logo);
        vanLogo.setFitHeight(85);
        vanLogo.setFitWidth(85);
        topHbox.getChildren().setAll(title,vanLogo);
        topHbox.setAlignment(Pos.CENTER);


        //Left side Button/label
        reservationsLabel= new Label("Reservations");
        reservationsLabel.setPrefSize(180,40);
        reservationsLabel.setId("sideMenu");
        reservationsLabel.setPadding(new Insets(0,0,0,10));


        basicLabel = new Label("Basic");
        basicLabel.setPrefHeight(30);

        standardLabel = new Label("Standard");
        standardLabel.setPrefHeight(30);

        luxuryLabel = new Label("Luxury");
        luxuryLabel.setPrefHeight(30);

        logOutLabel= new Label("Log Out");
        logOutLabel.setPadding(new Insets(0,0,0,10));
        logOutLabel.setId("sideMenu");
        logOutLabel.setPrefSize(180,40);

        mouseOnAndoff(logOutLabel);
        mouseOnAndoff(basicLabel);
        mouseOnAndoff(standardLabel);
        mouseOnAndoff(luxuryLabel);
        mouseOnAndoff(reservationsLabel);
        //Left side
        VBox left = new VBox();
        left.setPrefWidth(200);

        left.setSpacing(10);
        root.setLeft(left);

        //SideMenu
        VBox sideMenu  = new VBox();
        sideMenu.setPrefHeight(500);
        sideMenu.setPadding(new Insets(10,10,10,10));
        sideMenu.setId("sideMenu");


        // Insert Label to side Menu
        sideMenu.getChildren().addAll(basicLabel,standardLabel,luxuryLabel);

        //add to left
        left.getChildren().add(reservationsLabel);
        left.getChildren().add(sideMenu);
        left.getChildren().add(logOutLabel);

        //right Side
        root.setRight(rightSide);
        Label reservationTitle = new Label("Reservation");
        rightSide.getChildren().add(reservationTitle);
        rightSide.getChildren().add(reserveButton);
        reserveButton.setVisible(false);
        rightSide.setId("sideMenu");
        rightSide.setSpacing(10);
        rightSide.setPadding(new Insets(10));

        // Show Window
        window.setScene(scene);
        window.show();

        //Create Arraylist with Autocampers
        AutoCamper standardBlue = new Standard();
        standardBlue.setDescription("It's white and blue");
        standardBlue.setPhotoPath("Photo/Standardvan (5).png");
        autoCampers.add(standardBlue);

        AutoCamper standardPurple = new Standard();
        standardPurple.setDescription("It's Purple");
        standardPurple.setPhotoPath("Photo/Standardvan (6).png");
        autoCampers.add(standardPurple);

        AutoCamper standardBlack = new Standard();
        standardBlack.setDescription("It's black");
        standardBlack.setPhotoPath("Photo/Standardvan (3).png");
        autoCampers.add(standardBlack);

        standardLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                root.setCenter(showthattype(Standard.class));
            }
        });

        AutoCamper basicYellow = new Basic();
        basicYellow.setDescription("It's yellow");
        basicYellow.setPhotoPath("Photo/basicVan.png");
        autoCampers.add(basicYellow);

        AutoCamper basicBlack = new Basic();
        basicBlack.setDescription("It's black");
        basicBlack.setPhotoPath("Photo/basicVan(1).png");
        autoCampers.add(basicBlack);

        AutoCamper basicNoColor = new Basic();
        basicNoColor.setDescription("It's blank");
        basicNoColor.setPhotoPath("Photo/basicVan(2).png");
        autoCampers.add(basicNoColor);

        basicLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                root.setCenter(showthattype(Basic.class));
            }
        });

        AutoCamper luxuryBlank = new Luxury();
        luxuryBlank.setDescription("it's blank");
        luxuryBlank.setPhotoPath("Photo/Luxury.png");
        autoCampers.add(luxuryBlank);

        AutoCamper luxuryBlack = new Luxury();
        luxuryBlack.setDescription("it's black");
        luxuryBlack.setPhotoPath("Photo/Luxury(1).png");
        autoCampers.add(luxuryBlack);

        AutoCamper luxuryRed = new Luxury();
        luxuryRed.setDescription("it's red");
        luxuryRed.setPhotoPath("Photo/Luxury(2).png");
        autoCampers.add(luxuryRed);


        luxuryLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                root.setCenter(showthattype(Luxury.class));
            }
        });


    }


    public static void main(String[] args) {



        launch(args);

    }

    public ScrollPane showthattype(Class<?> currentType )
    {ScrollPane ACScrollPane = new ScrollPane();
        FlowPane newFlowPane = new FlowPane();


        System.out.println("After loop");
        for (int i = 0; i < autoCampers.size() ; i++) {
         AutoCamper currentautoCamper = autoCampers.get(i);
            GridPane newGridpane= new GridPane();
            autocamperLabels.put(newGridpane,currentautoCamper);

            if (currentType == currentautoCamper.getClass())
        {
            newGridpane.setGridLinesVisible(false);
            Image newImage = new Image(currentautoCamper.getPhotoPath());
            ImageView newImageView = new ImageView(newImage);
            newImageView.setFitWidth(150);
            newImageView.setFitHeight(150);
            newGridpane.add(newImageView,0,0,1,3);
            Label autoCamperID = new Label("AutoCamper ID: " + currentautoCamper.getAutoCamperNo());
            Label autocamperDescription = new Label(currentautoCamper.getDescription());
            Label autocamperPrice = new Label("Price:" + currentautoCamper.getPrice()+" DKK");
            newGridpane.add(autoCamperID,1,0);
            newGridpane.add(autocamperDescription,1,1);
            newGridpane.add(autocamperPrice,1,2);
            newGridpane.setId("sideMenu");
            newGridpane.setHgap(10);
            chooseAutoCamperEffects(newGridpane);
            //autocamperLabels.put(currentautoCamper,newGridpane);


        }
            newFlowPane.setHgap(10);
            newFlowPane.setVgap(10);
            newFlowPane.getChildren().add(newGridpane);
        }
        ACScrollPane.setContent(newFlowPane);
        ACScrollPane.setFitToWidth(true);
        ACScrollPane.setPadding(new Insets(10,10,10,10));
        ACScrollPane.getStyleClass().add("sceneColor");
        System.out.println(autocamperLabels.toString());
        return ACScrollPane;

    }

    public void mouseOnAndoff (Node node)
    {
        node.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                node.setId("MarkedText");
            }
        });
        node.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                node.setId("sideMenu");
            }
        });}

        public void chooseAutoCamperEffects (Node node)
        {

            node.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    node.setId("chooseAC");
                }
            });

            node.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    node.setId("sideMenu");
                }
            });

            node.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    AutoCamper currentAutoCamper = autocamperLabels.get(node);
                    Label reservation = new Label(""+currentAutoCamper.getDescription()+"\n"+ currentAutoCamper.getPrice()+"DKK");
                    if (rightSide.getChildren().get(1)!=reserveButton)
                    {rightSide.getChildren().remove(1);}
                    rightSide.getChildren().add(1,reservation);
                    reserveButton.setVisible(true);

                }
            });
        }

}



