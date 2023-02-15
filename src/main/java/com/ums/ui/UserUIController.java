package com.ums.ui;

import com.ums.DataSource;
import com.ums.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserUIController implements Initializable {
    public TableView<User> userTable;
    public TableColumn<User, String> nomColumn;
    public TableColumn<User, String> prenomColumn;
    public Label nomLabel;
    public Label prenomLabel;
    public Label emailLabel;
    public Label telephoneLabel;
    public Label loginLabel;
    public Label passwordLabel;
    public Label roleLabel;

    private DataSource dataSource;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nomColumn.setCellValueFactory(cellDataFeatures -> cellDataFeatures.getValue().nomProperty());
        prenomColumn.setCellValueFactory(cellDataFeatures -> cellDataFeatures.getValue().prenomProperty());

        dataSource = new DataSource();
        userTable.setItems(dataSource.getUsers());

        userTable.getSelectionModel().selectedIndexProperty().addListener((observableValue, oldSelection, newSelection) -> {
            if (newSelection != null) {
                updateUser(userTable.getSelectionModel().getSelectedItem());
            }
        });
    }

    private void updateUser(User user) {
        nomLabel.setText(user.getNom());
        prenomLabel.setText(user.getPrenom());
        telephoneLabel.setText(user.getTelephone());
        emailLabel.setText(user.getEmail());
        loginLabel.setText(user.getLogin());
        passwordLabel.setText(user.getPassword());
        roleLabel.setText(user.getRole());

    }

    public void onNewUser(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/ums/ui/edit-user.fxml"));
            Parent parent = fxmlLoader.load();
            User user = new User();
            EditUserController editUserController = fxmlLoader.getController();
            editUserController.setUser(user);
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setTitle("Ajouter d'utilisateur");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setScene(scene);
            editUserController.setStage(stage);
            stage.showAndWait();
            if(editUserController.getUser()!=null){
                User newUser = editUserController.getUser();
                userTable.getItems().add(newUser);
                dataSource.getUsers().add(newUser);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onUpdateUser(ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/ums/ui/edit-user.fxml"));
            Parent parent = fxmlLoader.load();
            EditUserController editUserController = fxmlLoader.getController();
            editUserController.setUser(userTable.getSelectionModel().getSelectedItem());
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setTitle("Mise a jour de l'utilisateur");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setScene(scene);
            editUserController.setStage(stage);
            stage.showAndWait();
            if(editUserController.getUser()!=null){
                User newUser = editUserController.getUser();
                userTable.getItems().add(newUser);
                dataSource.getUsers().add(newUser);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onDeleteUser(ActionEvent actionEvent) {
    }
}
