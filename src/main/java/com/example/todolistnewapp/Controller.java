package com.example.todolistnewapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private BorderPane borderPane;
    @FXML
    private Button homeButton, viewButton, addButton, removeButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    public void homeScreen(ActionEvent event) throws IOException {
        AnchorPane view = FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
        borderPane.setCenter(view);
    }
    @FXML
    private void viewScreen(ActionEvent event) throws IOException {
        AnchorPane view = FXMLLoader.load(getClass().getResource("ViewScreen.fxml"));
        borderPane.setCenter(view);
    }
    @FXML
    private void addScreen(ActionEvent event) throws IOException {
        AnchorPane view = FXMLLoader.load(getClass().getResource("AddScreen.fxml"));
        borderPane.setCenter(view);
    }
    @FXML
    private void removeScreen(ActionEvent event) throws IOException {
        AnchorPane view = FXMLLoader.load(getClass().getResource("RemoveScreen.fxml"));
        borderPane.setCenter(view);
    }
}