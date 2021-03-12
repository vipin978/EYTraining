package day9;

public class Q29 {
	public static void main(String[] args) {
		char ch = 'e';
		boolean isVowel = false;
		switch(ch)
		{
		   case 'a' :
		   case 'e' :
		   case 'i' :
		   case 'o' :
		   case 'u' : isVowel = true;
		}
		if(isVowel) {
			System.out.println("It is a vowel");
		}
		else {
			System.out.println("Not a vowel");
		}
		
	}
}
