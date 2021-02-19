package day3;
import java.util.*;


//0

public class Day1 {
	public static void main(String[] args) {
		// for testing
	}
}


// 1

class HelloWorld{ // print Hello World
	public void printConsole() {
		System.out.println("Hello World");
	}
}

// 2 and 3

class DefaultValues{ // printing default values
	private int integer;
	private char character;
	private float fl;
	private boolean bool;
	private byte b;
	
	public void printingDefaultValues() {
		System.out.println("INT:"+integer);
		System.out.println("CHAR:"+character);
		System.out.println("FLOAT:"+fl);
		System.out.println("BOOLEAN:"+bool);
		System.out.println("BYTE"+b);
	}
	
}


// 4

class PrimeOrNot{ // Finding whether prime or not
	public static boolean isPrime(int number) {
		boolean isprime = true;
		if (number % 2 == 0) {
			isprime = false;
		}
		else {
			for (int i = 3; i < number; i++) {
				  if (number%i == 0) {
					  isprime = false;
				  }
				  else {
					  i+=1;
				  }
				}
		}
		return isprime;
	}
}

//5

class AverageOfN{ // finding the average of N numbers
	public static int findAvg(int... n) {
		int avg = 0;
		for(int i:n) {
			avg += i;
			avg = avg / 2;
		}
		return avg;
	}
}


// 6

class ResizeArray{ // resizing array
	public static int[] resizing(int[] array) {
		array = Arrays.copyOf(array, array.length + 1);
		return array;
	}
}


// 7
 
class Sort{ // sorting in ascending order and descending order
	public static int[] AscSort(int[] arr) {
		int swap;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 1;j < arr.length-i;j++) {
				if (arr[j-1] < arr[j]) {
					swap = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = swap;
				}
			}
		}
		return arr;
	}
	
	public static int[] DscSort(int [] arr) {
		int swap;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 1;j < arr.length-i;j++) {
				if (arr[j-1] > arr[j]) {
					swap = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = swap;
				}
			}
		}
		return arr;
	}
}


// 8

class Finder{ // finding the position of the element in the array
	public static int FindEle(int[] arr,int element) {
		int position = -1;
		for(int i=0;i<arr.length;i++) {
			if (arr[i] == element) {
				position = i;
				break;
			}
		}
		
		return position;
	}
}


// 9

class  Rev{ // reversing the elements in an array
	public static int[] ReverseElements(int[] arr) {
		int swap;
		int last = arr.length;
		for(int i=0;i<arr.length/2;i++) {
			swap = arr[i];
			arr[i] = arr[last-1-i];
			arr[last-1-i] = swap;
		} 
	return arr;	
	}
	
}


// 10 and 11

class MatrixDisplay{
	
