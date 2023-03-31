/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.lab04;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	

	private Model model;
	

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="cmbCorsi"
    private ComboBox<Corso> cmbCorsi; // Value injected by FXMLLoader

    @FXML // fx:id="txtCognome"
    private TextField txtCognome; // Value injected by FXMLLoader

    @FXML // fx:id="txtNome"
    private TextField txtNome; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML // fx:id="txtStudente"
    private TextField txtStudente; // Value injected by FXMLLoader

    @FXML
    void doCercaCorsi(ActionEvent event) {
    	
    	this.txtResult.clear();
    	
    	String matricola = this.txtStudente.getText();
    	
    	int m;
    	
    	try {
    		m = Integer.parseInt(matricola);
    	}catch(NumberFormatException e) {
    		this.txtResult.setText("Inserire un numero!");
    		return;
    	}
    			
		for(Studente s: model.getTuttiGliStudenti()) {
    		if(s.getMatricola() == m) {
    			this.txtResult.appendText("Sono stati trovati "+model.getCorsiStudente(m).size()+" corsi per lo studente "+s.getMatricola()+".\n");
    	    	
    	    	for(Corso c: model.getCorsiStudente(m)) {
    	    		this.txtResult.appendText(c.toString()+"\n");
    	    	}
    	    	return;
    		}
    	}
    	
    	this.txtResult.setText("Non è stato trovato alcuno studente con questa matricola.");

    	

    }
    
    @FXML
    void doCerca(ActionEvent event) {
    	
    	this.txtResult.clear();
    	
    	Corso c = this.cmbCorsi.getValue();
    	
    	if(c==null) {
    		this.txtResult.setText("Selezionare un corso.");
    		return;
    	}
    	
    	String matricola = this.txtStudente.getText();
    	
    	int m;
    	
    	try {
    		m = Integer.parseInt(matricola);
    	}catch(NumberFormatException e) {
    		this.txtResult.setText("Inserire un numero!");
    		return;
    	}
    	
    	for(Studente s: model.getTuttiGliStudenti()) {
    		if(s.getMatricola() == m) {
    			for(Corso c2: model.getCorsiStudente(m)) {
    				if(c2.equals(c)) {
    					this.txtResult.setText("Studente iscritto al corso.");
    					return;
    				}
    			} this.txtResult.setText("Studente non iscritto al corso."); 
    			return;
    		}
    	}
    	
    	this.txtResult.setText("Non è stato trovato alcuno studente con questa matricola.");

    	
    	

    }

    @FXML
    void doCercaIscritti(ActionEvent event) {
    	
    	this.txtResult.clear();
    	
    	Corso c = this.cmbCorsi.getValue();
    	
    	if(c==null) {
    		this.txtResult.setText("Selezionare un corso.");
    		return;
    	}
    	
    	this.txtResult.appendText("Sono stati trovati "+model.getStudentiIscrittiCorso(c).size()+" studenti iscritti al corso "+c.getCodins()+".\n");
    	
    	for(Studente s: model.getStudentiIscrittiCorso(c)) {
    		this.txtResult.appendText(s.toString()+"\n");
    	}
    	

    }

    @FXML
    void doIscrivi(ActionEvent event) {
    	
    	this.txtResult.clear();
    	
    	Corso c = this.cmbCorsi.getValue();
    	
    	if(c==null) {
    		this.txtResult.setText("Selezionare un corso.");
    		return;
    	}
    	
    	String matricola = this.txtStudente.getText();
    	
    	int m;
    	
    	try {
    		m = Integer.parseInt(matricola);
    	}catch(NumberFormatException e) {
    		this.txtResult.setText("Inserire un numero!");
    		return;
    	}
    	
    	for(Studente s: model.getTuttiGliStudenti()) {
    		if(s.getMatricola() == m) {
    			for(Corso c2: model.getCorsiStudente(m)) {
    				if(c2.equals(c)) {
    					this.txtResult.setText("Studente già iscritto al corso.");
    					return;
    				}
    			} boolean iscritto = this.model.getIscritto(s, c);
    			if(iscritto) {
    				this.txtResult.setText("Studente correttamente iscritto al corso.");
    				return;
    			}else {
    				this.txtResult.setText("Impossibile iscrivere lo studente al corso.");
    				return;
    			}
    		}
    	}
    	
    	this.txtResult.setText("Non è stato trovato alcuno studente con questa matricola.");

    	
    	

    }

    @FXML
    void doOk(ActionEvent event) {
    
    	this.txtResult.clear();
    	this.txtNome.clear();
    	this.txtCognome.clear();
    	
    	String matricola = this.txtStudente.getText();
    	
    	int m;
    	
    	try {
    		m = Integer.parseInt(matricola);
    	}catch(NumberFormatException e) {
    		this.txtResult.setText("Inserire un numero!");
    		return;
    	}
    	
    	for(Studente s: model.getTuttiGliStudenti()) {
    		if(s.getMatricola() == m) {
    			this.txtNome.setText(s.getNome());
    			this.txtCognome.setText(s.getCognome());
    			return;
    		}
    	}
    	
    	this.txtResult.setText("Non è stato trovato alcuno studente con questa matricola.");

    }

    @FXML
    void doReset(ActionEvent event) {
    	this.txtCognome.clear();
    	this.txtNome.clear();
    	this.txtResult.clear();
    	this.txtStudente.clear();

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert cmbCorsi != null : "fx:id=\"cmbCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtStudente != null : "fx:id=\"txtStudente\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
    	
    	List<Corso> corsi = this.model.getTuttiICorsi();
		corsi.add(new Corso(" ", 0, " ", 0));
    	cmbCorsi.getItems().addAll(corsi);
   
    }

}
