package domIHDUW31026;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


public class DomReadIHDUW3 {

	File xmlFile = new File("usersIHDUW3.xml");
	
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = factory.newDocumentBuilder();
	
	Document doc = dBuilder.parse(xmlFile);
	
	doc.getDocumentElement().normalize();
	
	Element root = document.getDocumentElement();
	System.out.println(root.getNodeName());
	
	NodeList nList = document.getElementsByTagName("user");
	System.out.println("============================");

	for(int i=0;i<nList.getLength(); i++) {
		
		Node nNode = nList.item(i);
		System.out.println("\nCurrent Element: " + nNode.getNodeName());
		if(nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element elem = (Element) nNode;
			String uid = elem.getAttribute("id");
			Node node1 = elem.getElementsByTagName("firstname").item(0);
			String fname = node1.getTextContent();
			
			Node node2 = elem.getElementsByTagName("lastname").item(0);
			String lname = node2.getTextContent();
			
			Node node3 = elem.getElementsByTagName("profession").item(0);
			String pname = node3.getTextContent();
			
			System.out.println("User id: %s%n" + uid);
			System.out.println("First name: %s%n" + fname);
			System.out.println("Last name %s%n" + lname);
			System.out.println("Profession: %s%n" + pname);
		}
	}
}
}