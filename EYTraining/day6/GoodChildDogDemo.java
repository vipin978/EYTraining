package day6;
import java.util.*;

public class GoodChildDogDemo{
	public static void main(String[] args) throws Exception{
		Scanner s = new Scanner(System.in);
		System.out.println("What did child did");
		String action = s.nextLine();
		BullDogs dog = new BullDogs();
		NaughtyChilds child = new NaughtyChilds();
		child.playWithDog(dog, Containers.getDogItem("day6."+action));
	}
}


class BullDogs{
	public void play(DogItems item) {
		item.dogResponse();
	}
}
class NaughtyChilds{
	public void playWithDog(BullDogs dog,DogItems item) {
		dog.play(item);
	}
}



class Containers{
	public static DogItems getDogItem(String i) throws Exception {
		DogItems item = (DogItems)Class.forName(i).newInstance();;

		return item;
	}
}
