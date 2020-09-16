package bench;

public class MyClass {
    public static void main(String[] args) {
        int z;
        int x = 2;
        if (Configuration.getX()) { 
            x = 3;
        } else {
            z = 9;
            MyClass.dos();
            z = 1;
            z = 12;
            z = 13;
            MyClass.dos2();
        }
        
        if (Configuration.getY()) {
            z = 3;
            MyClass.dos2();
            if (x == 3) {
                z = 3;
            }
        }
    }
    
    public static void dos() {
        int r = 33;
    }
    
    public static void foo() {
        int r = 33;
    }
    
    public static void dos2() {
        int r = 33;
    }
}
 
