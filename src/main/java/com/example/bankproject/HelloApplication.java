package com.example.bankproject;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {


        //all the default accounts for the program. (this will change, ill save it all to a text file and at the beginning of the program, get the accounts
        //from the text file soo any changes will be saved.
        Accounts debit = new Accounts(999999, "Debit", 1291.22);
        Accounts savings = new Accounts(1234, "DIS T Getting There Savings", 15293.36);
        Accounts credit = new Accounts(00323, "Scene+", -312.12);

        //creates the Accounts ArrayList (this will eventually be removed and replaced with a txt file.
        ArrayList<Accounts> testing = new ArrayList<Accounts>();

        testing.add(debit);
        testing.add(savings);
        testing.add(credit);


        //testing the makeTransfer() method
        Accounts.makeTransfer(testing);

        //System.out.println(testing.get(1).getAccountBalance());


        // initializing the login Page group and scene
        Group gLogin = new Group();
        Scene login = new Scene(gLogin, 1000, 800, Color.SKYBLUE);

        // initializing the main bank app's group and scene
        Group gMainBank = new Group();
        Scene mainBank = new Scene(gMainBank, 700, 1000, Color.DARKGRAY);


        Stage stage = new Stage();

        //
        // LOGIN PAGE SHIT
        //

        //username text-box
        TextField tfUsername = new TextField();
        tfUsername.setPromptText("Username");
        tfUsername.setMaxWidth(110);
        tfUsername.setTranslateX(440);
        tfUsername.setTranslateY(50);

        //password text-box
        TextField tfPassword = new TextField();
        tfPassword.setPromptText("Password");
        tfPassword.setMaxWidth(110);
        tfPassword.setTranslateX(440);
        tfPassword.setTranslateY(80);

        //login button
        Button btLogin = new Button("Sign In");
        btLogin.setTranslateX(400);
        btLogin.setTranslateY(200);
        btLogin.setMinWidth(200);
        btLogin.setBackground(Background.fill(Color.RED));
        btLogin.setTextFill(Color.WHITE);
        btLogin.setOnAction(e -> {
            String inputUsername = tfUsername.getText();
            String inputPassword = tfPassword.getText();
            // calls login validator on the user's inputted username and password
            if (Login.loginValidator(inputUsername, inputPassword)) {
                //sets the Scene as mainBank if good credentials were put in.
                stage.setScene(mainBank);
            }
            else{
                //changes some styling if user enters bad credentials
                tfUsername.setBorder(Border.stroke(Color.RED));
                tfPassword.setBorder(Border.stroke(Color.RED));
                Text invalidLogin = new Text();
                invalidLogin.setText("Incorrect username or password, please try again.");
                invalidLogin.setFill(Color.RED);
                invalidLogin.setFont((Font.font("Verdana", 14)));
                invalidLogin.setX(tfPassword.getTranslateX() - 100);
                invalidLogin.setY(tfPassword.getTranslateY() + 100);
                gLogin.getChildren().add(invalidLogin);

            }

        });


        //adding the nodes to the Stage/group
        gLogin.getChildren().add(tfUsername);
        gLogin.getChildren().add(tfPassword);
        gLogin.getChildren().add(btLogin);


        //
        // MAIN BANK SHIT
        //

        //Boujee line thingy
        Line lnAccLine = new Line();
        lnAccLine.setStartX(48);
        lnAccLine.setEndX(240);
        lnAccLine.setStartY(104);
        lnAccLine.setEndY(104);
        lnAccLine.setStrokeWidth(2);
        lnAccLine.setStroke(Color.BLACK);

        //Accounts Header
        Text txtHeaderAccounts = new Text();
        txtHeaderAccounts.setText("Accounts");
        txtHeaderAccounts.setFill(Color.BLACK);
        txtHeaderAccounts.setFont((Font.font("Verdana", 24)));
        txtHeaderAccounts.setX(50);
        txtHeaderAccounts.setY(100);

        //account 1, 2 and 3 need to change, its mostly repetitive code, but i dont know how to
        //condense it

        //Account 1 text
        Text txtAccount1 = new Text();
        txtAccount1.setText(debit.getAccountName());
        txtAccount1.setFill(Color.BLACK);
        txtAccount1.setFont((Font.font("Verdana", 18)));
        txtAccount1.setX(50);
        txtAccount1.setY(140);

        //Account 1 information
        Text txtAcc1Info = new Text();
        txtAcc1Info.setText(debit.balanceToString());
        txtAcc1Info.setX(50);
        txtAcc1Info.setY(txtAccount1.getY() + 30);

        //Account 2 text
        Text txtAccount2 = new Text();
        txtAccount2.setText(savings.getAccountName());
        txtAccount2.setFill(Color.BLACK);
        txtAccount2.setFont((Font.font("Verdana", 18)));
        txtAccount2.setX(50);
        txtAccount2.setY(txtAccount1.getY() + 100);

        //Account 2 information
        Text txtAcc2Info = new Text();
        txtAcc2Info.setText(savings.balanceToString());
        txtAcc2Info.setX(50);
        txtAcc2Info.setY(txtAccount2.getY() + 30);

        //Account 3 text
        Text txtAccount3 = new Text();
        txtAccount3.setText(credit.getAccountName());
        txtAccount3.setFill(Color.BLACK);
        txtAccount3.setFont((Font.font("Verdana", 18)));
        txtAccount3.setX(50);
        txtAccount3.setY(txtAccount2.getY() + 100);

        //Account 3 information
        Text txtAcc3Info = new Text();
        txtAcc3Info.setText(credit.balanceToString());
        txtAcc3Info.setX(50);
        txtAcc3Info.setY(txtAccount3.getY() + 30);

        //adds all the nodes to the group
        gMainBank.getChildren().add(txtHeaderAccounts);
        gMainBank.getChildren().add(lnAccLine);
        gMainBank.getChildren().add(txtAccount1);
        gMainBank.getChildren().add(txtAccount2);
        gMainBank.getChildren().add(txtAccount3);
        gMainBank.getChildren().add(txtAcc1Info);
        gMainBank.getChildren().add(txtAcc2Info);
        gMainBank.getChildren().add(txtAcc3Info);


        //sets and shows the Login scene
        stage.setScene(login);
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}