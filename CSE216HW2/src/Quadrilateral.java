import java.util.Arrays;
import java.util.List;

public class Quadrilateral implements TwoDShape, Positionable {

    List<TwoDPoint> vertices;

    public Quadrilateral(List<TwoDPoint> vertices) {
        this.vertices = vertices;
    }

    /**
     * Sets the position of this quadrilateral according to the first four elements in the specified list of points. The
     * quadrilateral is formed on the basis of these four points taken in a clockwise manner on the two-dimensional
     * x-y plane, starting with the point with the least x-value. If the input list has more than four elements, the
     * subsequent elements are ignored.
     *
     * @param points the specified list of points.
     */
    @Override
    public void setPosition(List<? extends Point> points) {
        // TODO
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
        return null; // TODO
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
        return false; // TODO
    }

    /**
     * This method snaps each vertex of this quadrilateral to its nearest integer-valued x-y coordinate. For example, if
     * a corner is at (0.8, -0.1), it will be snapped to (1,0). The resultant quadrilateral will thus have all four
     * vertices in positions with integer x and y values. If the snapping procedure described above results in this
     * quadrilateral becoming invalid (e.g., all four corners collapse to a single point), then it is left unchanged.
     * Snapping is an in-place procedure, and the current instance is modified.
     */
    public void snap() {
        // TODO
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
}
