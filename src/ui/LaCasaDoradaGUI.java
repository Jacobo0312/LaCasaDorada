package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import model.LaCasaDorada;
import model.User;

public class LaCasaDoradaGUI {

    @FXML
    private BorderPane pane;

    @FXML
    private TextField txtUser;

    @FXML
    private PasswordField txtPassword;
    
    @FXML
    private TextField createUserFN;

    @FXML
    private TextField createUserLN;

    @FXML
    private PasswordField createUserPA;

    @FXML
    private TextField createUserId;

    @FXML
    private TextField createUserUS;

    private LaCasaDorada laCasaDorada;

    public LaCasaDoradaGUI(LaCasaDorada controller) {
        laCasaDorada = controller;
    }

    // Window of welcome--------------------------------------------
    @FXML
    public void loadWelcome(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
        fxmlLoader.setController(this);
        Parent login = fxmlLoader.load();
        pane.getChildren().clear();
        pane.setCenter(login);
    }

    // Options of the login

    @FXML
    public void login(ActionEvent event) {
        User user = laCasaDorada.getUser(txtUser.getText(), txtPassword.getText());

        if (user == null) {
            txtUser.clear();
            txtPassword.clear();

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Log in incorrect");
            alert.setHeaderText(null);
            alert.setContentText("The username and password given are incorrect");

            alert.showAndWait();

        } else {
            //loginUser = user.getUsername();
            //loadTable(event);

        }

    }

    //Load window of form

    @FXML
    public void loadFormulario(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Form.fxml"));
        fxmlLoader.setController(this);
        Parent form = fxmlLoader.load();
        pane.getChildren().clear();
        pane.setCenter(form);
    }


//Create a new user

    @FXML
    public void addUser(ActionEvent event) {
        boolean valid=true;
     String firstName=createUserFN.getText();
     String lastName=createUserLN.getText();
     String id=createUserId.getText();
     String user=createUserUS.getText();
     String password=createUserPA.getText();
     if (firstName.isEmpty() || lastName.isEmpty() || id.isEmpty() || user.isEmpty() || password.isEmpty())valid = false;

     if (valid) {

        laCasaDorada.addUser(firstName,  lastName,  id, user,  password);

        //loadTable(event); cargar para hacer pedidos

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Account created");
        alert.setHeaderText(null);
        alert.setContentText("The new user has been created");
        alert.showAndWait();

    } else {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Validation Error");
        alert.setHeaderText(null);
        alert.setContentText("You must fill each field in the form");

        alert.showAndWait();

    }


    }

}
