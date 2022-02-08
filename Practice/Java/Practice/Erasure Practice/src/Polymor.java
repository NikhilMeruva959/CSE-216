public class Polymor {
    class A {
        public String show(D obj) {
            return ("A and D");
        }
        public String show(A obj) {
            return ("A and A");
        }
    }
    class B extends A {
        public String show(B obj) {
            return ("B and B");
        }
//        public String show(A obj) {
//            return ("B and A");
//        }
    }
    class C extends B {}
    class D extends B {}
    public static void main(String[] args) {
        Polymor outerclass = new Polymor();
        A a1 = outerclass.new A();
        A a2 = outerclass.new B();
        B b = outerclass.new B();
        C c = outerclass.new C();
        D d = outerclass.new D();
        System.out.println("1:" + a1.show(b));//A and A because B is a subtype of A
        System.out.println("2:" + a1.show(c));//A and A because C is a subtype of B and B is a subtype of A
        System.out.println("3:" + a1.show(d));//A and D because specified show


// B object at the address but it is defined as a A so the show(B obj) method does not exist.
// (Basically, with the B object, the A acts as a wrapper or an interface for the B object
// so anything that doesn’t exist in the interface (in this case the methods defined in A) technically doesn’t
// exist to the user who uses the interface). (Overriding is still done though)
        System.out.println();
        System.out.println(a2.getClass());
        System.out.println(b.getClass());
        System.out.println("4:" + a2.show(b));//B and A
        System.out.println("5:" + a2.show(c));//B and A
        System.out.println("6:" + a2.show(d));//

        System.out.println("7:" + b.show(b));//B and B
        System.out.println("8:" + b.show(c));//B and B
        System.out.println("9:" + b.show(d));//A and D
    }
}
