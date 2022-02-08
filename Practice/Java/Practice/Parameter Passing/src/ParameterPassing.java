import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.function.Supplier;

public class ParameterPassing {

    static int r = 0;

    static int add(int x, int y) {
        return r + x + y;
    }

    static int setR() {
        r = 3;
        return 1;
    }

    static double norm(double x, double y) {
        return Math.sqrt(x * x + y * y);
    }
    static <T> void addToCollection(T a, Collection<T> c) { c.add(a); }

    public static void main(String[] args) {
        System.out.println(add(setR(), 2));

        //thunk for pass by name lazy eval
        Supplier<Double> norm23 = () -> norm(2, 3);
        double laterWhenNeeded = norm23.get();

        System.out.println(laterWhenNeeded);

        List<String> strings = new ArrayList<String>();

        addToCollection(strings, new HashSet<>());
//        Collection<?> c = new ArrayList<String>();
//        String str = new String("KGKKGKS");
//        c.add(str);
    }
}