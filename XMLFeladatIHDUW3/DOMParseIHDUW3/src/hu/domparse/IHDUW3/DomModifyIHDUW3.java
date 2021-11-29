package hu.domparse.IHDUW3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomModifyIHDUW3 {
	

	public static void main(String[] args) throws TransformerException {
		//Dom-dokumentum létrehozása az XML dokumentum eléréséhez
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try (InputStream is = new FileInputStream("/home/marci/eclipse-workspace/DOMParseIHDUW3/src/XmlIHDUW3.xml")) {

			DocumentBuilder db = dbf.newDocumentBuilder();

			Document doc = db.parse(is);
			// Bekerjuk a modositani kivant elemet
			Scanner rootElem = new Scanner(System.in);
			System.out.println("Melyik elemet modosítsuk");
			String element = rootElem.nextLine();
			
			Scanner elemID = new Scanner(System.in);
			System.out.println("Add meg az ID-t?");
			String childElementID = elemID.nextLine();
			
			NodeList listOfWebshop = doc.getElementsByTagName(element);

			Scanner elem = new Scanner(System.in);
			System.out.println("Melyik gyerek elemet módosítsuk?");
			String childElement = elem.nextLine();
			
			
			System.out.println("Mi legyen az uj elem erteke?");
			Scanner ujElem = new Scanner(System.in);
			String childElementElementNew = ujElem.nextLine();
			
			for (int i = 0; i < listOfWebshop.getLength(); i++) {
				Node staff = listOfWebshop.item(i);
				if (staff.getNodeType() == Node.ELEMENT_NODE) {
					String id = staff.getAttributes().getNamedItem("id").getTextContent();
					if (childElementID.equals(id.trim())) {

						NodeList childNodes = staff.getChildNodes();

						for (int j = 0; j < childNodes.getLength(); j++) {
							Node item = childNodes.item(j);
							if (item.getNodeType() == Node.ELEMENT_NODE) {

								if (childElement.equalsIgnoreCase(item.getNodeName())) {
									item.setTextContent(childElementElementNew);
								}
								
							}

						}


					}

				}

			}
			
			// Létrehozunk egy TransformerFactory és egy DOMSource objektumot ezzel leegyszerűsítve a kiíratást 
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			System.out.println("-----------Modositas utan-----------");
			StreamResult consoleResult = new StreamResult(System.out);
			transformer.transform(source, consoleResult);
		
		} catch (ParserConfigurationException | SAXException | IOException  e) {
			e.printStackTrace();
		}

	}


}
