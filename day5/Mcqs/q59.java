package day5;

public class q59 extends Basess {
	public static void main(String argv[]){
		 q59 o = new q59();
		 int iBase=0;
		 o.amethod(iBase);
		 }
		 public void amethod(int iOver){
		 System.out.println("Over.amethod");
		 } 

}

class Basess{
private void amethod(int iBase){
 System.out.println("Base.amethod");
 }
} 


// over.amethod