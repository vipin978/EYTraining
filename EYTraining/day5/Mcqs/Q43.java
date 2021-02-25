package day5;


private class Base{
Base(){
 int i = 100;
 System.out.println(i);
 }
}
public class Q43 extends Base{
static int i = 200;
public static void main(String argv[]){
 Q43 p = new Q43();
 System.out.println(i);
 }
}

// Error at compile time