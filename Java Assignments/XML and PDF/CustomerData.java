package day15Proj;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import day19.*;

interface DetailsLoader{
	public abstract DetailsLoader addItem(List<String> v);
}


public class CustomerData implements Serializable{
	
	private static final long serialVersionUID = 12L;
	public String name;
	public int BillNo;
	public Date date;
	public List<ItemsInfoDTO> items = new ArrayList<ItemsInfoDTO>();

	public CustomerData() {
		// TODO Auto-generated constructor stub
	}
	
	public CustomerData(String name,int BillNo,Date date) {
		this.name = name;
		this.BillNo = BillNo;
		this.date = date;
	}
	
//	@Override
//	public DetailsLoader addItem(List<String> v) {
//		// TODO Auto-generated method stub
////		items.add(v);
//		return this;
//	}
	
	public void viewData() {
		for(ItemsInfoDTO l:items) {
			System.out.println(l);
		}
	}
}



//class Container{
//	public static PersonLoader getPLObj() {
//		
//	}
//}