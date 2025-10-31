// Demonstrate Wrapper Class, Autoboxing and Auto-unboxing Concepts in Java.
public class WrapperExample {
    public static void main(String[] args) {
        int num = 10;                 
        Integer obj = num;            
        int value = obj;  
      
        System.out.println("Primitive value: " + num);
        System.out.println("After Autoboxing (Object): " + obj);
        System.out.println("After Auto-unboxing (Primitive again): " + value);
    }
}
