package sample.dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.FileChooser;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import sample.objects.Song;

import java.io.File;
import java.util.List;

/**
 * Created by user-pc on 02.03.2017.
 */
public class FileSystemDaoImpl implements FileSystemDao {

    private ObservableList<Song> songList = FXCollections.observableArrayList();


    @Override
    public void chooseFiles(ActionEvent actionEvent) {
        final FileChooser fileChooser = new FileChooser();

        List<File> list =
                fileChooser.showOpenMultipleDialog(((Node) actionEvent.getSource()).getScene().getWindow());
        if (list != null) {
            list.forEach(this::openFile);
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
                songList.add(new Song(input.getName(), " Нет информации, не получилось переименовать =( "));
            } else {
                songList.add(new Song(input.getName(), newName.getName()));
            }
        } catch (Exception e) {
            System.out.println("Error — " + e.toString());
        }
    }

    @Override
    public ObservableList getFileList() {
        return songList;
    }
}
