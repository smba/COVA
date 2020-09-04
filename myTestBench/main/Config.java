package main;

public class Config {
	
	static boolean FEATURE_A = true;
	static boolean FEATURE_B = false;
	
	public static boolean getA() {
		return Config.FEATURE_A;
	}
	
	public static boolean getB() {
		return Config.FEATURE_B;
	}
	
}