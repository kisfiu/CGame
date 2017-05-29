package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javafx.scene.text.Text;

public class Merge {
	
	public static void main(String[] args) throws TransformerException, ParserConfigurationException, IOException, SAXException 
    {
	DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();   
	domFactory.setIgnoringComments(true);  
	DocumentBuilder builder = domFactory.newDocumentBuilder();   
	Document doc = builder.parse(new File("src/main/java/model/merged.xml"));   
	Document doc1 = builder.parse(new File("src/main/java/model/output.xml"));   

	NodeList nodes = doc.getElementsByTagName("player");  

	NodeList nodes1 = doc1.getElementsByTagName("player");

	
	int elsonem = 0;
	int masodiknem = 0;
		
		Node nNode = nodes1.item(0);
		Element e1 = (Element) nNode;
		String asd = e1.getAttribute("name");
		for(int j=0; j<nodes.getLength(); j=j+1)
		{

			Node nNode2 = nodes.item(j);
			Element e2 = (Element) nNode2;
	        String asd2 = e2.getAttribute("name");
			System.out.println(asd);
			System.out.println(asd2);
			
			if(asd.equals(asd2))
			{
				
				System.out.println("______________takarmany");
				elsonem = 1;
				String mehet = e2.getElementsByTagName("matcheswon").item(0).getTextContent();
				String seged = e1.getElementsByTagName("matcheswon").item(0).getTextContent();
				int mehetne = Integer.parseInt(seged) + Integer.parseInt(mehet);
				mehet = Integer.toString(mehetne);
				System.out.println(mehet);
				e2.getElementsByTagName("matcheswon").item(0).setTextContent(mehet);
				
				mehet = e2.getElementsByTagName("matchesdraw").item(0).getTextContent();
				seged = e1.getElementsByTagName("matchesdraw").item(0).getTextContent();
				mehetne = Integer.parseInt(seged) + Integer.parseInt(mehet);
				mehet = Integer.toString(mehetne);
				e2.getElementsByTagName("matchesdraw").item(0).setTextContent(mehet);

				mehet = e2.getElementsByTagName("points").item(0).getTextContent();
				seged = e1.getElementsByTagName("points").item(0).getTextContent();
				mehetne = Integer.parseInt(seged) + Integer.parseInt(mehet);
				mehet = Integer.toString(mehetne);
				e2.getElementsByTagName("points").item(0).setTextContent(mehet);

				
				break;
			}
			else 
			{
				System.out.println("--------------------megvagy");
			}
		}
		 
		
		
		Node nNodeuj = nodes1.item(1);
		Element e1uj = (Element) nNodeuj;
		String asduj = e1uj.getAttribute("name");		
		for(int j=0; j<nodes.getLength(); j=j+1)
		{

			Node nNode2 = nodes.item(j);
			Element e2 = (Element) nNode2;
			String asd2 = e2.getAttribute("name");
			System.out.println(asduj);
			System.out.println(asd2);
			
			if(asduj.equals(asd2))
			{
				
				System.out.println("______________takarmany");
				masodiknem = 1;
				String mehet = e2.getElementsByTagName("matcheswon").item(0).getTextContent();
				String seged = e1.getElementsByTagName("matcheswon").item(0).getTextContent();
				int mehetne = Integer.parseInt(seged) + Integer.parseInt(mehet);
				mehet = Integer.toString(mehetne);
				System.out.println(mehet);
				e2.getElementsByTagName("matcheswon").item(0).setTextContent(mehet);
				
				mehet = e2.getElementsByTagName("matchesdraw").item(0).getTextContent();
				seged = e1.getElementsByTagName("matchesdraw").item(0).getTextContent();
				mehetne = Integer.parseInt(seged) + Integer.parseInt(mehet);
				mehet = Integer.toString(mehetne);
				e2.getElementsByTagName("matchesdraw").item(0).setTextContent(mehet);

				mehet = e2.getElementsByTagName("points").item(0).getTextContent();
				seged = e1.getElementsByTagName("points").item(0).getTextContent();
				mehetne = Integer.parseInt(seged) + Integer.parseInt(mehet);
				mehet = Integer.toString(mehetne);
				e2.getElementsByTagName("points").item(0).setTextContent(mehet);	
				break;
			}
			else 
			{
				System.out.println("--------------------megvagy");
			}
		}
		
		if(elsonem == 0)
		{
			Node n= (Node) doc.importNode(nodes1.item(0), true);  
			nodes.item(0).getParentNode().appendChild(n);
		}
		if(masodiknem == 0)
		{
			Node n= (Node) doc.importNode(nodes1.item(1), true);  
			nodes.item(1).getParentNode().appendChild(n);
		}
		
		System.out.println(elsonem);
		System.out.println(masodiknem);			
		
//		Node n= (Node) doc.importNode(nodes1.item(i), true);  
//		nodes.item(i).getParentNode().appendChild(n);

	Transformer transformer = TransformerFactory.newInstance().newTransformer();  
	transformer.setOutputProperty(OutputKeys.INDENT, "yes");  

	StreamResult result = new StreamResult(new StringWriter());  
	DOMSource source = new DOMSource(doc);  
	transformer.transform(source, result);  
	Writer output = null;
	output = new BufferedWriter(new FileWriter("src/main/java/model/merged.xml"));

	String xmlOutput = result.getWriter().toString();  
	output.write(xmlOutput);
	output.close();
	System.out.println("merge complete");
}
}