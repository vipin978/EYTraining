package day5;

public class Q45 {

public static void main(String argv[]){
 Q45 r = new Q45();
 r.amethod(r);
 }
 public void amethod(Q45 r){
 int i=99;
 multi(r);
 System.out.println(i);
 }
 public void multi(Q45 r){
 r.i = r.i*2;
 }
} 


// compile time error