	public void Matdisplay(int[][] mat) {
		for(int i=0 ;i<mat.length;i++) {
			for(int j : mat[i]) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
	
	public void pyrDisplay(int[][] mat) {
		//
	}
}


//12

class CmdAccess{ // accessing command line arguments
	public static void main(String[] args) {
		for(int i=0;i<args.length;i++) {
			System.out.println(args[i]);
		}
	}
}

// 13

class ScoreBoard{ // Calculating scores of students in a matrix
	
	private int noOfStudents;
	private int marks;
	private int[][] matrix;
	
	ScoreBoard(int noOfStudents,int marks){
		this.noOfStudents = noOfStudents; // row
		this.marks = marks; // column 
		this.matrix = new int[this.noOfStudents][this.marks];
	}
	
	public void inputMarks() {
		Scanner sc= new Scanner(System.in);
		for(int i = 0;i<this.noOfStudents;i++) {
			for(int j =0;j<this.marks;j++) {
				System.out.println("Enter marks of student no "+(i+1)+"subject no "+(j+1));
				int mark = sc.nextInt();
				this.matrix[i][j] = mark;
			}
		}
	}
	
	public int[] result() {
		int[] resultArr = new int[this.noOfStudents];
		for(int i = 0;i<this.noOfStudents;i++) {
			int avgResult = 0;
			for(int j =0;j<this.marks;j++) {
				avgResult += this.matrix[i][j];
				avgResult = avgResult/ 2;
			}
			resultArr[i] = avgResult;
		}
		return resultArr;
	}

}

//14

// javadoc finished 
// we can compile using file name and run using class name
// It will give error as jvm expects a static main method


//15
class Numbers{
	
	ArrayList<Integer> primeList = new ArrayList<>();
	private boolean isPAP; // PAP - Perfect or Amstrong or Palindrome 
	
	public ArrayList<Integer> createList() {
		for(int i = 1;i<=100;i++) {
			if(PrimeOrNot.isPrime(i) == true) {
				this.primeList.add(i);
			}
		}
		return this.primeList;
	}
	
	public boolean isAmstrong(int num) {
		
		int originalNumber, remainder, result = 0;

        originalNumber = num;

        while (originalNumber != 0)
        {
            remainder = originalNumber % 10;
            result += Math.pow(remainder, 3);
            originalNumber /= 10;
        }

        if(result == num)
        	return true;
        else
        	return false;
		
	}
	
	public boolean isPerfect(int num) {
		boolean isPerfect;
		int sum = 0;
		for(int i = 1; i < num; i++)
        {
            if(num % i == 0)
            {
                sum = sum + i;
            }
        }
		if(sum == num)
            isPerfect =  true;
        else
            isPerfect = false;
		return isPerfect;
	}
	
	public boolean isPalindrome(int num) {
		int r,sum=0,temp;     
		temp=num;    
		while(num>0)
		{
			r=num%10;  
			sum=(sum*10)+r;    
			num=num/10;    
		}    
		if(temp==sum)
			return true;
		else    
		    return false;
	}
	
	public boolean isPap(int num) {
		if (this.isPalindrome(num) || this.isPerfect(num) || this.isAmstrong(num)) {
			this.isPAP = true;
		}
		else {
			this.isPAP = false;
		}
		return isPAP;
	}
		
}

//16.

class Search{ // find an element and return the count
	public static int[] isPresent(int[] arr,int ele) {
		int[] result = {-1,-1};
		int count = 0;
		for(int i:arr) {
			if(i == ele) {
				result[0] = 1;
				count += 1;
			}
		
		}
		result[1] = count;
		return result;
	}
}

// 17.
class ExceptionHandling{
	final int i = 1;
	private static int a = 1;
	private int d;
	
	ExceptionHandling(int d){
		this.d = d;
	}
	
	public void accesing() {
		try {
			i = 0;
			System.out.println(a);
			
		}
		catch (Exception e) {
			System.out.println("Error check code");
		}
	}
	
}


// 18.

class Translator{
	private List<String> mapArray = new ArrayList<>(Arrays.asList("one","two","three","four","five","six","seven","eight","nine"));
	
	public String translate(int num) {
		
		String result = "";
		LinkedList<Integer> stack = new LinkedList<Integer>();
		while(num>0)
		{
			stack.push(num%10);
			num=num/10;    
		}
		while (!stack.isEmpty()) {
		    result = result + mapArray.get(stack.pop()-1) + " ";
		}
		
		return result;
	}

}


// 19.
class ReverseRowMat{
	public int[][] reverseRows(int[][] mat){
		for(int i =0 ;i<mat.length;i++) {
			mat[i] = Rev.ReverseElements(mat[i]);
		}
		return mat;
	}
}

// 20.

class FindLargest{
	public int[] findLargestinRows(int[][] mat) {
		int[] result = new int[mat.length];
		
		for(int i =0 ;i<mat.length;i++) {
			result[i] = Arrays.stream(mat[i]).max().getAsInt();
		}
		
		return result;
	}

}

// 21.
class Switch{
	public int daysFinder(int month,int year) {   
			int days; 
	        switch (month) { 
	        case 1: 
	            days = 31; 
	            break; 
	        case 2: 
	        	if(year % 4 == 0)
	        		days = 29;
	        	else
	        		days = 28;
	            break; 
	        case 3: 
	            days = 31; 
	            break; 
	        case 4: 
	            days = 30; 
	            break; 
	        case 5: 
	            days = 31; 
	            break; 
	        case 6: 
	            days = 30; 
	            break; 
	        case 7: 
	            days = 31; 
	            break;
	        case 8: 
	            days = 31; 
	            break; 
	        case 9: 
	            days = 30; 
	            break; 
	        case 10: 
	            days = 31; 
	            break; 
	            
	        case 11: 
	            days = 30; 
	            break; 
	            
	        case 12: 
	            days = 31; 
	            break;     
	        default: 
	            days = -1; 
	        
	}
	return days;
}
}

// 22.

class New {
	
	private int pri;
	int noMod;
	protected int pro;
	public int pub;

	public void print() {
		System.out.println(pri);
		System.out.println(noMod);
		System.out.println(pro);
		System.out.println(pub);
	}
	
}


// 23.

class FirstClass{
	protected int a = 3;
}

class SecondClass{
	public void mainpulating() {
		FirstClass fs = new FirstClass();
		System.out.println(fs.a);
	}
}

// 24.

 class QuadraticFn{
	 
	 private int a;
	 private int b;
	 private int c;
	 
	 QuadraticFn(int a,int b,int c){
		 this.setA(a);
		 this.setB(b);
		 this.setC(c);
	 }
	 
	 QuadraticFn(){
		 this(1,1,1);
	 }

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}
	
	public int compute(int x) {
		int xSq = x * x;
		return (this.a*xSq) + (this.b*x) + this.c;
	}
	 
 }
 
 // 25 
 
 // illegal modifier for class base
 
// 26  
 
// We terminate if by ; so there is no link between output and if statement
 
 
 // 27
 
 class InvestmentCalc{
	 
	 public void finalAmt() {
		 float investedAmt = 14000.0f;
		 float firstYear = 1.40f;
		 float secondYear = 1500.0f;
		 float thirdYear = 1.12f;
		 float finalAmt = 0;
		 
		 finalAmt = ((investedAmt * firstYear) - secondYear) * thirdYear;
		
		 System.out.println(finalAmt);
	 }
	 
 }
 
 
 
 
 

