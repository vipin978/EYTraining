package day14;
	

import javax.xml.parsers.DocumentBuilder;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XmlQueryingDemo{
	public static void main(String[] args) throws Exception{
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		dbf.setIgnoringElementContentWhitespace(true);
		dbf.setValidating(true);
		
		
		DocumentBuilder db=dbf.newDocumentBuilder();
		
		Document doc=db.parse("src/day14/first.xml");
		NodeList nList = doc.getElementsByTagName("s");
		
		System.out.println(doc.getDocumentElement().getChildNodes().getLength());
	}
}





//Document
//		documentElement - rootElement(node)
//		getElementsByTagName - nodelist
//		createElement(s)-n
//		createAttribute(s)-n
//		createTextNode(s)-n
//Node
//		-nodeName - string
//		-nodeValue - string
//		-nodeType - int (1-element,2-attribute,3-text....)
//		-firstChild - node
//		-lastChild - node
//		-nextSibling - node
//		-previousSibling - node
//		-childNodes - nodelist
//		-getElementsByTagName - nodelist
//		-hasChildNodes - boolean
//		-attributes - namednodemap
//
//		-appendChild(n) - node
//		-cloneNode(n) - node
//		-insertBefore(n,n)-node
//		-removeNode(n)-node
//NodeList
//		-length - int
//		-item(i) - node
//NamedNodeMap
//		-length - int
//		-getNamedItem()-node
//		-setNamedItem()-node
//		-removeNamedItem()-node