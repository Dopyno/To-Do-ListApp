package com.example.todolistnewapp;

import ToDoListModel.ToDoModel;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class RemoveScreen implements Initializable {
    @FXML
    private ListView<ToDoModel> removeListView;
    @FXML
     private TextArea detailTextArea;
    @FXML
    private Button viewListRemoveButton, removeSelectionButton;
    @FXML
     private Label messageLabel, date;

    AddScreen screen = new AddScreen();
    @FXML
    public void viewRemoveScreen(){
        screen.loadFileFromTxt();

        removeListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ToDoModel>() {
            @Override
            public void changed(ObservableValue<? extends ToDoModel> observableValue, ToDoModel toDoModel, ToDoModel t1) {
                if(t1 != null){
                    ToDoModel item = removeListView.getSelectionModel().getSelectedItem();
                    detailTextArea.setText(item.getDetail());
                    detailTextArea.setWrapText(true);
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy");
                    date.setText("Due: " + df.format(item.getDate()));
                }
            }
        });
        removeListView.getItems().setAll(screen.listModel);
        removeListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        removeListView.getSelectionModel().selectFirst();
        screen.viewMyList(); // print to console

    }
    @FXML
    public void removeFromListView(MouseEvent event) throws IOException {
        try {
            screen.loadFileFromTxt();
            int selection = removeListView.getSelectionModel().getSelectedIndex();
            removeListView.getItems().remove(selection);
            screen.listModel.remove(selection);
            messageLabel.setText("Your selection was successfully remove!");
            screen.saveFileToTxt();
            removeListView.refresh();
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
            messageLabel.setText("List is empty!");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        viewRemoveScreen();
    }

}
