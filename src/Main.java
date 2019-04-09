

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Main extends Application {
    private Stage window;
    private Scene scene;
    private Image logo = new Image("Photo/van.png");
    public Label reservationsLabel;
    public Label basicLabel;
    public Label standardLabel;
    public Label luxuryLabel;
    public Label logOutLabel;


    @Override
    public void start(Stage primaryStage) throws Exception{
        //Create basic Scene
        window = primaryStage;
        window.setTitle("Auto Camper - Rental Service");
        BorderPane root = new BorderPane();
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
        reservationsLabel.getStyleClass().add("sideMenu");
        reservationsLabel.setPadding(new Insets(0,0,0,10));


        basicLabel = new Label("Basic");
        basicLabel.setPrefHeight(30);

        standardLabel = new Label("Standard");
        standardLabel.setPrefHeight(30);

        luxuryLabel = new Label("Luxury");
        luxuryLabel.setPrefHeight(30);

        logOutLabel= new Label("Log Out");
        logOutLabel.setPadding(new Insets(0,0,0,10));
        logOutLabel.getStyleClass().add("sideMenu");
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
        sideMenu.getStyleClass().add("sideMenu");


        // Insert Label to side Menu
        sideMenu.getChildren().addAll(basicLabel,standardLabel,luxuryLabel);

        //add to left
        left.getChildren().add(reservationsLabel);
        left.getChildren().add(sideMenu);
        left.getChildren().add(logOutLabel);


        // Show Window
        window.setScene(scene);
        window.show();
    }


    public static void main(String[] args) {
        Basic Funny = new Basic();
        Funny.setDescription("It's blue");
        System.out.println(Funny.toString());

        AutoCamper Stand = new Standard();
        Stand.setDescription("its red");
        System.out.println(Stand.toString());

        AutoCamper Lux = new Luxury();
        Lux.setDescription("It's Gold");
        System.out.println(Lux.toString());
        launch(args);

    }
    public void mouseOnAndoff (Node node)
    {
        node.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                scene.setCursor(javafx.scene.Cursor.HAND);
                node.setId("MarkedText");
            }
        });
        node.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                scene.setCursor(Cursor.DEFAULT);
                node.setId("unMarkedText");
            }
        });}
}



