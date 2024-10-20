// Import: LocalDateTime to store the start/end time
import java.time.LocalDateTime;

public class Swim extends Activity { // extends Activity --> the Swim class inherits from the Activity class
    // Two private variables: the number of laps and the length of the pool
    private int laps;

    private int length;

    // Constructor
    public Swim(LocalDateTime startTime, LocalDateTime endTime, int laps, int length) {
        super("Swim", startTime, endTime); // Access Activity's constructor
        this.laps = laps;
        this.length = length;
        super.setDistance(calculateDistance()); // Set the activity's distance (computed with Swim's calculateDistance() method) with the super class' setter
    }

    // Method to calculate the distance covered
    public double calculateDistance() {
        int dist = this.laps * this.length; // distance = number of laps completed * length of pool
        return (double) dist/1000; // Divide by 1000 to set the swim's distance in km, to simplify the comparisons in Tracker.java
    }

    // Getters for the number of laps and the length of the pool
    public int getLaps() {
        return laps;
    }

    public int getLength() {
        return length;
    }

    // Method to calculate the pace ("the average number of minutes per length", System Specification)
    public double calculatePace() {
        return super.calculateDuration()/laps; // Total time (in minutes) divided by the number of laps completed
    }

    // Print method
    public void print() {
        super.print(); // Access the super class' print method, ...
        System.out.println("Apropriate statistics: "); // ... and print out the appropriate statistics for a Swim
        System.out.println("    - Number of lengths completed: " + getLaps());
        System.out.println("    - Length of pool: " + getLength());
        System.out.println("    - Average number of minutes per length: " + calculatePace());
    }

}
