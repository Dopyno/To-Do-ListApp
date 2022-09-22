package com.example.todolistnewapp;


import ToDoListModel.ToDoModel;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.format.DateTimeFormatter;

public class ViewScreen {
    @FXML
    private Button viewButton, checkView;
    @FXML
    private ListView listView;
    @FXML
    private TextArea detailArea;
    @FXML
    private Label dateLabel;
    //private List<ToDoModel> secondList = new ArrayList<>();



    @FXML
    public void viewArea(){
        AddScreen show = new AddScreen();
        show.loadFileFromTxt();

        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                if(t1 != null){
                    ToDoModel item = (ToDoModel) listView.getSelectionModel().getSelectedItem();
                    detailArea.setText(item.getDetail());
                    detailArea.setWrapText(true);
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy");
                    dateLabel.setText("Due: " + df.format(item.getDate()));
                }
            }
        });

        listView.getItems().setAll(show.listModel);
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listView.getSelectionModel().selectFirst();
       // listView.getSelectionModel().getSelectedItem().
        show.viewMyList();
    }
    @FXML
    public void initialize(){
        viewArea();
    }
   }
