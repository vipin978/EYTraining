package hyber;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
@NamedQuery(name = "ShopDTO.byItemNo",query = "from ShopDTO where itemNo = ? and itemType = ?"),
@NamedQuery(name = "ShopDTO.everything",query = "from ShopDTO where itemType = ?"),
})
public class ShopDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private int itemNo;
	private String itemName;
	private int itemPrice;
	private String itemURL;
	private int itemType;
	
	public int getItemType() {
		return itemType;
	}
	public void setItemType(int itemType) {
		this.itemType = itemType;
	}
	public int getItemNo() {
		return itemNo;
	}
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getItemURL() {
		return itemURL;
	}
	public void setItemURL(String itemURL) {
		this.itemURL = itemURL;
	}
	
	
}

