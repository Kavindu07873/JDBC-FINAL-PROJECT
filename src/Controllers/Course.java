package Controllers;

import Model.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import util.CrudUtill;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Course {
    public TableView tblStudent;
    public TableColumn cold;
    public TableColumn colName;
    public TableColumn cocos;
    public TableColumn colouration;
    public TableColumn colAddress;

    public void initialize(){

        cold.setCellValueFactory(new PropertyValueFactory("id"));
        colName.setCellValueFactory(new PropertyValueFactory("name"));
        cocos.setCellValueFactory(new PropertyValueFactory("cost"));
        colouration.setCellValueFactory(new PropertyValueFactory("duration"));
        colAddress.setCellValueFactory(new PropertyValueFactory("sub_id"));

        try {
            loadAllCourse();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void loadAllCourse() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtill.execute("SELECT * FROM course");
        ObservableList<Model.Course> obList = FXCollections.observableArrayList();
        System.out.println("ok");
        while (result.next()){
            obList.add(
                    new Model.Course(
                            result.getString("Course_id"),
                            result.getString("Course_name"),
                            result.getString("Cost"),
                            result.getString("Duration"),
                            result.getString("Subject_id")

                    )

            );
        }
        tblStudent.setItems(obList);
    }
}
