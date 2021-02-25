package day5;


public class Workout{
	
}


abstract class CarManufacture{
	public abstract void makeSuperCars();
}

//class Jaguar extends CarManufacture{
//	@Override
//	public void makeSuperCars() {
//		System.out.println("Making super cars");
//		
//	}
//}


class Mahindra{
	public void makeSuperCarsMahindra() {
		CarManufacture j = new Tata().getJaguar();
		j.makeSuperCars();
		System.out.println("Selling via Mahindra");
	}
}


class Tata{
	public void makeSuperCarsTata() {
//		class Jaguar extends CarManufacture{
//			public int a=5;
//			@Override
//			public void makeSuperCars() {
//				System.out.println("Making super cars");
//				
//			}
//		}
		new CarManufacture() {
			private int a = 6;
			@Override
			public void makeSuperCars() {
				System.out.println("Making super cars");
				
			}
		}.makeSuperCars();
		System.out.println("Selling via tata");
	}
	
//private	class Jaguar extends CarManufacture{
//		public int a=5;
//		@Override
//		public void makeSuperCars() {
//			System.out.println("Making super cars");
//			
//		}
//	}
//
//public Jaguar getJaguar() {
//	return new Jaguar();
//}

}


