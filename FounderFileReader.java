import javax.xml.parsers.*;

import org.xml.sax.SAXException;
import org.w3c.dom.*;

import java.io.*;

/**
 * 
 * @author Nada Al-Thawr This class is to practice catch and try, parsing and
 *         reading XML files
 *
 */
public class FounderFileReader {
	private static int d = 0;

	/**
	 * main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Setup XML Document
		// We were getting exceptions so we put the code in the try block to be
		// able to run the code
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();

			DocumentBuilder builder = factory.newDocumentBuilder();
			// create a new xml file
			File xmlFile = new File(args[0]);
			Document document = builder.parse(xmlFile);
			// we call and print our method and pass in document as an argument
			System.out.println(parseFounderFile(document).toString());	
			// then we catch all the exceptions
		} catch (ParserConfigurationException e) {
			System.err.println("ParserConfigurationException: "
					+ e.getMessage());
		} catch (SAXException e) {
			System.err.println("SAXException: " + e.getMessage());

		} catch (IOException e) {
			System.err.println("IOException: " + e.getMessage());

		}
	}

	/**
	 * method that navigates through the document structure
	 * 
	 * @param document
	 */
	private static CollegeFounders parseFounderFile(Document document) {
		CollegeFounders founder = new CollegeFounders();
		// create a new node and get the elements in the document
		Node docRoot = document.getDocumentElement();
		// call parse node on the docRoot
		parseNode(docRoot, founder);
		// return CollegeFounders;
		return founder;
	}

	/**
	 * recursive method, is called on all the nodes in the document
	 * 
	 * @param n
	 */
	private static void parseNode(Node n, CollegeFounders founders) {
		// // if the node type equals the element nodes
		// if (n.getNodeType() == Node.ELEMENT_NODE) {
		// // set the element n as current element
		// Element currentElt = (Element) n;
		// // if the current element has attribute, which is the id
		// if (currentElt.hasAttribute("id")) {
		// // get the id and print it
		// currentElt.getAttribute("id");
		// System.out.println("id: " + currentElt.getAttribute("id"));
		// }
		// // if the nodename in currenrElt equals "name","year" or "college"
		// if (currentElt.getNodeName().equals("name")
		// || currentElt.getNodeName().equals("year")
		// || currentElt.getNodeName().equals("college")) {
		// // print the name with the content
		// System.out.println(currentElt.getNodeName() + ": "
		// + currentElt.getTextContent());
		// }
		// // if the node has childnodes
		// if (n.hasChildNodes()) {
		// // create a list that has the child node
		NodeList list = n.getChildNodes();
		// loop through the list
		for (int i = 0; i < list.getLength(); i++) {
			// recursively call parse node on i
			parseNode(list.item(i), founders);
		}
		// if(n.getNodeType()==Founder.Element_NODE){
		//
		// }
		
		//if the node is a Founder
		if (n.getNodeType() == Element.ELEMENT_NODE) {
			//set the current element as n
			Element currentElt = (Element) n;
			//if the node name is equal to founder
			if (currentElt.getNodeName().equals("founder")) {
				//call the method parse founder element on the curent element 
				Founder f = parseFounderElement(currentElt);
				//and add the it to the founders
				founders.addFounder(f);

			}
		}

	}
	/**
	 * 
	 * @param founder
	 * @return Founder(String,String,String,String);
	 */
	private static Founder parseFounderElement(Element founder) {
		//initialize the strings 
		String ID = "";
		String name = "";
		String year = "";
		String college = "";
		//get the id attribute
		ID = founder.getAttribute("id");
		//set the child node list as the child nodes by getting them from the element founder
		NodeList childNodes = founder.getChildNodes();
		//loop through the child nodes 
		for (int i = 0; i < childNodes.getLength(); i++) {
			//one child node could be the i'th item
			Node childNode = childNodes.item(i);
			//if the child node name equals to "name"
			if (childNode.getNodeName().equals("name")) {
				//print the node content
				name = "name: " + childNode.getTextContent();
			//else if it equals to "year"
			} else if (childNode.getNodeName().equals("year")) {
				//print the node content 
				year = "year: " + childNode.getTextContent();
			//else if it equals to college
			} else if (childNode.getNodeName().equals("college")) {
				//print the node text content 
				college = "college: " + childNode.getTextContent();
			}
		}
		//return a new Founder with all the parameters which are the string objects
		return new Founder(ID, name, year, college);

	}
}