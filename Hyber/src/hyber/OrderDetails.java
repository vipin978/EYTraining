package hyber;
//import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

//@Embeddable
@Entity
public class OrderDetails {
	
	@Id @GeneratedValue
	private int id;
	private int price = 1;
	private String dod = "15";
	@ManyToOne
	@JoinColumn(name="book_id")
	private BookDTO book;
	
	public BookDTO getBook() {
		return book;
	}
	public void setBook(BookDTO book) {
		this.book = book;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDod() {
		return dod;
	}
	public void setDod(String dod) {
		this.dod = dod;
	}
	
	
	
}
