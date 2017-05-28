//package model;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//import org.w3c.dom.Node;
//import org.w3c.dom.NodeList;
//
//public class Beolvas 
//{
//	
//	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//    DocumentBuilder dbuilder = null;
//
////    builder = factory.newDocumentBuilder();
////    Document doc = builder.newDocument();
//		
//	public List<String> csaladparancsok_kiolvasasa(String csalad){
//	        
//	        List<String> parancsok = new ArrayList<String>();
//	        
//	        File inputFile =new File("Parancsok.xml");
//	        try{
//	            
//	        Document doc = dbuilder.parse(inputFile);}
//	        
//	        catch(Exception c){c.printStackTrace();}
//	        
//	        NodeList nodeList = doc.getElementsByTagName("Parancs");
//	        
//	        for (int i = 0;i<nodeList.getLength();i++){
//	            
//	        Node node = nodeList.item(i);
//	        
//	        if (node.getLastChild().getTextContent() == csalad){
//	         Element element = (Element) node;
//	         parancsok.add(element.getAttribute("Tipus"));
//	         parancsok.add(element.getElementsByTagName("Terulet").item(0).getTextContent());
//	        }   
//	    }
//	        return parancsok;
//	    }
//	}