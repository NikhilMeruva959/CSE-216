import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Quadrilateral implements TwoDShape, Positionable {

    List<TwoDPoint> vertices;
    private static Exception IllegalArgumentException;

    public Quadrilateral(List<TwoDPoint> vertices) {
        this.vertices = vertices;
    }

//    private List<TwoDPoint> sortLowVertQuad(List<TwoDPoint> newVert) {
//        TwoDPoint low = newVert.get(0);
//        for (int i = 1; i < newVert.size() ; i++) {
//            if(low.coordinates()[0] < newVert.get(i).coordinates()[0] && low.coordinates()[0] != newVert.get(i).coordinates()[0]) {
//                low = newVert.get(i);
//            }
//            else if(low.coordinates()[0] == newVert.get(i).coordinates()[0]){
//                if(low.coordinates()[1] < newVert.get(i).coordinates()[1])
//                    low = newVert.get(i);
//            }
//        }
//
//        double lowest = newVert.get(0).coordinates()[0];
//
//        int startingPos = Arrays.asList(newVert).indexOf(lowest);
//        List<TwoDPoint> temp = new ArrayList<TwoDPoint>();
//
//        int bound = 0;
//
//        while (bound == 4) {
//            for (int i = startingPos; i < newVert.size(); i++) {
//                temp.add(newVert.get(i));
//                bound++;
//                if(i==3) i=0;
//            }
//        }
//        return temp;
//    }

    /**
     * Sets the position of this quadrilateral according to the first four elements in the specified list of points. The
     * quadrilateral is formed on the basis of these four points taken in a clockwise manner on the two-dimensional
     * x-y plane, starting with the point with the least x-value. If the input list has more than four elements, the
     * subsequent elements are ignored.
     *
     * @param points the specified list of points.
     */
    @Override
    public void setPosition(List<? extends Point> points) throws Exception {
        if (points.size() >= 4 || !(points.get(0) instanceof TwoDPoint)) throw new Exception(IllegalArgumentException);

        List<TwoDPoint> newVert = new ArrayList<TwoDPoint>();
        newVert.add((TwoDPoint) points.get(0));
        newVert.add((TwoDPoint) points.get(1));
        newVert.add((TwoDPoint) points.get(2));
        newVert.add((TwoDPoint) points.get(3));

        Collections.sort(newVert, new Ordering.XLocationPointComparator());
        this.vertices = newVert;
    }

    /**
     * Retrieve the position of an object as a list of points. The points are be retrieved and added to the returned
     * list in a clockwise manner on the two-dimensional x-y plane, starting with the point with the least x-value. If
     * two points have the same least x-value, then the clockwise direction starts with the point with the lower y-value.
     *
     * @return the retrieved list of points.
     */
    @Override
    public List<? extends Point> getPosition() {
        Collections.sort(this.vertices, new Ordering.XLocationPointComparator());
        return this.vertices;
    }

    /**
     * @return the number of sides of this quadrilateral, which is always set to four
     */
    @Override
    public int numSides() {
        return 4;
    }

    /**
     * Checks whether or not a list of vertices forms a valid quadrilateral. The <i>trivial</i> quadrilateral, where all
     * four corner vertices are the same point, is considered to be an invalid quadrilateral.
     *
     * @param vertices the list of vertices to check against, where each vertex is a <code>Point</code> type.
     * @return <code>true</code> if <code>vertices</code> is a valid collection of points for a quadrilateral, and
     * <code>false</code> otherwise. For example, if three of the four vertices are in a straight line is invalid.
     */
    @Override
    public boolean isMember(List<? extends Point> vertices) {
        if((vertices.get(0).coordinates()).equals((vertices.get(1).coordinates())) &&
                (vertices.get(0).coordinates()).equals((vertices.get(2).coordinates()))&&
                (vertices.get(0).coordinates()).equals((vertices.get(3).coordinates()))&&
                (vertices.get(1).coordinates()).equals((vertices.get(2).coordinates()))&&
                (vertices.get(1).coordinates()).equals((vertices.get(3).coordinates()))&&
                (vertices.get(2).coordinates()).equals((vertices.get(3).coordinates()))){
            return false;
        }
        else return true;
    }

    /**
     * This method snaps each vertex of this quadrilateral to its nearest integer-valued x-y coordinate. For example, if
     * a corner is at (0.8, -0.1), it will be snapped to (1,0). The resultant quadrilateral will thus have all four
     * vertices in positions with integer x and y values. If the snapping procedure described above results in this
     * quadrilateral becoming invalid (e.g., all four corners collapse to a single point), then it is left unchanged.
     * Snapping is an in-place procedure, and the current instance is modified.
     */
    public void snap() {
        List<TwoDPoint> temp = new ArrayList<TwoDPoint>();
        for (int i = 0; i < vertices.size(); i++) {
            TwoDPoint x = new TwoDPoint((int)Math.round(vertices.get(i).coordinates()[0]), (int)Math.round(vertices.get(i).coordinates()[1]));
            temp.add(x);
        }
        if(isMember(temp)) vertices = temp;
    }

    /**
     * @return the area of this quadrilateral
     */
    public double area() {
        TwoDPoint p1 = vertices.get(0),
                  p2 = vertices.get(1),
                  p3 = vertices.get(2),
                  p4 = vertices.get(3);

        Triangle t1 = new Triangle(Arrays.asList(new TwoDPoint[]{p1, p2, p3})),
                 t2 = new Triangle(Arrays.asList(new TwoDPoint[]{p1, p3, p4}));

        return t1.area() + t2.area();
    }

    /**
     * @return the perimeter (i.e., the total length of the boundary) of this quadrilateral
     */
    public double perimeter() {
        TwoDPoint p1 = vertices.get(0),
                  p2 = vertices.get(1),
                  p3 = vertices.get(2),
                  p4 = vertices.get(3);

        double  a = p1.distance(p2),
                b = p2.distance(p3),
                c = p3.distance(p4),
                d = p4.distance(p1);

        return a+b+c+d;
    }

    public TwoDPoint getLeastXVertex() {
        TwoDPoint p1 = vertices.get(0),
                  p2 = vertices.get(1),
                  p3 = vertices.get(2),
                  p4 = vertices.get(3);

        TwoDPoint min = p1.coordinates()[0] <= p2.coordinates()[0] ? p1 : p2;
        min = min.coordinates()[0] <= p3.coordinates()[0] ? min : p3;
        min = min.coordinates()[0] <= p4.coordinates()[0] ? min : p4;
        return min;
    }
    public String toString() {
        return "Quadrilaeral(" +
                "p1 = (" + vertices.get(0).coordinates()[0] + ", " + vertices.get(0).coordinates()[1] + "), " +
                "p2 = (" + vertices.get(1).coordinates()[0] + ", " + vertices.get(1).coordinates()[1] + "), " +
                "p3 = (" + vertices.get(2).coordinates()[0] + ", " + vertices.get(2).coordinates()[1] + ")" +
                "p1 = (" + vertices.get(3).coordinates()[0] + ", " + vertices.get(3).coordinates()[1] + "), " +
                ")";
    }
}
