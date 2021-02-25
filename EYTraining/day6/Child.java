package day6;

public class Child {
	DogItems item;
	public void happening() {
		item.dogResponse();
	}
}


abstract class DogItems{
	public abstract void dogResponse();
}


class Stick extends DogItems{
	@Override
	public void dogResponse() {
		System.out.println("I'll bite you");
	}
}

class Stone extends DogItems{
	@Override
	public void dogResponse() {
		System.out.println("Ill bark");
		
	}
}
