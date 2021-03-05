package ui;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.LaCasaDorada;


public class Main extends Application {
    

    private LaCasaDoradaGUI laCasaDoradaGUI;
    private LaCasaDorada laCasaDorada;

    public Main() {
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
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("LA CASA DORADA");
		primaryStage.show();

    }

}
