package day9;

public class Q31 {
	public static void main(String[] args) {
		int first =2;
		int second = 3;
		int result;
		String operator = "Add";
		switch (operator) {
	      case "Add":
	        result = first + second;
	        break;

	      case "Sub":
	        result = first - second;
	        break;

	      case "Mul":
	        result = first * second;
	        break;

	      case "Div":
	        result = first / second;
	        break;

	      // operator doesn't match any case constant (+, -, *, /)
	      default:
	        System.out.printf("Error! operator is not correct");
	        return;
	    }
		System.out.println(result);
	}
}
