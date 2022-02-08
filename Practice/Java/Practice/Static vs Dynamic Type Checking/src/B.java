public class B extends A {
    String color;
    public B(){
    }
    public B(String input){
        super(input);
        //super keyword in java is a reference variable that is used to refer parent class objects.
        //When creating an B you're creating a A at the same time.
        //To make sure the A is properly constructed, the compiler adds an implicit call to super() in the B constructor:
    }
    public B(String input, String color){
        super(input);
        this.color=color;
    }
    public void doB() {
        System.out.println("Do B");
    }
}