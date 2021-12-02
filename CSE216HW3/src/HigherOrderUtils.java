import java.util.List;
import java.util.Arrays;
import java.util.function.Function;
import java.util.function.BiFunction;
import java.lang.ArithmeticException;

public class HigherOrderUtils {

    interface NamedBiFunction<T, U, R> extends BiFunction<T, U, R> {
        public static String name() {
            return "";
        }
    }

    private static Double division(Double x, Double y) throws ArithmeticException {
        if (y == 0) throw new ArithmeticException("Division by Zero");
        return x / y;
    }

    // instance of interface
    public static NamedBiFunction<Double, Double, Double> add = (a, b) -> a + b;
    public static NamedBiFunction<Double, Double, Double> subtract = (a, b) -> a - b;
    public static NamedBiFunction<Double, Double, Double> multiply = (a, b) -> a * b;
    public static NamedBiFunction<Double, Double, Double> divide = (a, b) -> division(a, b);

    /**
     * Applies a given list of bifunctions -- functions that take two arguments of a certain type
     * and produce a single instance of that type -- to a list of arguments of that type. The
     * functions are applied in an iterative manner, and the result of each function is stored in
     * the list in an iterative manner as well, to be used by the next bifunction in the next
     * iteration. For example, given
     * List<Double> args = Arrays.asList(1d, 1d, 3d, 0d, 4d), and
     * List<NamedBiFunction<Double, Double, Double>> bfs = [add, multiply, add, divide],
     * <code>zip(args, bfs)</code> will proceed iteratively as follows:
     * - index 0: the result of add(1,1) is stored in args[1] to yield args = [1,2,3,0,4]
     * - index 1: the result of multiply(2,3) is stored in args[2] to yield args = [1,2,6,0,4]
     * - index 2: the result of add(6,0) is stored in args[3] to yield args = [1,2,6,6,4]
     * - index 3: the result of divide(6,4) is stored in args[4] to yield args = [1,2,6,6,1.5]
     *
     * @param args:        the arguments over which <code>bifunctions</code> will be applied.
     * @param bifunctions: the list of bifunctions that will be applied on <code>args</code>.
     * @param <T>:         the type parameter of the arguments (e.g., Integer, Double)
     * @return the item in the last index of <code>args</code>, which has the final
     * result of all the bifunctions being applied in sequence.
     */

    public static <T> T zip(List<T> args, List<NamedBiFunction<T, T, T>> bifunctions) {
        if (args.size() != bifunctions.size() + 1)
            throw new RuntimeException("Invalid Argument and BiFunction Size");
        if (args.isEmpty())
            return null;
        if (args.size() == 1)
            return args.get(0);
        for (int i = 1; i < args.size(); i++) {
            NamedBiFunction<T, T, T> function = bifunctions.get(i - 1);
            T result = function.apply(args.get(i - 1), args.get(i));
            args.set(i, result);
        }
        return args.get(args.size() - 1);
    }

    public static class FunctionComposition<A, B, C> {
        public static <A, B, C> Function<A, C> composition(Function<A, B> f, Function<B, C> g) {
            return f.andThen(g);
        }
    }

    public static void main(String[] args) {
//        List<Double> argList = Arrays.asList(1d, 1d, 3d, 0d, 4d);
//        List<NamedBiFunction<Double, Double, Double>> bfs = Arrays.asList(add, multiply, add, divide);
//        double result = zip(argList, bfs);
//        for(int i=0; i< argList.size(); i++){
//            System.out.print(argList.get(i)+" ");
//        }
//        System.out.println();
//        System.out.println(result);
//
//            System.out.println();
//
//        Function<Character, String> f = c -> new String(new char[Character.getNumericValue(c) - Character.getNumericValue('a') + 1]).replace("\0", "" + c);
//
//        Function<String, Integer> g = s -> s.length();
//
//        Function<Character, Integer> h = FunctionComposition.composition(f, g);
//
//        System.out.println(f.apply('d'));
//        System.out.println(g.apply("abcd"));
//        System.out.println(h.apply('z'));
    }
}