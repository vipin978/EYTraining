package day15Proj;

import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LoadXml{
	public static void main(String[] args) throws Exception{
	CustomerData p = LoadXml1.setValues().load();
		p.viewData();
	}
}



class LoadXml1 {
	
	static DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
	static DocumentBuilder db;
	static Document doc;
	
	CustomerData pl = new CustomerData();
	
	public static LoadXml1 setValues() throws Exception {
		dbf.setIgnoringElementContentWhitespace(true);
		dbf.setValidating(true);
		db = dbf.newDocumentBuilder();
		doc = db.parse("src/day15Proj/inputData.xml");
		return new LoadXml1();
	}
	
	public void loadCustomerDetails() {
		Element e = (Element)doc.getElementsByTagName("Bacis").item(0);
		pl.name = e.getElementsByTagName("CustomerName").item(0).getTextContent();
		pl.BillNo = e.getElementsByTagName("BillNo").item(0).getTextContent();
		pl.date = e.getElementsByTagName("BillDate").item(0).getTextContent();
	}
	
	public void loadInvoiceDetails() {
		NodeList n = doc.getElementsByTagName("ItemInfo");
		for(int i = 0;i<n.getLength();i++) {
			List<String> l = new ArrayList<String>();
			Node nNode = n.item(i);
			Element e= (Element)nNode;
//			<S.NO> 1 </S.NO>
//			<Item> Milk </Item>
//			<Unit> 6 </Unit>
//			<Price> 120 </Price>
//			<qty> 4 </qty>
			l.add(e.getElementsByTagName("S.NO").item(0).getTextContent());
			l.add(e.getElementsByTagName("Item").item(0).getTextContent());
			l.add(e.getElementsByTagName("Unit").item(0).getTextContent());
			l.add(e.getElementsByTagName("Price").item(0).getTextContent());
			l.add(e.getElementsByTagName("qty").item(0).getTextContent());
			pl.addItem(l);
		}
	}
	
	public CustomerData load() throws Exception{
		this.loadCustomerDetails();
		this.loadInvoiceDetails();
		return pl;
	}
}

interface DetailsLoader{
	public abstract DetailsLoader addItem(List<String> v);
}


class CustomerData implements DetailsLoader{
	public String name;
	public String BillNo;
	public String date;
	List<List<String>> items = new ArrayList<List<String>>();

	public CustomerData() {
		// TODO Auto-generated constructor stub
	}
	
	public CustomerData(String name,String BillNo,String date) {
		this.name = name;
		this.BillNo = BillNo;
		this.date = date;
	}
	
	@Override
	public DetailsLoader addItem(List<String> v) {
		// TODO Auto-generated method stub
		items.add(v);
		return this;
	}
	
	public void viewData() {
		for(List<String> l:items) {
			System.out.println(l);
		}
	}
}



//class Container{
//	public static PersonLoader getPLObj() {
//		
//	}
//}