package day8;

public class Q14 {
	
}

abstract class Student{
	public int rollNo = 100095;
	public String name = "LKDKL";
}

abstract class Exam extends Student{
	public int[] marks = {100,90,90};
	public int totalMarks() {
		int sum = 0;
		for(int i:marks) {
			sum += i;
		}
		return sum;
	}
}

class Result extends Exam{
	
}
