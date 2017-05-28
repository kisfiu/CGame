package view;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.XmlProba;

import java.io.IOException;

import controller.MainApp;

public class StartGameController
{
	@FXML
	private Button letsgobutton;
	
	@FXML
    public void okClicked() throws IOException 
    {        	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Game.fxml"));
        Parent root = loader.load();
        GameController gamecontroller = loader.getController();
        gamecontroller.setName(playeronetext.getText());
        gamecontroller.ssetName(playertwotext.getText());
//        XmlProba.settName(playeronetext.getText());
//        XmlProba.ssettName(playertwotext.getText());

        
       
        if(playeronetext.getText().isEmpty() || playertwotext.getText().isEmpty() || playeronetext.getText().equals(playertwotext.getText()))
        	{letsgobutton.setDisable(true);
        		nameslabel.setText("Hey thats not good");
        	 letsgobutton.setDisable(false);}
        else
        	{letsgobutton.setDisable(false);    letsgobutton.getScene().setRoot(root);}
    }

	@FXML
	private Button gobackbutton;
	@FXML
	private void handBackto(ActionEvent event) throws IOException 
	{		
		Node node=(Node) event.getSource();
		Stage stage=(Stage) node.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("/view/Menu.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML
	private Label nameslabel;
	@FXML
	private Label playeronelabel;
	@FXML
	private Label playertwolabel;
	
	@FXML
	private TextField playeronetext;
	
	@FXML
	private TextField playertwotext;
	
	
    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public StartGameController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

    }
}