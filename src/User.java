// Imports: LocalDate to store the date of birth and to access today's date, ChronoUnit to calculate the age
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class User {
    // 3 private variables: the name, date of birth, and the user's activity tracker
    private String name;

    private LocalDate dateOfBirth;

    private Tracker tracker;

    // Getters and setters for name, date of birth and tracker
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Tracker getTracker() {
        return tracker;
    }

    public void setTracker(Tracker tracker) {
        this.tracker = tracker;
    }

    // Calculate the user's age using the ChronoUnit class
    public long calculateUserAge() {
        LocalDate today = LocalDate.now(); // Access today's date
        return ChronoUnit.YEARS.between(this.dateOfBirth, today); // Calculate the number of years (==> long) between the date of birth and today
    }

    // Print method: prints out the name, the age, and the last 3 activities logged
    // Note that the method prints out the last activity if there's only one logged activity, or the last 2 if there are only two logged activties
    // As the outputs are different for 0, 1, 2, 3+ logged activities, I had to use a conditional statement
    public void print() {
        System.out.println("Name: " + this.name); // Print out the user's name
        System.out.println("Age: " + calculateUserAge()); // Print out the user's age
        if (this.tracker == null) { // Check if the tracker is null and not if the size is 0, otherwise the compiler will return an error message
            System.out.println("No activities logged yet"); // Error message if no activities were logged yet
        }
        else if (this.tracker.getActivities().size() == 1) { // Check if there's one activity
            System.out.println("Last activity logged: " + this.tracker.getActivities().get(0).getName());
        }
        else if (this.tracker.getActivities().size() == 2) { // Check if there are two activities
            System.out.println("Last 2 activities logged:");
            System.out.println("    - " + this.tracker.getActivities().get(0).getName());
            System.out.println("    - " + this.tracker.getActivities().get(1).getName());
        }
        else { // There are 3 or more activities
            System.out.println("Last 3 activities logged:");
	        for (int i = 1; i <= 3; i++) { // Index ranges from 1 to 3 included
                // Print out the last 3 activities:
                // If S is the size of the tracker, then the S-1th activity is the last activity logged, the S-2th is the one before, and the S-3th the one even before
	            System.out.println("	- " + this.tracker.getActivities().get(this.tracker.getActivities().size() - i).getName());
	        }
        }
    }

    // Constructor
    public User(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

}
