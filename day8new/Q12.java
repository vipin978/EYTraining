package day8;

public class Q12 {
	public static void main(String[] args) {
		Harris[] h = new Harris[5];
		h[1] = new HarrisInfotech();
		h[2] = new HarrisPharma();
		System.out.println(h[1].getSalary() + " Salary from slot 2");
		System.out.println(h[2].getSalary() + " Salary from slot 1");
	}
}

abstract class Harris{
	public abstract int getSalary();
}

class HarrisInfotech extends Harris{
	@Override
	public int getSalary() {
		// TODO Auto-generated method stub
		return 100;
	}
	public void teachEducation() {
		System.out.println("Teaching");
	}
}

class HarrisTechnologies extends Harris{
	@Override
	public int getSalary() {
		// TODO Auto-generated method stub
		return 150;
	}
	public void doBuissnessCode() {
		System.out.println("Writing Code");
	}
}

class HarrisPharma extends Harris{
	@Override
	public int getSalary() {
		// TODO Auto-generated method stub
		return 100;
	}
	public void provideMedicine() {
		System.out.println("Giving Medicine");
	}
}



