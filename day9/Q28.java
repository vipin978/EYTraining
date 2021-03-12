package day9;

public class Q28 {
	public static void main(String[] args) {
		String month = "Apr";
		if(month == "Feb" || month == "Mar" || month == "Apr" ||month == "May") {
			System.out.println("Summer Season");
		}
		else if(month == "June" || month == "July" || month == "Aug" || month == "Sep") {
			System.out.println("Rainy Season");
		}
		else {
			System.out.println("Winter");
		}
	}
}
