package day8;

public class Q2 {
	double my_real1;
	double my_imag1;
	double my_real2;
	double my_imag2;
	public Q2(double my_real1, double my_imag1,double my_real2, double my_imag2){
	      this.my_real1 = my_real1;
	      this.my_imag1 = my_imag1;
	      this.my_real2 = my_real2;
	      this.my_imag2 = my_imag2;
	   }
	
	public void add() {
		System.out.println("Real:"+(this.my_real1+this.my_real2)+"Imag:"+(this.my_imag1+this.my_imag2));
	}

	
}
