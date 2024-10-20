// Imports: LocalDateTime to store the start/end time, List and ArrayList for the route
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Cycle extends Activity { // extends Activity --> the Cycle class inherits from the Activity class
    // One private variable: the route
    private List<Double> route = new ArrayList<Double> ();

    // Constructor
    public Cycle(LocalDateTime startTime, LocalDateTime endTime, List<Double> route) {
        super("Cycle", startTime, endTime); // Access Activity's constructor
        this.route = route;
        super.setDistance(calculateDistance()); // Set the activity's distance (computed with Cycle's calculateDistance() method) with the super class' setter
    }

    // Method to calculate the distance covered
    public double calculateDistance() {
        // The same logic and problems that I've exhaustively described in the Run class apply here in the Cycle class.
        double dist = 0.0;
        for (int i = 0; i < this.route.size()-3; i += 2) {
            double xd = 0.3*(this.route.get(i) - this.route.get(i+2));
            double yd = 0.3*(this.route.get(i+1) - this.route.get(i+3));
            dist += Math.sqrt(Math.pow(xd, 2) + Math.pow(yd, 2));
        }
        return dist;
    }

    // Method to calculate the average speed ("the average speed as kilometers per hour", System Specification)
    public double calculatePace() {
        return 60*calculateDistance()/super.calculateDuration(); // Multiplying the fraction by 60 to convert the duration from minutes to hours
    }

    // Print method
    public void print() {
        super.print(); // Access the super class' print method, ...
        System.out.println("Apropriate statistics: "); // ... and print out the appropriate statistics for a Cycle
        System.out.println("    - Average speed as kilometers per hour: " + calculatePace());
    }

}
