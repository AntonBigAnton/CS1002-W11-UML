// Import: LocalDateTime to store the start/end time
import java.time.LocalDateTime;

public class Treadmill extends Activity { // extends Activity --> the Treadmill class inherits from the Activity class
    // One private variable: the distance
    private int distance;

    public Treadmill(LocalDateTime startTime, LocalDateTime endTime, int distance) {
        super("Treadmill", startTime, endTime); // Access Activity's constructor
        this.distance = distance;
        super.setDistance(calculateDistance()); // Set the activity's distance (computed with Treadmill's calculateDistance() method) with the super class' setter
    }

    // Method to calculate the distance
    public double calculateDistance() {
        return (double) distance; // This method is a simple getter, but I decided to return the value as a double to be in line with the previous methods
    }

    // Method to calculate the pace ("the average number of minutes per kilometer", System Specification)
    public double calculatePace() {
        return super.calculateDuration()/this.distance;
    }

    public void print() {
        super.print(); // Access the super class' print method, ...
        System.out.println("Apropriate statistics: "); // ... and print out the appropriate statistics for a Treadmill session
        System.out.println("    - Average number of minutes per kilometers: " + calculatePace());
    }

}
