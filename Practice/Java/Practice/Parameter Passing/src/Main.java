class Main {
    int value = 0;

    static void accept_reference(Main e) {
        e.value++; // will change the referenced object
        e = null; // will only change the parameter
    }

    static void accept_primitive(int v) {
        v++;
    } // will only change the parameter

    public static void main(String... args) {
        int value = 0;
        Main ref = new Main(); // reference
    // what we pass is the reference, not the object.
    // the reference is copied (pass-“reference”-by-value)
        accept_reference(ref);
        assert ref != null && ref.value == 1;
        // the primitive int variable is copied
        accept_primitive(value);
        assert value == 0;
    }
}