package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

import java.io.File;
import java.util.List;

public class Controller {
    @FXML
    public Button chooseBtn;
    @FXML
    public Button renameBtn;
    @FXML
    public Label chosenFiles;


    public void chooseFiles(ActionEvent actionEvent) {
        final FileChooser fileChooser = new FileChooser();

        List<File> list =
                fileChooser.showOpenMultipleDialog(((Node) actionEvent.getSource()).getScene().getWindow());
        if (list != null) {
            list.forEach(Controller.this::openFile);
        }

    }

    private void openFile(File input) {

        try {

            AudioFile song = AudioFileIO.read(input);
            Tag tag = song.getTag();
            String title = tag.getFirst(FieldKey.TITLE);
            String artist = tag.getFirst(FieldKey.ARTIST);


            String absolutePath = input.getParent() + File.separator;

            File newName = new File(absolutePath + title + " - " + artist + ".mp3");
            boolean success = input.renameTo(newName);

            if (!success) {
                appentToLabel("Упс, не получитлось переиминовать "+input.getName());
            } else {
                appentToLabel(input.getName()+"      ===>>>     "+newName.getName());
            }
        } catch (Exception e) {
            System.out.println("Error — " + e.toString());
        }
    }

    private void appentToLabel(String message) {
        chosenFiles.setText(chosenFiles.getText() + "\n"+message);
    }

    public void rename(ActionEvent actionEvent) {
    }
}
