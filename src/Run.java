// Imports: LocalDateTime to store the start/end time, List and ArrayList for the route
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Run extends Activity { // extends Activity --> the Run class inherits from the Activity class
    // One private variable: the route
    private List<Double> route = new ArrayList<Double> ();

    // Constructor
    public Run(LocalDateTime startTime, LocalDateTime endTime, List<Double> route) {
        super("Run", startTime, endTime); // Access Activity's constructor
        this.route = route;
        super.setDistance(calculateDistance()); // Set the activity's distance (computed with Run's calculateDistance() method) with the super class' setter
    }

    // Method to calculate the distance
    public double calculateDistance() {
        /*
        To understand this method, I have to explain how I store, in the variable route, the different map grid references. Let's use a theoretical example:
        let points A(xa, ya), B(xb, yb) and C(xc, yc) be three map grid references, stored in the list route. I decided to model the route as followed:
        route = {xa, ya, xb, yb, xc, yc}
        Each pair of entries correspond to the coordinates of a grid reference: in our case, entries 0 and 1 are the coordinates of point A, entries 2 and 3
        are the coordinates of point B, and entries 4 and 5 are the coordinates of point C.
        Therefore, to calculate the distance covered in this route, we add up the distances between each pair of entries (= each grid reference).
        In our example, the total distance would be: distance = √((xb-xa)^2 + (yb-ya)^2) + √((xc-xb)^2 + (yc-yb)^2)
        */
        double dist = 0.0;
        // We have to stop the for loop at the second to last pair of entries (a.k.a. the fourth to last entry), as for each pair, we compute the distance
        // between that pair and the next one. We also increment the value of i by 2 to cycle through pairs of entries (and not individual entries)
        for (int i = 0; i < this.route.size()-3; i += 2) {
            double xd = 0.3*(this.route.get(i+2) - this.route.get(i)); // Calculate the difference between the x coordinates
            double yd = 0.3*(this.route.get(i+3) - this.route.get(i+1)); // Calculate the difference between the y coordinates
            dist += Math.sqrt(Math.pow(xd, 2) + Math.pow(yd, 2)); // Add to the total distance the distance between the two points (√(xd^2 + yd^2))
        }
        return dist;
    }

    /*
    Another way of doing this is to create a separate Java class called GridReference. This class would have three private attributes: x, y. The methods
    in this clas would include a constructor, getters and setters for both attributes, and a calculateDistance(GridReference gridReference) method that
    would calculate the distance between itself and the inputted one. The GridReference class would be as followed (in a separate GridReference.java file):

    public class GridReference {
        private double x;
        private double y;

        public GridReference(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }
        
        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }
        
        public void setY(double y) {
            this.y = y;
        }

        public double calculateDistance(GridReference gridReference) {
            double xd = 0.3*(gridReference.getX() - this.x);
            double yd = 0.3*(gridReference.getY() - this.y);
            return (double) Math.sqrt(Math.pow(xd, 2) + Math.pow(yd, 2));
        }
    }

    Using this GridReference class, the Run class would be modified as followed:
    Line 8: route is now initialised as an ArrayList of GridReference entries --> private List<GridReference> route = new ArrayList<GridReference> ();
    Lines 18 to 37: calculateDistance() becomes the following method:
    public double calculateDistance() {
        double dist = 0.0;
        for (int i = 0; i < this.route.size()-1; i++) {
            dist += this.route.get(i).calculateDistance(this.route.get(i+1));
        }
        return dist;
    }
    */

    // Method to calculate the pace ("the average number of minutes per kilometer", System Specification)
    public double calculatePace() {
        return super.calculateDuration()/calculateDistance();
    }

    // Print method
    public void print() {
        super.print(); // Access the super class' print method, ...
        System.out.println("Apropriate statistics: "); // ... and print out the appropriate statistics for a Run
        System.out.println("    - Average number of minutes per kilometers: " + calculatePace());
    }

}
