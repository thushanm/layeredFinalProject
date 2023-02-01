package lk.ijse.dmi.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import lk.ijse.dmi.bo.custom.BOFactory;
import lk.ijse.dmi.bo.custom.UserAddBO;
import lk.ijse.dmi.dto.UserDTO;

import java.sql.SQLException;

public class UserController {
UserAddBO userAddBOimpl = (UserAddBO) BOFactory.getBoFactory().getBo(BOFactory.boType.USER);
    public AnchorPane userAnchor;

    public JFXTextField txtUid;
    public JFXTextField txtName;
    public JFXTextField txtPassword;
    public JFXTextField txtRole;

    public void btnSaveUser(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String uId=txtUid.getText();
        String name =txtName.getText();
        String pass = txtPassword.getText();
        String role = txtRole.getText();
        System.out.println(name);
        System.out.println(role);
        System.out.println(pass);
        System.out.println(uId);

        if(userAddBOimpl.saveUser(new UserDTO(uId,name,pass,role))){
            new Alert(Alert.AlertType.CONFIRMATION,"SUCCUSS ADD").show();

        }
        else {
            new Alert(Alert.AlertType.ERROR,"UNSUCCUSS ADD").show();
        }

    }
}
