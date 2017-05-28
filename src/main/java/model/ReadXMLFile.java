package model;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class ReadXMLFile {

  public static void main(String argv[]) {

    try {

	File fXmlFile = new File("src/main/java/model/output.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);

	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
	doc.getDocumentElement().normalize();

	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

	NodeList nList = doc.getElementsByTagName("player");

	System.out.println("----------------------------");

	for (int temp = 0; temp < nList.getLength(); temp++) {

		Node nNode = nList.item(temp);

		System.out.println("\nCurrent Element :" + nNode.getNodeName());

		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;

			System.out.println("Player Name : " + eElement.getAttribute("name"));
			System.out.println("Matches played : " + eElement.getElementsByTagName("matchesplayed").item(0).getTextContent());
			System.out.println("Matches won : " + eElement.getElementsByTagName("matcheswon").item(0).getTextContent());
			System.out.println("Matches draw : " + eElement.getElementsByTagName("matchesdraw").item(0).getTextContent());
			System.out.println("Points : " + eElement.getElementsByTagName("points").item(0).getTextContent());

		}
	}
    } catch (Exception e) {
	e.printStackTrace();
    }
  }

}