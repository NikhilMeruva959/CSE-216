public class Animal extends Organism {
    public Animal(String species) {
        super(species); // the superclass’ constructor (and also the inherited
                        // methods) can be called using the 'super' keyword.
    }

    public static void main(String[] args) {
        Animal ant = new Animal("ant");
        ant.setHealth(10); // the 'health' field and the 'setHealth' method are
        System.out.println(ant.getHealth());

// inherited from the superclass Organism.

    }
}