package it.polito.tdp.bar;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.model.Model;
import it.polito.tdp.model.Statistiche;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class BarController {
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtNumber;

    @FXML
    private TextArea txtResult;

    @FXML
    void handleSim(ActionEvent event) {
       	txtResult.clear();
       	int num_gruppi;
		try {
			num_gruppi = Integer.parseInt(txtNumber.getText());
		} catch (NumberFormatException e) {
			txtResult.appendText("Inserire un numero valido\n\n");
			return;
		}
    	Statistiche sta=model.Simula(num_gruppi);
    	txtResult.appendText("Risultati Simulazione: \n\nClienti arrivati:  "+sta.getClienti_number()+
    			"\nClienti soddisfatti:  "+sta.getClienti_soddisfatti()+"\nClienti insoddisfatti:  "+sta.getClienti_insoddisfatti());


    }

    @FXML
    void initialize() {
        assert txtNumber != null : "fx:id=\"txtNumber\" was not injected: check your FXML file 'Bar.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Bar.fxml'.";

    }

    public void setModel(Model model) {
    	this.model = model;
    }
}
