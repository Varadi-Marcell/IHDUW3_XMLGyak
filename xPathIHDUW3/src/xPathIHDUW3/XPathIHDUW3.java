package xPathIHDUW3;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class XPathIHDUW3 {
	public static void main(String[] args) {

		try {
			File inputFile = new File("/home/marci/eclipse-workspace/xPathIHDUW3/xPathIHDUW3.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();

			XPath xPath = XPathFactory.newInstance().newXPath();

			String expression = "class";

			NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);

			read(nodeList);

		} catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException e) {
			e.printStackTrace();
		}
	}

	public static void getElement(Element eElement, String elementOut, String elementName) {

		System.out.println(elementOut + " : " + eElement.getElementsByTagName(elementName).item(0).getTextContent());
	}

	public static void read(NodeList nList) {
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			System.out.println("\nAktualis Elem :" + nNode.getNodeName());

			if (nNode.getNodeType() == Node.ELEMENT_NODE && nNode.getNodeName().equals("student")) {
				Element eElement = (Element) nNode;
				System.out.println("ID : " + eElement.getAttribute("id"));

				getElement(eElement, "Keresztnev", "keresztnev");
				getElement(eElement, "Vezeteknev", "vezeteknev");
				getElement(eElement, "Becenev", "becenev");
				getElement(eElement, "Kor", "kor");

			}
		}
	}
}

/*
 * for (int i = 0; i < nodeList.getLength(); i++) { Node node =
 * nodeList.item(i); System.out.println("\nAktuális elem: " +
 * node.getNodeName());
 * 
 * if(node.getNodeType() == Node.ELEMENT_NODE /*&&
 * node.getNodeName().equals("student")) { Element element = (Element) node;
 * 
 * System.out.println("Hallgató ID:" + element.getAttribute("id"));
 * System.out.println("Keresztnev:" +
 * element.getElementsByTagName("keresztnev").item(0).getTextContent());
 * System.out.println("Vezeteknev:" +
 * element.getElementsByTagName("vezeteknev").item(0).getTextContent());
 * System.out.println("Becenev:" +
 * element.getElementsByTagName("becenev").item(0).getTextContent());
 * System.out.println("Kor:" +
 * element.getElementsByTagName("kor").item(0).getTextContent());
 * 
 * } }
 * 
 */