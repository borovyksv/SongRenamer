package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.objects.Song;
import sample.service.FileSystemService;
import sample.service.FileSystemServiceImpl;

public class Controller {

    FileSystemService service = new FileSystemServiceImpl();


    @FXML
    public TableView tableView;
    @FXML
    public TableColumn<Song, String> beforeField;
    @FXML
    public TableColumn<Song, String> afterField;

    @FXML
    public Button chooseBtn;

    @FXML
    private void initialize(){
        beforeField.setCellValueFactory(new PropertyValueFactory<>("before"));
        afterField.setCellValueFactory(new PropertyValueFactory<>("after"));
        tableView.setItems(service.getFileList());
    }

    public void chooseFiles(ActionEvent actionEvent) {
        service.chooseFiles(actionEvent);
    }






}
