package com.ums.ui;

import com.ums.model.Role;
import com.ums.model.RoleEnum;
import com.ums.model.User;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class EditUserController implements Initializable {
    public TextField lastnameField;
    public TextField firstnameField;
    public TextField phoneField;
    public TextField emailField;
    public TextField loginField;
    public PasswordField passwordField;
    public ComboBox<Role> roleComBo;
    public Button btnAdd;
    public Button btnCancel;

    private User user;

    private List<Role> roles = new ArrayList<>(List.of(new Role("Utilisateur", RoleEnum.SIMPLE_USER), new Role("Administrateur", RoleEnum.ADMINISTRATEUR)));
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        roleComBo.getItems().addAll(roles);
    }

    public void updateInterface() {
        if (!user.getNom().isEmpty()){
            lastnameField.setText(user.getNom());
            firstnameField.setText(user.getPrenom());
            emailField.setText(user.getEmail());
            phoneField.setText(user.getTelephone());
            roleComBo.getSelectionModel().select(roles.stream().filter(role -> Objects.equals(role.getName(), user.getRole())).findFirst().get());
        }
    }

    public void onAddUser(ActionEvent actionEvent) {


        user = new User(lastnameField.getText().trim(), lastnameField.getText().trim(), emailField.getText().trim(), phoneField.getText().trim(), roleComBo.getSelectionModel().getSelectedItem());
        Platform.runLater(() -> closeStage(actionEvent));
    }

    public void onCancel(ActionEvent actionEvent) {
        closeStage(actionEvent);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        updateInterface();
    }

    private void closeStage(ActionEvent event) {
        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void setStage(Stage stage) {
        stage.setOnCloseRequest(event -> user = null);
    }
}
