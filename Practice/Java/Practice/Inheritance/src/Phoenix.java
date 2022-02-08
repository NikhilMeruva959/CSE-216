class Phoenix extends Animal {
    private double lastFireUp;
    public Phoenix(String species) { super(species); }

    @Override
    public double getAge() { return super.getAge() - lastFireUp; }

    public void setLastFireUp(double lastFireUp) {
        this.lastFireUp = lastFireUp;
    }

    public double getLastFireUp() {
        return lastFireUp;
    }

    public static void main(String[] args) {
        Phoenix x = new Phoenix("Morphius");
        x.setLastFireUp(10); // the 'health' field and the 'setHealth' method are
        x.setAge(40);
        System.out.println(x.getAge());

// inherited from the superclass Organism.

    }
}