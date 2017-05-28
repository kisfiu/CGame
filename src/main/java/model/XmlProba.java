package model;

import java.io.File;
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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javafx.scene.text.Text;

/**
 *
 * @author kisfiu
 */
public class XmlProba {

    /**
     * @param args the command line arguments
     */
	static String asd;static String asd1;static String asd2;static String pontos1;static String pontos2;
	
	public static void settName1(String playeronetext)     {asd1 = playeronetext;}
	public static void settName2(String playertwotext)     {asd2 = playertwotext;}
	public static void setpontok1(String player1pontok)     {pontos1 = player1pontok;}
	public static void setpontok2(String player2pontok)     {pontos2 = player2pontok;}

	
	public static void main(String[] args) throws TransformerException, ParserConfigurationException 
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;

        builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        
        Element players = doc.createElement("players");
        doc.appendChild(players);
        
        
        Element player = doc.createElement("player");  
        player.setAttribute("name", asd1);          
        players.appendChild(player);

        
        Element matchesplayed = doc.createElement("matchesplayed");
        matchesplayed.setTextContent("8");
        player.appendChild(matchesplayed);

        Element matcheswon = doc.createElement("matcheswon");
        matcheswon.setTextContent("4");
        player.appendChild(matcheswon);
        
        Element matchesdraw = doc.createElement("matchesdraw");
        matchesdraw.setTextContent("0");
        player.appendChild(matchesdraw);
        
        Element points = doc.createElement("points");
        int pontok1 = (Integer.parseInt(matcheswon.getTextContent()) * 5 + Integer.parseInt(matcheswon.getTextContent()) * 3);
        String pontokk1 = Integer.toString(pontok1);
        points.setTextContent(pontos1);
        player.appendChild(points);
        
        
        Element player2 = doc.createElement("player");
        player2.setAttribute("name", asd2);
        players.appendChild(player2);

        Element matchesplayed2 = doc.createElement("matchesplayed");
        matchesplayed2.setTextContent("4");
        player2.appendChild(matchesplayed2);

        Element matcheswon2 = doc.createElement("matcheswon");
        matcheswon2.setTextContent("4");
        player2.appendChild(matcheswon2);
        
        Element matchesdraw2 = doc.createElement("matchesdraw");
        matchesdraw2.setTextContent("4");
        player2.appendChild(matchesdraw2);
        
        Element points2 = doc.createElement("points");
        int pontok2 = (Integer.parseInt(matcheswon2.getTextContent()) * 5 + Integer.parseInt(matcheswon2.getTextContent()) * 3);
        String pontokk2 = Integer.toString(pontok2);
        points2.setTextContent(pontos2);
        player2.appendChild(points2);

        
        
        System.out.println(asd1);
        System.out.println(asd2);
        System.out.println(pontos1);
        System.out.println(pontos2);

        

        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = tFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

        DOMSource source = new DOMSource(doc);
        StreamResult file = new StreamResult(new File("src/main/java/model/output.xml"));

        transformer.transform(source, file);

    }

	

	



}