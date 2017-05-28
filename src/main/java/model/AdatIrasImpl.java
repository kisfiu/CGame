package model;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class AdatIrasImpl
{
    private DocumentBuilderFactory dbFactory;
    private DocumentBuilder dbuilder;
    private Document doc;
    private TransformerFactory tFactory ;
    private Transformer transformer;
    private DOMSource source;
    private StreamResult result;
    private Element csalad;
    private Element kor_szama;
    private Element terulet;
    private Text akcio_neve;
    public AdatIrasImpl()
    {    
    	try
    	{
	        dbFactory = DocumentBuilderFactory.newInstance();
	        dbuilder = dbFactory.newDocumentBuilder();
	        doc = dbuilder.newDocument();
	        
	        tFactory = TransformerFactory.newInstance();
	        transformer = tFactory.newTransformer();
	        
	        source = new DOMSource(doc);
	        result = new StreamResult(new File("./jatekallas.xml"));
	    
	        transformer.transform(source,result);
    	}
    	catch (Exception e)
    		{e.printStackTrace();}
    }

    public void kor_mentese(String kor)
    {
		kor_szama = doc.createElement(kor);
		doc.appendChild(kor_szama);
	
		try
			{transformer.transform(source,result);}
		catch (Exception e)
				{e.printStackTrace();}	
    }



    public void csaladMentese(String csalad_neve,String arany_mennyiseg,String elelem_mennyiseg) 
    {    
	    csalad = doc.createElement(csalad_neve);
	    kor_szama.appendChild(csalad);
	    
	    Attr vagyon = doc.createAttribute("Vagyon");
	    Attr ellatmany = doc.createAttribute("Ellatmany");
        csalad.setAttributeNode(vagyon);
        csalad.setAttributeNode(ellatmany);
        
        vagyon.setValue(arany_mennyiseg);
        ellatmany.setValue(elelem_mennyiseg);
        
        try
        	{transformer.transform(source,result);}
        catch (Exception re)
        	{re.printStackTrace();}
    }

    public void terulet_akcio_Hozzaadas(String teruletneve,String akcioneve) 
    {
        terulet = doc.createElement(teruletneve);
        csalad.appendChild(terulet);
        
        akcio_neve = doc.createTextNode(akcioneve);
        terulet.appendChild(akcio_neve);
        
        try{transformer.transform(source,result);}
        catch (Exception re){re.printStackTrace();}   
    }    
}