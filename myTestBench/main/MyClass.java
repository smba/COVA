package main;

public class MyClass {
	
	boolean opt_A;
	boolean opt_B;
	
	public MyClass() {
		opt_A = main.Config.getA();
		opt_B = main.Config.getB();
	}
	
	public void foo() {
		System.out.println("Running a method.");
		if (this.opt_A) {
			System.out.println("This is a method.");
		}
		if (Config.getA()) {
			System.out.println("This is also a method.");
		}
	}
	
}