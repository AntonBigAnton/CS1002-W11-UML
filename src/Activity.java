// Imports: LocalDateTime to store the start/end time, Duration to calculate the duration of an activity
import java.time.LocalDateTime;
import java.time.Duration;

public class Activity {
    // 4 local variables: the name, the start/end time of the activity and the distance covered
    private String name;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private double distance; // Store all distances in km

    // Getter and setters for all four variables (no setters for the start/end times)
    public String getName() {
	    return name;
    }

    public void setName(String name) {
	    this.name = name;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double calculateDistance() { // Getter for distance (called it calculateDistance to be in sync with the other methods)
        return distance;
    }

    // Method to calculate the duration (in minutes) of an activity
    public long calculateDuration() {
        return Duration.between(this.startTime, this.endTime).toMinutes();
    }

    // Print method: every activity, regardless of their type, has to print out its name, start/end time, duration and distance
    // Each inherited activity (Swim, Run, Cycle and Treadmill) will use this method, and print out their appropriate statistics (characteristic to an activity)
    public void print() {
        System.out.println("Activity name: " + getName());
        System.out.println("Start time: " + getStartTime().toString().substring(11) + " on " + getStartTime().toString().substring(0, 10));
        System.out.println("End time: " + getEndTime().toString().substring(11) + " on " + getEndTime().toString().substring(0, 10));
        System.out.println("Duration: " + calculateDuration() + "mins");
        System.out.print("Distance: ");
        if (this.getClass().equals(Swim.class)) {
            System.out.println(this.distance*1000 + "m");
        }
        else {
            System.out.println(this.distance + "km");
        }
    }

    // Constructor
    public Activity(String name, LocalDateTime startTime, LocalDateTime endTime) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }

}
