package day13;
import java.util.HashMap;
import java.util.Map;

public class Q4 {
	public static void main(String[] args) {
		AccountManager am = new AccountManager();
		am.setBalance("Vipin", 1000);
		System.out.println(am.getBalance("Vipin"));
	}
}

class AccountManager {
 private Map<String,Integer> accountTotals = new HashMap<String,Integer>();

 public int getBalance(String accountName) {
 Integer total = (Integer) accountTotals.get(accountName);
 if (total == null)
 total = Integer.valueOf(0);
 return total.intValue();
 }
public void setBalance(String accountName, int amount) {
	accountTotals.put(accountName, Integer.valueOf(amount));
 } } 