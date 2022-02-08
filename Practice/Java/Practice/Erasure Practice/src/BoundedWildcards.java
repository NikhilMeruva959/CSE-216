//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.List;
//
//public class BoundedWildcards {
//    interface Output<T> { void print(T t); }
//    static class OutputImpl<T> implements Output<T> {
//        public void print(T t) { System.out.println(t.toString()); }
//    }
//    static <T> T writeAll(Collection<T> collection, Output<? super T> out) {
//        T first = null;
//        for (T t : collection) {
//            if (first == null) first = t;
//            out.print(t);
//        }
//        return first;
//    }
//    public static void main(String... args) {
//        Output<Object> output = new OutputImpl<>();
//        Collection<String> strings = new ArrayList<>();
//// neither String nor Object is appropriate for the type T
//// The collection and the type parameter of output must be the same type
//        String s = writeAll(strings, output);
//
////        String[] str = new String[10];
////        Object[] obj = strings;
//        //obj[0] = new Object();
//        List<Double> prices = Arrays.asList(10.0, 14.0, 17.0, 30.0, 18.0);
//        double k = 10, n = 15;
//        System.out.println(prices.stream().filter(p -> p * (1 - k / 100) > n).map(p -> p * (1 - k / 100)).reduce(0d, (x, y) -> x + y));}List<Double> prices = Arrays.asList(10.0, 14.0, 17.0, 30.0, 18.0);
//
//    }
//}