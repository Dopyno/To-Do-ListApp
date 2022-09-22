package com.example.todolistnewapp;

import ToDoListModel.ToDoModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddScreen {
    public List<ToDoModel> listModel = new ArrayList<>();
    public File file = new File("ToDoFileTxt.txt");
    private ObjectOutputStream oos = null;
    private ObjectInputStream ois = null;
    Iterator listIterator = null;
    @FXML
    private TextField shortText;
    @FXML
    private Label message;
    @FXML
    private TextArea detailTextAddArea;
    @FXML
    private DatePicker datePicker;
    @FXML
    private Button addDetailButton, clearButton;
    @FXML
    private void clearFields(ActionEvent event){
        shortText.setText("");
        detailTextAddArea.setText("");
        message.setText("Please try again");
    }
    @FXML
    public void addToList(ActionEvent event)throws IOException {
        if(shortText.getText().isEmpty() && detailTextAddArea.getText().isEmpty()){
            message.setText("Please enter a valid record!");
        }else {
            addDetailToList(shortText.getText().trim(), detailTextAddArea.getText().trim(), datePicker.getValue());
            message.setText("Added successfully");
            shortText.setText("");
            detailTextAddArea.setText("");
            datePicker.setValue(LocalDate.now());
        }
    }
    private void addDetailToList(String title, String description, LocalDate date)throws IOException{
        try {
            if (file.isFile()) {
                loadFileFromTxt();
                listModel.add(new ToDoModel(title, description, date));
                saveFileToTxt();
            } else if (!file.isFile()){
                listModel.add(new ToDoModel(title, description, date));
                saveFileToTxt();
            }else {
                System.out.println("File not found!");
            }
        } catch (IOException e) {

        }
        viewMyList();
    }

    public void saveFileToTxt() throws IOException {
        oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(listModel);
        oos.close();
    }
    public void loadFileFromTxt(){
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            listModel = (List<ToDoModel>) ois.readObject();
            ois.close();
        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }
    public void viewMyList(){
        int index = 1;
        Iterator iterator = listModel.iterator();
        while (iterator.hasNext()) {
            System.out.println(index + ". " + iterator.next());
            index++;
        }
    }
//    public ToDoModel copyList(){
//        List<ToDoModel> model = (List<ToDoModel>) listModel;
//        return (ToDoModel) model;
//    }
}
