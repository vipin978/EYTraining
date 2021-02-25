package day7;

public class BuilderDemo {
	public static void main(String[] args) {
		Computer computer = new Computer.ComputerBuilder("HDDC","RAMC").setBlueThooth("BluethoothSetted").build();
		System.out.println(computer);
	}

}

class Computer{
	
	@Override
	public String toString() {
		return "Computer [HDD=" + HDD + ", RAM=" + RAM + ", graphicsCard=" + graphicsCard + ", blueThooth=" + blueThooth
				+ "]";
	}

	private String HDD;
	private String RAM;
	private String graphicsCard;
	private String blueThooth;
	
	public Computer(ComputerBuilder builder){
		this.HDD = builder.HDD;
		this.RAM = builder.RAM;
		this.graphicsCard = builder.graphicsCard;
		this.blueThooth = builder.blueThooth;
	}
	
	public static class ComputerBuilder{
		private String HDD;
		private String RAM;
		private String graphicsCard;
		private String blueThooth;
		public String getHDD() {
			return HDD;
		}
		
		public ComputerBuilder(String hdd,String ram) {
			this.HDD = hdd;
			this.RAM = ram;
		}
		
		public void setHDD(String hDD) {
			HDD = hDD;
		}
		public String getRAM() {
			return RAM;
		}
		public void setRAM(String rAM) {
			RAM = rAM;
		}
		public String getGraphicsCard() {
			return graphicsCard;
		}
		public ComputerBuilder setGraphicsCard(String graphicsCard) {
			this.graphicsCard = graphicsCard;
			return this;
		}
		public String getBlueThooth() {
			return blueThooth;
		}
		public ComputerBuilder setBlueThooth(String blueThooth) {
			this.blueThooth = blueThooth;
			return this;
		}
		
		public Computer build() {
			return new Computer(this);
		}
		
		
	}
	
}