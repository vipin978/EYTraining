package day7;

public class CommandDemo2 {

}


class UniversalRemote{
	Command2[] commands = new Command2[5];
	public UniversalRemote() {
		for(int i=0;i<commands.length;i++) {
			commands[i] = new DummyCommand();
		}
	}
	
	public void execute(int index) {
		commands[index].execute();
	}
	
	public void setCommands(int index,Command2 cmd) {
		commands[index] = cmd;
	}
	
	class DummyCommand extends Command2{
		@Override
		public void execute() {
			System.out.println("This is a dummy command");
		}
	}
}

abstract class Command2{
	Tv sony;SetTopBox tata;VGame vGame;SoundSystem ss;
	public Command2() {
		
	}
	public Command2(Tv sony,SetTopBox tata,VGame vGame,SoundSystem ss) {
		this.sony = sony;
		this.tata = tata;
		this.vGame = vGame;
		this.ss = ss;
	}
	
	public abstract void execute();
}

class NewsChannel extends Command2{
	
	public NewsChannel(Tv sony,SetTopBox tata,VGame vGame,SoundSystem ss) {
		super(sony,tata,vGame,ss);
	}
	
	@Override
	public void execute() {
		System.out.println("Process started");
		
		System.out.println("Finish");
	}
}

class PlayVideoGames extends Command2{
	
	public PlayVideoGames(Tv sony,SetTopBox tata,VGame vGame,SoundSystem ss) {
		super(sony,tata,vGame,ss);
	}
	@Override
	public void execute() {
		
		
	}
}



class Tv{
	public void switchOn() {
		System.out.println("tv is swtiched on...");
	}
	public void av1Mode() {
		System.out.println("av1 mode on....");
	}
}

class SetTopBox{
	public void newsChannel() {
		System.out.println("news channel on...");
	}
	public void serialChannel() {
		System.out.println("serial channel on...");
	}
}
class SoundSystem{
	public void lowSound() {
		System.out.println("low sound.......");
	}
	public void highSound() {
		System.out.println("high sound.......");
	}
}
class VGame{
	public void playTennis() {
		System.out.println("play tennis.......");
	}
}