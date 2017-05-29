package view;



import javafx.scene.Node;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import controller.MainApp;
import javafx.scene.text.Text;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class ToplistController
{

	
	
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
 
    @FXML private Label name1; @FXML private Label name6; 
    @FXML private Label name2; @FXML private Label name7; 
    @FXML private Label name3; @FXML private Label name8; 
    @FXML private Label name4; @FXML private Label name9; 
    @FXML private Label name5; @FXML private Label name10; 
    
    @FXML private Label points1; @FXML private Label points6; 
    @FXML private Label points2; @FXML private Label points7; 
    @FXML private Label points3; @FXML private Label points8; 
    @FXML private Label points4; @FXML private Label points9; 
    @FXML private Label points5; @FXML private Label points10; 
	
//    GameController gamecontroller = loader.getController();
    
//        SetToplist.valami();

    
    public String asd;
    
    @FXML
    Button muta;
//    @FXML
//    private void mutasd () throws TransformerException, ParserConfigurationException, IOException, SAXException
//    {
//    	points1.setText("1");
//    }
//    
//    
    @FXML
    public void mutasd() throws TransformerException, ParserConfigurationException, IOException, SAXException 
    {
		DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();   
		domFactory.setIgnoringComments(true);  
		DocumentBuilder builder = domFactory.newDocumentBuilder();   
		Document doc = builder.parse(new File("src/main/java/model/merged.xml"));   
	
		NodeList nodes = doc.getElementsByTagName("player");  
		
		int[] array = new int[nodes.getLength()];
		String[] arraynev = new String[nodes.getLength()];
		String frommerged;
		String frommergednev;
		int Ifrommerged;
		int osszehas;
		int k = 0;
		
		
		for(int j=0; j<nodes.getLength(); j=j+1)
		{	
			org.w3c.dom.Node Nmerged = nodes.item(j);
			Element Emerged = (Element) Nmerged;
	        String nevmerged = Emerged.getAttribute("name");
			System.out.println(nevmerged);
			
			frommerged = Emerged.getElementsByTagName("points").item(0).getTextContent();
			frommergednev = Emerged.getAttribute("name");
			arraynev[k]= frommergednev;

			
			Ifrommerged = Integer.parseInt(frommerged);
			array[k]= Ifrommerged;
			k++;
		}
		int[] ezaregi = array;
		Arrays.sort(array);		
		System.out.println("\n_________\n" + Arrays.toString(ezaregi));

		System.out.println(Arrays.toString(array));
		
		
		// in reverse order
//		System.out.println(array);
		for (int i = array.length - 1; i >= 0; i--)
		    System.out.print(array[i] + " ");
		
		
		
		for(int i = 0; i < array.length / 2; i++)
		{
		    int temp = array[i];
		    array[i] = array[array.length - i - 1];
		    array[array.length - i - 1] = temp;
		}
		System.out.println("\n\n" + array[0]);
		System.out.println("\n_________\n" + Arrays.toString(arraynev));

		System.out.println("\n_________\n" + Arrays.toString(ezaregi));
		
		String pont1 = Integer.toString(array[0]);
		String pont2 = Integer.toString(array[1]);
		String pont3 = Integer.toString(array[2]);
		String pont4 = Integer.toString(array[3]);
		String pont5 = Integer.toString(array[4]);
		String pont6 = Integer.toString(array[5]);
		String pont7 = Integer.toString(array[6]);
		String pont8 = Integer.toString(array[7]);
		String pont9 = Integer.toString(array[8]);
		String pont10 = Integer.toString(array[9]);
	
		System.out.println(pont1);

		this.points1.setText(pont1);
		this.points2.setText(pont2);
		this.points3.setText(pont3);
		this.points4.setText(pont4);
		this.points5.setText(pont5);
		this.points6.setText(pont6);
		this.points7.setText(pont7);
		this.points8.setText(pont8);
		this.points9.setText(pont9);
		this.points10.setText(pont10);
		
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("\n\n_________________________toplistcreated_________________________");
   
    }	    
	
    
 }