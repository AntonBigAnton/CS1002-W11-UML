// Imports: List and ArrayList for the list of activities
import java.util.ArrayList;
import java.util.List;

public class Tracker {
    // 4 private variables: the serial number, the next serial number, the tracker's owner, and the list of activities
    private final int serialNumber;

    private static int nextSerialNumber = 0;

    private User user;

    private List<Activity> activity = new ArrayList<Activity> ();

    // Getters for serial number and activity
    public int getSerialNumber() {
        return serialNumber;
    }

    public List<Activity> getActivities() {
        return this.activity;
    }

    // Methods to add an activity, clear all logged activities and check if the tracker is full
    public void addActivity(Activity activity) {
        if (detectFull()) {
            System.out.println("The tracker is full!"); // Error message if the tracker is full
        }
        else {
            this.activity.add(activity); // If not, then we can add an activity
        }
    }

    public void clearActivities() {
	    this.activity.clear();
    }

    public boolean detectFull() {
        // The tracker's capacity is 10 activities, therefore if the tracker's size is 10, then the method detects that the tracker is full and returns true
        if (this.activity.size() == 10) {
            return true;
        }
        else {
            return false;
        }
    }

    // Methods to get the longest during activity, and the longest activity (in distance)
    public Activity getLongestDuration() {
	    Activity longest = this.activity.get(0); // By default, the longest activity is the first one
        for (int i = 1; i < this.activity.size(); i++) { // Cycle through the remaining activities...
            if (this.activity.get(i).calculateDuration() > longest.calculateDuration()) { // ... and check if they last longer
                longest = this.activity.get(i); // They then become the longest activity
            }
        }
        return longest;
    }

    public Activity getLongestDistance() { // Same logic as the preious method
	    Activity longest = this.activity.get(0);
        for (int i = 1; i < this.activity.size(); i++) {
            if (this.activity.get(i).calculateDistance() > longest.calculateDistance()) {
                longest = this.activity.get(i);
            }
        }
        return longest;
    }

    // Methods to get the average length/duration of an inputted activity
    public double getAverageDuration(String activityName) {
        double average = 0.0;
        int nbOfAct = 0; // The number of activities with the inputted activity name
        for (Activity act : this.activity) { // Cycle through all activities in the tracker...
            if (act.getName() == activityName) { // ... and if they have the required name, ...
                average += act.calculateDuration(); // ... update the average...
                nbOfAct++; // ... and increase the counter
            }
        }
        if (nbOfAct != 0) { // Check if the counter is not 0 (as one cannot divide by 0)
            average = average/nbOfAct;
        }
        return average;
    }

    public double getAverageDistance(String activityName) { // Same logic as the previous method
    	double average = 0.0;
        int nbOfAct = 0;
        for (Activity act : this.activity) {
            if (act.getName() == activityName) {
                average += act.calculateDistance();
                nbOfAct++;
            }
        }
        if (nbOfAct != 0) {
            average = average/nbOfAct;
        }
        return average;
    }

    /*
    The two previous methods can be coded in two different ways:
    1). The first way is to input the activity's name, and calculate the average duration/distance of all activities with the same name
    2). The second way is to input an activity, and calculate the average duration/distance of all activities with the same type (or class).
    
    I chose to implement these methods the first way, as one can have different standard activities.
    For example, "morning workout" and "basketball session" are two Activity objects but represent different activities.
    Therefore, with the first method, I can calculate the average duration/distance of my "basketball sessions",
    whereas with the second method, I can only calculate the average duration/distance of Activity objects ("morning workout" and "basketball session")
    
    Nevertheless, there are some advantages to the second method, as one can imagine two Swim objects, but with different names (one named "500m" and
    the other "1000m"): the first method would not be able to calculate the average distance/duration of all Swim activities, but the second would. 
    Here are the getAverageDuration and getAverageDistance methods, coded in the second way:

    public double getAverageDuration(Activity activity) {
        double average = 0.0;
        int nbOfAct = 0;
        for (Activity act : this.activity) {
            if (act.getClass() == activity.getClass()) {
                average += act.calculateDuration();
                nbOfAct++;
            }
        }
        if (nbOfAct != 0) {
            average = average/nbOfAct;
        }
        return average;
    }

    public double getAverageDistance(Activity activity) {
    	double average = 0.0;
        int nbOfAct = 0;
        for (Activity act : this.activity) {
            if (act.getClass() == activity.getClass()) {
                average += act.calculateDistance();
                nbOfAct++;
            }
        }
        if (nbOfAct != 0) {
            average = average/nbOfAct;
        }
        return average;
    }
    */

    // Print method
    public void print() {
        System.out.println("Serial number: " + getSerialNumber());
        System.out.println("Owner name: " + this.user.getName());
        System.out.println("Owner age: " + this.user.calculateUserAge());
        if (this.activity.size() == 0) { // If the tracker's size is 0, then there are no activities logged yet
            System.out.println("No activities logged yet");
        }
        else {
            System.out.println("Summary statistics of all currently logged activities: ");
            for (int i = 0; i < this.activity.size(); i++) {
                System.out.print((i + 1) + ". ");
                this.activity.get(i).print();
            }
        }
    }

    // Constructor
    public Tracker(User owner) {
        this.user = owner;
        this.user.setTracker(this); // Set the owner's tracker to this
        this.serialNumber = nextSerialNumber + 1; // Set this tracker's serial number to the previous tracker's serial number + 1, ...
        nextSerialNumber = this.serialNumber; // ... and set nextSerialNumber to the current serial number
    }
}
