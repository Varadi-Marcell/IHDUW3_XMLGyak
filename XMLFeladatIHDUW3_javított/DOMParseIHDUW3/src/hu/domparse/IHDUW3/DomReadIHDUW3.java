package hu.domparse.IHDUW3;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class DomReadIHDUW3 {

	public static void main(String[] args) {
		try {
			//Fájl elérése
			File inputFile = new File("/home/marci/eclipse-workspace/DOMParseIHDUW3/src/XmlIHDUW3.xml");
			//Dom-dokumentum létrehozása az XML dokumentum eléréséhez
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			System.out.println("Gyoker elem :" + doc.getDocumentElement().getNodeName());
			System.out.println("----------------------------");
			
			//Elemek Kiiratasa metódus hívásokkal
			NodeList nList = doc.getElementsByTagName("webshop");
			webshopRead(nList);
			System.out.println("----------------------------");

			NodeList nList2 = doc.getElementsByTagName("gitar");
			guitarsRead(nList2);
			System.out.println("----------------------------");

			NodeList nList3 = doc.getElementsByTagName("gyarto");
			gyartoRead(nList3);
			System.out.println("----------------------------");

			NodeList nList4 = doc.getElementsByTagName("rendelo");
			rendeloRead(nList4);
			System.out.println("----------------------------");

			NodeList nList5 = doc.getElementsByTagName("rendeles");
			rendelessRead(nList5);
			System.out.println("----------------------------");

			NodeList nList6 = doc.getElementsByTagName("rendelesek");
			rendelesekRead(nList6);
			System.out.println("----------------------------");

			NodeList nList7 = doc.getElementsByTagName("fizetes");
			fizetesekRead(nList7);

			System.out.println("----------------------------");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	//Külön metódus a gyerek elemek kiíratására
	public static void getElement(Element eElement, String elementOut, String elementName) {

		System.out.println(elementOut + " : " + eElement.getElementsByTagName(elementName).item(0).getTextContent());
	}
	//Innentől minden Elem kiíratására külön metódus 
	public static void webshopRead(NodeList nList) {
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			System.out.println("\n Gyoker elem :" + nNode.getNodeName());

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				System.out.println("ID : " + eElement.getAttribute("id"));

				getElement(eElement, "webshopnev", "nev");
				getElement(eElement, "utca", "utca");
				getElement(eElement, "varos", "varos");
				getElement(eElement, "iranyitoszam", "iranyitoszam");
				getElement(eElement, "tulajdonos", "tulajdonos");
				getElement(eElement, "alapitva", "alapitva");
				getElement(eElement, "idgitar", "idgitar");
				getElement(eElement, "idrendelo", "idrendelo");


			}
		}
	}

	public static void guitarsRead(NodeList nList) {
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			System.out.println("\n Gyoker elem :" + nNode.getNodeName());

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				System.out.println("ID : " + eElement.getAttribute("id"));

				getElement(eElement, "tipus", "tipus");
				getElement(eElement, "kivitel", "kivitel");
				getElement(eElement, "szin", "szin");
				getElement(eElement, "ar", "ar");
				getElement(eElement, "gyartas", "gyartas");
				getElement(eElement, "idgyarto", "idgyarto");

			}
		}
	}

	public static void gyartoRead(NodeList nList) {
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			System.out.println("\n Gyoker elem :" + nNode.getNodeName());

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				System.out.println("ID : " + eElement.getAttribute("id"));

				getElement(eElement, "orszag", "orszag");
				getElement(eElement, "nev", "nev");
				getElement(eElement, "tulajdonos", "tulajdonos");

			}
		}
	}

	public static void rendeloRead(NodeList nList) {
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			System.out.println("\n Gyoker elem :" + nNode.getNodeName());

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				System.out.println("ID : " + eElement.getAttribute("id"));

				getElement(eElement, "nev", "nev");
				getElement(eElement, "email", "email");
				getElement(eElement, "utca", "utca");
				getElement(eElement, "varos", "varos");
				getElement(eElement, "iranyitoszam", "iranyitoszam");

			}
		}
	}

	public static void rendelessRead(NodeList nList) {
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			System.out.println("\n Gyoker elem :" + nNode.getNodeName());

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				System.out.println("ID : " + eElement.getAttribute("id"));

				getElement(eElement, "statusz", "statusz");
				getElement(eElement, "kiszallito", "kiszallito");
				getElement(eElement, "megjegyzes", "megjegyzes");
				getElement(eElement, "idfiz", "idfiz");


			}
		}
	}

	public static void rendelesekRead(NodeList nList) {
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			System.out.println("\n Gyoker elem :" + nNode.getNodeName());

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				System.out.println("ID : " + eElement.getAttribute("id"));
				getElement(eElement, "idrendelo", "idrendelo");
				getElement(eElement, "idrendeles", "idrendeles");
				getElement(eElement, "darab", "darab");
				getElement(eElement, "feladasdatuma", "feladasdatuma");

			}
		}
	}

	public static void fizetesekRead(NodeList nList) {
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			System.out.println("\n Gyoker elem:" + nNode.getNodeName());

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				System.out.println("ID : " + eElement.getAttribute("id"));
				getElement(eElement, "datum", "datum");
				getElement(eElement, "orszag", "orszag");
				getElement(eElement, "fizetesimod", "fizetesimod");

			}
		}
	}
}
