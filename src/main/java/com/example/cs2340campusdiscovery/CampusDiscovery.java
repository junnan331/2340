package com.example.cs2340campusdiscovery;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import java.util.concurrent.atomic.AtomicReference;

public class CampusDiscovery extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CampusDiscovery.class.getResource("hello-view.fxml"));

        Pane welomePane = new StackPane();
        Scene scene = new Scene(welomePane, 1200, 800);
        VBox vbox  = new VBox(30);
        welomePane.getChildren().add(vbox);
        Text wel = new Text("Welcome to Campus Discovery!");
        wel.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 40));
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().add(wel);
        stage.setTitle("GT Discovery");
        Image startImage = new Image("https://static.wikia.nocookie.net/nba/images/d/df/GeorgiaTechlogo.png/revision/latest?cb=20110509154344");
        ImageView startButtonView = new ImageView(startImage);
        Image gtimage = new Image("https://news.gatech.edu/sites/default/files/hg_media/Screen%20Shot%202017-04-21%20at%2010.19.40%20AM.png");
        BackgroundImage welImage = new BackgroundImage(gtimage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background welBG =  new Background(welImage);
        welomePane.setBackground(welBG);
        Button startButton = new Button("Start");
        startButton.setGraphic(startButtonView);
        startButton.setPrefSize(80,50);
        startButton.setTextFill(Color.RED);
        vbox.getChildren().add(startButton);
        // sign in page
        Pane signInPane = new StackPane();
        VBox signInPage = new VBox(10);
        signInPane.getChildren().add(signInPage);
        Scene signIn = new Scene(signInPane,1200, 800);
        signInPage.setPadding(new Insets(200,300,600,300));
        Image signImage = new Image("https://dz0zjhi21dz2t.cloudfront.net/media/95415/tour/1447291605628/1366_front.jpg");
        BackgroundImage signInBGI = new BackgroundImage(signImage, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
        Background signInBG = new Background(signInBGI);
        Text userName = new Text("User Name");
        userName.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC,12));
        userName.setLayoutX(300);
        userName.setLayoutY(200);
        userName.setLineSpacing(10);
        TextField userNameInput = new TextField( );
        Text userNameText = new Text("Hello, ");

        userNameInput.setEditable(true);

        userNameInput.setPrefSize(100,20);
        Text password = new Text("Password");
        password.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC,12));
        PasswordField passwordTF = new PasswordField();
        Text passwordText = new Text();
        passwordTF.setEditable(true);
        passwordTF.setPrefSize(100,20 );
        Button submitButton = new Button("Submit");
        submitButton.setPrefSize(60, 20);
        Text userType = new Text("User Type");
        userType.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC,12));
        ComboBox<String> types = new ComboBox<>();
        types.getItems().addAll("Student", "Teacher", "Organizer");
        Text rollText = new Text("You signed in as an awesome ");



        // dashboard
        Pane dashboardPane = new StackPane();
        dashboardPane.setBackground(signInBG);
        Scene dashboardScene = new Scene(dashboardPane,1200, 800);
        VBox eventList = new VBox(10);
        eventList.setAlignment(Pos.TOP_CENTER);
        dashboardPane.getChildren().add(eventList);
        Text header = new Text("Event List");
        header.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 60));

        Text event1 = new Text("Event1");
        Text event2 = new Text("Event2");


        // alert
        Alert wrInput = new Alert(Alert.AlertType.ERROR) ;

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                 String userNameString = userNameInput.getText();
               userNameText.setText(userNameText.getText() + userNameString);
                userNameText.setFont(Font.font("Ariel", FontWeight.BOLD, FontPosture.ITALIC,20));
                String passwordString = passwordTF.getText();
                passwordText.setText(passwordString);
                String typeSelected = types.getValue();
                rollText.setText(rollText.getText() + typeSelected);
                rollText.setFont(Font.font("Ariel", FontWeight.BOLD, FontPosture.ITALIC,20));
                if (userNameString.length() < 2 || userNameString.trim().isEmpty()) {
                    wrInput.setContentText("Please enter a valid user name, longer than 1 character");
                    wrInput.showAndWait();
                } else if (passwordString.length() < 9 || passwordString.trim().isEmpty()) {

                    wrInput.setContentText("Please enter a valid password with length longer then 8");
                    wrInput.showAndWait();
                } else if (typeSelected == null) {
                    Text read = new Text(typeSelected);
                    eventList.getChildren().add(read);
                    wrInput.setContentText("Please select a type");
                    wrInput.showAndWait();
                } else {
                    stage.setScene(dashboardScene);
                }
            }
        });

        eventList.getChildren().addAll(header, userNameText, rollText, event1, event2);

        signInPage.getChildren().addAll(userName, userNameInput, password, passwordTF, userType, types, submitButton);
        signInPane.setBackground(signInBG);

        stage.setScene(scene);
        startButton.setOnAction(e -> stage.setScene(signIn));


        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}