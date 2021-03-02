package day3and4;
import java.util.Scanner;

public class Q7 {
	public static void main(String[] args) {
		String nume , denom;
		int ans;
		Scanner s = new Scanner(System.in);
		while(true) {
			System.out.println("Enter the Nume");
			nume = s.nextLine();
			if (nume.equals("Q") || nume.equals("q")) {
				System.out.println("Thanks for using our service");
				break;
			}
			System.out.println("Enter the Denom");
			denom = s.nextLine();
			try {
				ans = Integer.parseInt(nume) / Integer.parseInt(denom);
			}
			catch (Exception e){
				ans = -1;
				System.out.println(e);
			}
			System.out.println("The answer is ..."+ans);
		}
		
	}
}
