package day7;

public class CommandDemo {
	
	static Eseva e = new Eseva();
	static Police police = new Police();
	static Corporation corporate = new Corporation();
	static Hospital hospital = new Hospital();
	
	static {
		e.setCommands(0, new AdharCardProblems(police, corporate, hospital));
		e.setCommands(1, new AccidentIssue(police, corporate, hospital));
		e.setCommands(2, new LandIssue(police, corporate, hospital));
	}
	
	public static void main(String[] args) {
		e.execute(0);
		e.execute(1);
	}
}



class Eseva{
	Command[] commands = new Command[5];
	public Eseva() {
		for(int i=0;i<commands.length;i++) {
			commands[i] = new DummyCommand();
		}
	}
	
	public void execute(int index) {
		commands[index].execute();
	}
	
	public void setCommands(int index,Command cmd) {
		commands[index] = cmd;
	}
	
	class DummyCommand extends Command{
		@Override
		public void execute() {
			System.out.println("This is a dummy command");
		}
	}
}

abstract class Command{
	
	public Police police;
	public Corporation corporate;
	public Hospital hospital;
	
	public Command() {
		
	}
	
	public Command(Police police,Corporation corporate,Hospital hospital) {
		this.police = police;
		this.corporate = corporate;
		this.hospital = hospital;
	}
	
	public abstract void execute(); 
}

class AdharCardProblems extends Command{
	public AdharCardProblems(Police police,Corporation corporate,Hospital hospital) {
		super(police,corporate,hospital);
	}
	@Override
	public void execute() {
		System.out.println("Process started");
		corporate.signDocuments();
		corporate.permit();
		System.out.println("Finished");
	}
}

class LandIssue extends Command{
	public LandIssue(Police police,Corporation corporate,Hospital hospital) {
		super(police,corporate,hospital);
	}
	@Override
	public void execute() {
		System.out.println("Process started");
		police.doInvestigation();
		corporate.signDocuments();
		corporate.permit();
		System.out.println("Finished");
	}
}

class AccidentIssue extends Command{
	
	public AccidentIssue(Police police,Corporation corporate,Hospital hospital){
		super(police,corporate,hospital);
	}
	@Override
	public void execute() {
		System.out.println("Process started");
		this.hospital.provideAmbulance();
		this.police.doInvestigation();
		this.police.certify();
		this.hospital.doProcedure();
		System.out.println("Process finished");
		
	}
}


class Police{
	public void doInvestigation() {
		System.out.println("Doing Investigation by police");
	}
	public void certify() {
		System.out.println("Filing reports");
	}
}

class Corporation{
	public void signDocuments() {
		System.out.println("signing the documents");
	}
	public void permit() {
		System.out.println("Providing permit");
	}
}


class Hospital{
	public void doProcedure() {
		System.out.println("Making operation and any other by hospital");
	}
	
	public void provideAmbulance() {
		System.out.println("Providing ambulance service by the Hospital");
	}
}