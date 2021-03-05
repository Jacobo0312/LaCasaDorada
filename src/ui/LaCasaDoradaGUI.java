package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import model.LaCasaDorada;

public class LaCasaDoradaGUI {
    
    @FXML
    private BorderPane pane;
    
    private LaCasaDorada laCasaDorada;

	public LaCasaDoradaGUI(LaCasaDorada controller) {
        laCasaDorada = controller;
	}

//Window of welcome--------------------------------------------
    @FXML
    public void loadWelcome(ActionEvent event) throws IOException {
  
    }

    
}
