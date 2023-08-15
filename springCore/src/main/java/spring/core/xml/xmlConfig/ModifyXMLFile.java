/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.core.xml.xmlConfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author mohamed.aljazwiee
 */

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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

public class ModifyXMLFile {

	public static void main(String argv[]) {

	   try {
                 File direct=new File("D:\\Programmes\\JAVA PRORAMMING\\Java Important Cods\\Wep Application\\My Owen Application\\NetBeansProjects\\LearningSpring\\src\\java\\resources\\XML");
        
        if(direct.isDirectory())
        {
         File [] files= direct.listFiles();
         
         for(File file:files)
         {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(file);

		// Get the root element

		// Get the staff element , it may not working if tag has spaces, or
		// whatever weird characters in front...it's better to use
		// getElementsByTagName() to get it directly.
		// Node staff = company.getFirstChild();

		// Get the staff element by tag name directly
		NodeList nodeList = doc.getElementsByTagName("bean");
                
                for(int i=0;i<nodeList.getLength();i++)
                {
                    Node node=nodeList.item(i);
                    NamedNodeMap namedNodeMap=node.getAttributes();
                    Node classnode=namedNodeMap.getNamedItem("class");
                    if(classnode!=null)
                    {
                   String oldvalue  = classnode.getNodeValue();
                   String newValue=oldvalue.replace("CoreSpring.XML", "CoreSpring");
                   classnode.setTextContent(newValue);
                    }
                }

		

		

		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(file);
		transformer.transform(source, result);

		System.out.println("Done");
         }
        }
        
	   } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	   } catch (TransformerException tfe) {
		tfe.printStackTrace();
	   } catch (IOException ioe) {
		ioe.printStackTrace();
	   } catch (SAXException sae) {
		sae.printStackTrace();
	   }
	}
}

