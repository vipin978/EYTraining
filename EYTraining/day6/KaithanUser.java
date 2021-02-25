package day6;
import java.util.*;

public class KaithanUser {
	
	public static void main(String[] args) throws Exception
	
	{
		String def = "State";
		Scanner s = new Scanner(System.in);
		while(true){
			System.out.println("Press enter to pull");
			s.nextInt();
			String stateNo = "day6."+def+String.valueOf(State.getState());
			State stat = Container.getStateObj(stateNo);
			stat.run();
	}
	
	}
}


class Container{
	public static State getStateObj(String stateClass) throws Exception{
		System.out.println(stateClass);
		State s = (State)Class.forName(stateClass).newInstance();
		return s;
	}
}
