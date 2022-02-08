public class Organism {
    private String species;
    private double age;
    private double health;
    public Organism(String species) { this.species = species; }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public String getSpecies() {
        return species;
    }

    public double getAge() {
        return age;
    }

    public double getHealth() {
        return health;
    }
    /* assume getters and setters */
}