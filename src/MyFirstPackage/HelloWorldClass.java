package MyFirstPackage;

public class HelloWorldClass {
    public static void main(String[] args){
        System.out.println("Hello World!");
        Calculator xxx= new Calculator();
        xxx.set(8);
        xxx.getResult();
        System.out.println(xxx.getResult());
    }
}
