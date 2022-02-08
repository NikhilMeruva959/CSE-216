public class Dog {
    String name;
    String bark;

    public Dog(String name, String bark) {
        this.name = name;
        this.bark = bark;
    }

    public static void foo(Dog d) {
        d = new Dog("Fifi", "bow-wow");
    }

    public static void main(String[] args) {
        Dog aDog = new Dog("Max", "woof");
        foo(aDog);
        System.out.println(aDog.bark); // woof, not bow-wow
        System.out.println(aDog.name); // Max, not Fifi
    }
}