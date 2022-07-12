package Controllers;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import util.CrudUtill;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Student {
    public AnchorPane root;
    public JFXTextField txtname;
    public JFXTextField txtid;
    public JFXTextField txtemail;
    public JFXTextField txtcon;
    public JFXTextField txtaddress;
    public JFXTextField txtAddress;
    public Button txtbtn;
    public Button txtupdate;
    public TableView tblStudent;
    public JFXTextField txtnic;
    public TableColumn cold;
    public TableColumn colName;
    public TableColumn colEmail;
    public TableColumn colCont;
    public TableColumn colAddress;
    public TableColumn colNic;

    public void initialize()  {
        cold.setCellValueFactory(new PropertyValueFactory("stuid"));
        colName.setCellValueFactory(new PropertyValueFactory("StuName"));
        colEmail.setCellValueFactory(new PropertyValueFactory("Email"));
        colCont.setCellValueFactory(new PropertyValueFactory("Contact"));
        colAddress.setCellValueFactory(new PropertyValueFactory("address"));
        colNic.setCellValueFactory(new PropertyValueFactory("nic"));




        try {
            loadAllStudent();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadAllStudent() throws SQLException, ClassNotFoundException {

        ResultSet result = CrudUtill.execute("SELECT * FROM Student");
        ObservableList<Model.Student> obList = FXCollections.observableArrayList();
        System.out.println("ok");
        while (result.next()){
            obList.add(
                    new Model.Student(
                            result.getString("Student_id"),
                            result.getString("Student_name"),
                            result.getString("email"),
                            result.getString("contact"),
                            result.getString("address"),
                            result.getString("nic")

                            )

            );
        }
        tblStudent.setItems(obList);
    }


    public void btnonSearch(ActionEvent actionEvent) {
        Search();
    }
    private void Search(){
        try {
            ResultSet result = CrudUtill.execute("SELECT * FROM Student  WHERE Student_id ='"+txtid.getText()+"'");
            if (result.next()){
                txtname.setText(result.getString(2));
                txtemail.setText(result.getString(3));
                txtcon.setText(result.getString(4));
                txtaddress.setText(result.getString(5));
                txtnic.setText(result.getString(6));

            }else {
                new Alert(Alert.AlertType.WARNING, "Empty Result").show();
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void btnonadd(ActionEvent actionEvent) {
        Model.Student S = new Model.Student(
                txtid.getText(),
                txtname.getText(),
                txtemail.getText(),
                txtaddress.getText(),
                txtcon.getText(),
                txtnic.getText()
        );

        try {
            if (CrudUtill.execute("INSERT INTO Student VALUES(?,?,?,?,?,?)",
                    S.getStuid(),S.getStuName(),S.getEmail(),S.getAddress(),S.getContact(),S.getNic())){
                new Alert(Alert.AlertType.CONFIRMATION,"Saved").show();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            new  Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    public void btnonupdate(ActionEvent actionEvent) {

        Model.Student S = new Model.Student(
                txtid.getText(),
                txtname.getText(),
                txtemail.getText(),
                txtcon.getText(),
                txtaddress.getText(),
                txtnic.getText()
        );
        try {
            boolean isupdated = CrudUtill.execute
                    ("UPDATE Student  SET Student_name=?,email=?,contact =?,address =?,nic =? WHERE Student_id = ?"
                 , S.getStuName(),S.getEmail(),S.getContact(),S.getAddress(),S.getNic(),S.getStuid()
                    );
            if (isupdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Updated!").showAndWait();
                tblStudent.refresh();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again!").show();
            }
            tblStudent.refresh();
        } catch (SQLException | ClassNotFoundException e) {

        }
        try {
            loadAllStudent();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void btnondelete(ActionEvent actionEvent) {
    }
}
