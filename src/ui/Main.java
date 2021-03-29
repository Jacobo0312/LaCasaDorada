package ui;


import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.LaCasaDorada;


public class Main extends Application {
    

    private LaCasaDoradaGUI laCasaDoradaGUI;
    private LaCasaDorada laCasaDorada;

    public Main() throws ClassNotFoundException, IOException {
            laCasaDorada = new LaCasaDorada();
            laCasaDoradaGUI = new LaCasaDoradaGUI(laCasaDorada);
        
    }

    public static void main(String [] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Welcome.fxml"));

		fxmlLoader.setController(laCasaDoradaGUI);
		Parent root = fxmlLoader.load();
        Image icon= new Image("/img/casa-dorada-editada.png");
        primaryStage.getIcons().add(icon);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("LA CASA DORADA");
		primaryStage.show();

    }



}
