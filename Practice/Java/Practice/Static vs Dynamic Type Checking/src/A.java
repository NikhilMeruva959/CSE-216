public class A {
    String x;

    public A(){

    }
    public A(String input){
        x=input;
    }
    A me() {
        return this;
    }

    public void doA() {
        System.out.println("Do A");
    }

    public static void main(String[] args) {
        String temp = "apple";
        A myObj = new A(temp);

        String temp2 = "blueberry";
        B myObj2 = new B(temp2);

        System.out.println(myObj.x);
        System.out.println(myObj2.x);

        B myObj3 = new B("black", "blackberry");
        System.out.println(myObj3);
        System.out.println(myObj3.x);
        System.out.println(myObj3.x);

        System.out.println(myObj3.me());

        /*
        new B().me().doB();
        The following line will be illegal, even though the object is being invoked on is a B object.
        The problem is that its reference type is A.
        Compiler doesn't know its real type during compile-time, so it sees the object as type A.
        * */
        new B("black", "blackberry").me().doA();

        //Casting
        ((B) new B().me()).doB();

        new C().me().doA();
       // ((C) new B().me()).doC();


    }
}


