package day8;

public class S2Q4 {
	public static void main(String[] args) {
		InterfaceImpl iT = new InterfaceImpl();
		//iT.passInterface(we cannot pass interfface we need to implement first);
	}
}

interface Int1{
	public void method1();
	public void method2();
}

interface Int2{
	public void method21();
	public void method22();
}

interface Int3{
	public void method31();
	public void method32();
}

interface New extends Int1,Int2,Int3{
	public void newMethod();
}

class Hi{
	
}

class InterfaceImpl extends Hi implements New{
	@Override
	public void method1() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void method2() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void method21() {
		// TODO Auto-generated method stub
		
	}@Override
	public void method22() {
		// TODO Auto-generated method stub
		
	}@Override
	public void method31() {
		// TODO Auto-generated method stub
		
	}@Override
	public void method32() {
		// TODO Auto-generated method stub
		
	}@Override
	public void newMethod() {
		// TODO Auto-generated method stub
		
	}
	
	public void passInterface(Int3 i) {
		
	}
}
