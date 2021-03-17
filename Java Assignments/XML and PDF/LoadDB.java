package day15Proj;



//import java.util.HashMap;
import java.util.List;
import day19.*;

//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//import org.w3c.dom.Node;
//import org.w3c.dom.NodeList;

//public class LoadXml{
//	public static void main(String[] args) throws Exception{
//	CustomerData p = LoadXml1.setValues().load();
//		p.viewData();
//	}
//}



//public class LoadXml {
//	
//	static DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
//	static Doc db;
//	static Document doc;
//	
//	CustomerData pl = new CustomerData();
//	
//	public static LoadXml setValues() throws Exception {
//		dbf.setIgnoringElementContentWhitespace(true);
//		dbf.setValidating(true);
//		db = dbf.newDocumentBuilder();
//		doc = db.parse("src/day15Proj/inputData.xml");
//		return new LoadXml();
//	}
//	
//	public void loadCustomerDetails() {
//		Element e = (Element)doc.getElementsByTagName("Bacis").item(0);
//		pl.name = e.getElementsByTagName("CustomerName").item(0).getTextContent();
//		pl.BillNo = e.getElementsByTagName("BillNo").item(0).getTextContent();
//		pl.date = e.getElementsByTagName("BillDate").item(0).getTextContent();
//	}
//	
//	public void loadInvoiceDetails() {
//		NodeList n = doc.getElementsByTagName("ItemInfo");
//		for(int i = 0;i<n.getLength();i++) {
//			List<String> l = new ArrayList<String>();
//			Node nNode = n.item(i);
//			Element e= (Element)nNode;
////			<S.NO> 1 </S.NO>
////			<Item> Milk </Item>
////			<Unit> 6 </Unit>
////			<Price> 120 </Price>
////			<qty> 4 </qty>
//			l.add(e.getElementsByTagName("S.NO").item(0).getTextContent());
//			l.add(e.getElementsByTagName("Item").item(0).getTextContent());
//			l.add(e.getElementsByTagName("Unit").item(0).getTextContent());
//			l.add(e.getElementsByTagName("Price").item(0).getTextContent());
//			l.add(e.getElementsByTagName("qty").item(0).getTextContent());
//			pl.addItem(l);
//		}
//	}
//	
//	public CustomerData load() throws Exception{
//		this.loadCustomerDetails();
//		this.loadInvoiceDetails();
//		return pl;
//	}
//}


public class LoadDB {
	CustomerData pl = new CustomerData();
	InvoiceMasterDTO invDTO;
	InvoiceMasterDAOImpl invDAO = new InvoiceMasterDAOImpl();
	CustomerInfoDTO ciDTO;
	CustomerInfoDAOImpl ciDAO = new CustomerInfoDAOImpl();
	List<ItemsInfoDTO> itinfoDTO;
	ItemsInfoDAOImpl itinfoDAO = new ItemsInfoDAOImpl();
	ItemsDTO itemsDTO;
	ItemsDAOImpl itemsDAO = new ItemsDAOImpl();
	
	
	public static LoadDB setValues() throws Exception {	
		return new LoadDB();
	}
	
	public void loadCustomerDetails(int invId) {
		invDTO = invDAO.getInvoiceMaster(invId);
		ciDTO = ciDAO.getCustomerInfo(invDTO.getCustomer_no());
		pl.name = ciDTO.getCustomer_email();
		pl.BillNo = invDTO.getInv_no();
		pl.date = invDTO.getInv_date();
		System.out.println(pl.date);
	}
	
	public void loadInvoiceDetails(int invId) {
//		itemsDTO = itemsDAO.getItem(invId);
		itinfoDTO = itinfoDAO.getItemInfo(invId);
		for(ItemsInfoDTO it : itinfoDTO) {
			System.out.println(it.getItem_price());
			pl.items.add(it);
		}
	}
	
	public CustomerData load(int invId) throws Exception{
		this.loadCustomerDetails(invId);
		this.loadInvoiceDetails(invId);
		return pl;
	}
}