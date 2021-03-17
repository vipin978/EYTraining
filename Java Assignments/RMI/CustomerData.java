package day15Proj;

import java.util.ArrayList;
import java.util.List;

interface DetailsLoader{
	public abstract DetailsLoader addItem(List<String> v);
}


public class CustomerData implements DetailsLoader{
	public String name;
	public String BillNo;
	public String date;
	public List<List<String>> items = new ArrayList<List<String>>();

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