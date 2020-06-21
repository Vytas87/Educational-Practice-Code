public class Car {
	public void m1() {
		System.out.println("car 1");
	}

	public void m2() {
		System.out.println("car 2");
	}

	public String toString() {
		return "vroom";
	}
}

public class Truck extends Car {
	public void m1() {
		System.out.println("truck 1");
	}

	public void m2() {
		super.m1();
	}

	public String toString() {
		return super.toString() + super.toString();
	}
}
