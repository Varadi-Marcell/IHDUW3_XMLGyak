package hu.domparse.IHDUW3;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import java.util.Scanner; 

//Megadom a DomRead osztályt szülőnek mivel már ott implementálva vannak a read metódusok ezért itt már csak megkell őket hívni
public class DomQueryIHDUW3 extends DomReadIHDUW3 {

	public static void main(String[] args) {
		try {
			//Fájl Elérése
			File inputFile = new File("/home/marci/eclipse-workspace/DOMParseIHDUW3/src/XmlIHDUW3.xml");
			//Dom-dokumentum létrehozása az XML dokumentum eléréséhez
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			System.out.println("Gyoker elem :" + doc.getDocumentElement().getNodeName());
			System.out.println("----------------------------");
			
			//Beolvasas
			Scanner myObj = new Scanner(System.in);
			System.out.println("Melyik elemet irassuk ki?");
			String element = myObj.nextLine(); 
			
			NodeList nList = doc.getElementsByTagName(element);
			switch(element) {
			  case "webshop":
					webshopRead(nList);
			    break;
			  case "gitar":
					guitarsRead(nList);
			    break;
			  case "gyarto":
					gyartoRead(nList);
				    break;
			  case "rendelo":
					rendeloRead(nList);
				    break;
			  case "rendeles":
					rendelessRead(nList);
				    break;
			  case "rendelesek":
					rendelesekRead(nList);
				    break;
			  case "fizetes":
					fizetesekRead(nList);
				    break;
			  default:
				  System.out.println("nincs ilyen Elem!");
			}
			myObj.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
