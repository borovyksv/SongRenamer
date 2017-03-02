package sample.dao;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

/**
 * Created by user-pc on 02.03.2017.
 */
public interface FileSystemDao {
    void chooseFiles(ActionEvent actionEvent);
    ObservableList getFileList();
}
