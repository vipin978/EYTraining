package day5;

public class Q31 {
	public static void main(String[] args) {
		Background bg = new Background();
		bg.run();
	}
}

class Background implements Runnable{
	 int i=0;
	 public int run(){
	 while(true){
	 i++;
	 System.out.println("i="+i);
	 } //End while
	 
	 }//End run
	}

// code will cause an compilation error