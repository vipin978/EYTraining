package day13;

public class Q2 {
	public static void main(String[] args) {
		Employeee e = new Employeee("Vipin", 190);
		Employeee e1 = new Employeee("Vipin", 190);
		System.out.println(e.equals(e1));
	}
}


class Employeee {

    String name;
    int age;

    public Employeee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
    	System.out.println("Called");
        if (obj == this)
            return true;
        if (!(obj instanceof Employeee)) {
        	System.out.println("Here");
            return false;}
        Employeee employee = (Employeee) obj;
        System.out.println(employee.getAge() == this.getAge()
                && employee.getName() == this.getName());
        return employee.getAge() == this.getAge()
                && employee.getName() == this.getName();
    }

//     commented    
    	@Override
        public int hashCode() {
            int result=1;
//            result=31*result+age;
//            result=31*result+(name!=null ? name.hashCode():0);
            return result;
        }
}



