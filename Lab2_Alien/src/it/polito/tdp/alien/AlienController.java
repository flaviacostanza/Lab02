package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */



import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
	private AlienDictionary ad= new AlienDictionary();
	
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;
        
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    	
    }
  
    
    @FXML
    void doTranslate(ActionEvent event) {
    	
       	String daCercare= txtWord.getText().toLowerCase();
    	String array[]= daCercare.split(" ");
    
    	
    	if(array.length==1) {
    		//sto cercando una parola
    		String result= ad.translateWord(array[0]);
    		//devo stampare sulla finestra il risultato
    		txtResult.appendText("Traduzione/i della parola digitata: "+result+"\n");
    		txtWord.clear();
    		
    	}else if(array.length==2) {
    		//sto introducendo una nuova parola
    		ad.addWord(array[0], array[1]);
    		txtResult.appendText("Traduzione aggiornata\n");
    		txtWord.clear();
    	}else{
    		txtResult.appendText("Formato inserimento sbagliato\n");
    		txtWord.clear();
    	}
    }
    
    
    @FXML
    void doReset(ActionEvent event) {
        ad= new AlienDictionary();
    	txtResult.clear();
    	txtWord.clear();
    }
    
}
