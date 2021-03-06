import java.util.ArrayList;
import java.util.List;

public class Circle implements TwoDShape, Positionable {

    private TwoDPoint center;
    private double    radius;
    private static Exception IllegalArgumentException;

    public Circle(double x, double y, double r) {
        this.center = new TwoDPoint(x, y);
        this.radius = r;
    }

    /**
     * Sets the position of this circle to be centered at the first element in the specified list of points.
     *
     * @param points the specified list of points.
     * @throws IllegalArgumentException if the input does not consist of {@link TwoDPoint} instances
     */
    @Override
    public void setPosition(List<? extends Point> points) throws Exception {
        if(points.size() == 0 || !(points.get(0) instanceof TwoDPoint)) throw new Exception(IllegalArgumentException);
        this.center =  (TwoDPoint) points.get(0);
    }

    /**
     * @return the center of this circle as an immutable singleton list
     */
    @Override
    public List<? extends Point> getPosition() {
        List<TwoDPoint> lst = new ArrayList<TwoDPoint>();
        lst.add(this.center);
        return lst;
    }

    /**
     * @return the number of sides of this circle, which is always set to positive infinity
     */
    @Override
    public int numSides() {
        return (int) Double.POSITIVE_INFINITY;
    }

    /**
     * Checks whether or not a list of vertices is a valid collection of vertices for the type of two-dimensional shape.
     *
     * @param centers the list of vertices to check against, where each vertex is a <code>Point</code> type. For
     *                the Circle object, this list is expected to contain only its center.
     * @return <code>true</code> if and only if <code>centers</code> is a single point, and the radius of this circle is
     * a positive value.
     */
    @Override
    public boolean isMember(List<? extends Point> centers) {
        return centers.size() == 1 && radius > 0;
    }

    /**
     * @return the area of this circle
     */
    public double area() {
        return Math.PI * this.radius * this.radius;
    }

    /**
     * @return the perimeter (i.e., the total length of the boundary) of this quadrilateral
     */
    public double perimeter() {
        return 2 * Math.PI * this.radius;
    }

    public TwoDPoint getLeastXVertex() {
        return this.center;
    }

    public String toString() {
        return "Circle(x = " + center.coordinates()[0] + ", y = " + center.coordinates()[1] + ", r = " + radius + ")";
    }

}