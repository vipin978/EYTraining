package day9;

public class Q32 {
	public static void main(String[] args) {
		int number= 5;
		boolean isPrime = true;
		if(number == 1 || number%2 == 0) {
			System.out.println("Not a prime number");
			isPrime = false;
		}
		else {
			for(int i=3;i<number;i+=2) {
				System.out.println(i);
				if(number % i == 0) {
					isPrime = false;
					break;
				}
				
			}
		}
		if(isPrime) {
			System.out.println("It is a Prime");
		}
	}
}
