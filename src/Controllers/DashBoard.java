package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class DashBoard {
    public Button btnStudent;
    public AnchorPane root;

    public void btnOnActionStudent(ActionEvent actionEvent) throws IOException {
        this.root.getChildren().clear();
        this.root.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/Student.fxml")));
    }

    public void btnOnSubject(ActionEvent actionEvent) {




    }

    public void btnOnSearch(ActionEvent actionEvent) {
    }

    public void btnOnCourse(ActionEvent actionEvent) throws IOException {
        this.root.getChildren().clear();
        this.root.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/Course.fxml")));
    }
}
