package sample.service;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import sample.dao.FileSystemDao;
import sample.dao.FileSystemDaoImpl;

/**
 * Created by user-pc on 02.03.2017.
 */
public class FileSystemServiceImpl implements FileSystemService {

    FileSystemDao fileSystemDao = new FileSystemDaoImpl();
    @Override
    public void chooseFiles(ActionEvent actionEvent) {
        fileSystemDao.chooseFiles(actionEvent);
    }

    @Override
    public ObservableList getFileList() {
        return fileSystemDao.getFileList();
    }
}
