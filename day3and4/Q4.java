package day3and4;


// Q4 and Q5
public class Q4 {
	public static void main(String[] args) throws Exception {
//		try {
//			throw new MyException("Nothing");
//		}
//		catch(Exception e) {
//			System.out.println(e);
//		}
		G g = new G();
		g.willThrow();
		
	}
}

class G{
	public void willThrow() throws Exception{
		throw new MyException("Should not call this");
	}
}


class MyException extends Exception{
	public String msg;
	public MyException(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {	
		return this.msg;
	}
}