import java.awt.*;

// TO DO:  Implement a class of our own named Point
public class Point {
    private int x;
    private int y;

    public static Point earthquakeOrigin;
    public static int earthquakeRadius;

    public Point() {
        this(0,0);
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void drawEarthquakeImpactArea(Graphics g) {
        earthquakeOrigin.draw(g);
        g.setColor(Color.RED);
        int circleGap = 5;
        int radius = 0;
        while (radius <= earthquakeRadius) {
            radius += circleGap;
            g.drawOval(earthquakeOrigin.getX()-radius, earthquakeOrigin.getY()-radius, 2*radius, 2*radius);
        }
        g.setColor(Color.BLACK);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double distanceTo(Point other) {
        // the ^ is the EXCLUSIVE OR operator and NOT the exponent operator
        int deltaX = other.getX() - x;
        int deltaY = other.getX() - y;
        return Math.sqrt(deltaX*deltaX + deltaY*deltaY);
    }

    public void draw(Graphics g) {
        boolean insideEarthquakeRadius = distanceToEarthquakeOrigin() <= Point.earthquakeRadius;
        if(insideEarthquakeRadius)
            g.setColor(Color.RED);

        g.fillOval(x, y, 3, 3);
        g.drawString(this.toString(), x + 5, y + 5);

        if(insideEarthquakeRadius)
            g.setColor(Color.BLACK);
    }

    public double distanceToEarthquakeOrigin() {
        return distanceTo(earthquakeOrigin);
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
