package hyber;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "book_orders")
public class BookDTO implements Comparable<BookDTO>,Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	private int bid;
	private String bookName,bookauthor;
	private float bookprice;
//	@ElementCollection
//	@GenericGenerator(name = "hilo-gen",strategy = "hilo")
//	@CollectionId(columns = @Column(name="address_id") , generator = "hilo-gen",type = @Type(type = "long"))
	
	@OneToMany(mappedBy = "book")
	public List<OrderDetails> order = new ArrayList<OrderDetails>();
	
//	private Comments comment;
//	
//	public Comments getComment() {
//		return comment;
//	}
//
//	public void setComment(Comments comment) {
//		this.comment = comment;
//	}

	public BookDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public BookDTO(int bid, String bookName, String bookauthor, float bookprice) {
		this.bid = bid;
		this.bookName = bookName;
		this.bookauthor = bookauthor;
		this.bookprice = bookprice;
	}
	
	
	public List<OrderDetails> getOrder() {
		return order;
	}

	public void setOrder(List<OrderDetails> order) {
		this.order = order;
	}

	public int getBid() {
		return bid;
	}
	public void setBid(int bid) { 
		this.bid = bid;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookauthor() {
		return bookauthor;
	}
	public void setBookauthor(String bookauthor) {
		this.bookauthor = bookauthor;
	}
	public float getBookprice() {
		return bookprice;
	}
	public void setBookprice(float bookprice) {
		this.bookprice = bookprice;
	}
	@Override
	public int compareTo(BookDTO o) {
		return this.bookName.compareTo(o.bookName);
	}
	@Override
	public String toString() {
		return "BookDTO [bid=" + bid + ", bookName=" + bookName + ", bookauthor=" + bookauthor + ", bookprice="
				+ bookprice + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bid;
		result = prime * result + ((bookName == null) ? 0 : bookName.hashCode());
		result = prime * result + ((bookauthor == null) ? 0 : bookauthor.hashCode());
		result = prime * result + Float.floatToIntBits(bookprice);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookDTO other = (BookDTO) obj;
		if (bid != other.bid)
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		if (bookauthor == null) {
			if (other.bookauthor != null)
				return false;
		} else if (!bookauthor.equals(other.bookauthor))
			return false;
		if (Float.floatToIntBits(bookprice) != Float.floatToIntBits(other.bookprice))
			return false;
		return true;
	}
	
	
}
