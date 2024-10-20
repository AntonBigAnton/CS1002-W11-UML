// Imports: LocalDate to store the date of birth of users, LocalDateTime to store the start/end times of the activities, List and ArrayList for the route
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class W11Practical {
    public static void main(String[] args) {
        // Testing the 4 activities 
        System.out.println("-- TEST 1: Activities --");

        // Testing the Swim
        System.out.println("\n- TEST 1A: New swim -");
        Swim swim1 = new Swim(LocalDateTime.of(2022, 11, 25, 10, 0), LocalDateTime.of(2022, 11, 25, 11, 0), 20, 50);
        swim1.print();

        // Creating a route for the Cycle and Run
        // According to the System Specification's grid reference system, this route's distance is 6.0 km
        List<Double> route = new ArrayList<Double> ();
        route.add(0.0);
        route.add(0.0);
        route.add(10.0);
        route.add(0.0);
        route.add(10.0);
        route.add(10.0);

        // Testing the Cycle
        System.out.println("\n- TEST 1B: New cycle -");
        Cycle cycle1 = new Cycle(LocalDateTime.of(2022, 11, 25, 11, 0), LocalDateTime.of(2022, 11, 25, 11, 20), route);
        cycle1.print();
        

        // Testing the Run
        System.out.println("\n- TEST 1C: New run -");
        Run run1 = new Run(LocalDateTime.of(2022, 11, 25, 12, 0), LocalDateTime.of(2022, 11, 25, 12, 30), route);
        run1.print();
        

        // Testing the Treadmill
        System.out.println("\n- TEST 1D: New treadmill session -");
        Treadmill treadmill1 = new Treadmill(LocalDateTime.of(2022, 11, 25, 12, 0), LocalDateTime.of(2022, 11, 25, 12, 10), 5);
        treadmill1.print();
        

        // Testing a non-swim, non-run, non-cycle, non-treadmill activity
        System.out.println("\n- TEST 1E: New activity -");
        Activity workout1 = new Activity("Workout", LocalDateTime.of(2022, 11, 25, 9, 0), LocalDateTime.of(2022, 11, 25, 9, 30));
        workout1.print();
        System.out.println("---------------------------------------------------------------------");

        // Testing a new user, with an empty tracker
        System.out.println("-- TEST 2: New user --");
        User anton = new User("Anton", LocalDate.of(2004, 12, 13));
        anton.print();
        System.out.println("---------------------------------------------------------------------");

        // Testing the Tracker
        System.out.println("-- TEST 3: Tracker --");

        // Testing an empty Tracker
        System.out.println("\n- TEST 3A: New empty tracker -");
        Tracker antonTracker = new Tracker(anton);
        antonTracker.print();

        // Adding one activity
        System.out.println("\n- TEST 3B: Add one activity to the tracker -");
        antonTracker.addActivity(swim1);
        antonTracker.print();

        // Clearing the tracker
        System.out.println("\n- TEST 3C: Clear the tracker -");
        antonTracker.clearActivities();
        antonTracker.print();
        
        // Adding an 11th activity to a full tracker
        System.out.println("\n- TEST 3D: Add 11 activities to the tracker -");
        for (int i = 0; i < 10; i++) {
            antonTracker.addActivity(swim1);
        }
        antonTracker.addActivity(run1);
        System.out.println("antonTracker's size (should be 10): " + antonTracker.getActivities().size());
        System.out.println("The detectFull() method should return true: " + antonTracker.detectFull());

        // Clearing the tracker, then adding one activity of each type
        antonTracker.clearActivities();
        antonTracker.addActivity(swim1);
        antonTracker.addActivity(cycle1);
        antonTracker.addActivity(run1);
        antonTracker.addActivity(treadmill1);
        antonTracker.addActivity(workout1);

        // Testing to get the longest during activity
        System.out.println("\n- TEST 3E: Longest duration -");
        antonTracker.getLongestDuration().print();

        // Testing to get the longest (distance) activity
        System.out.println("\n- TEST 3F: Longest distance -");
        antonTracker.getLongestDistance().print();

        // Adding a different treadmill activity to the tracker
        Treadmill treadmill2 = new Treadmill(LocalDateTime.of(2022, 11, 25, 12, 0), LocalDateTime.of(2022, 11, 25, 12, 30), 15);
        antonTracker.addActivity(treadmill2);

        // Testing to find the average duration for the treadmill activities
        System.out.println("\n- TEST 3G: Average duration -");
        System.out.println("Average duration for \"Treadmill\" activities (should be 20.0): " + antonTracker.getAverageDuration("Treadmill"));
        
        // Testing to find the average distance for the treadmill activities
        System.out.println("\n- TEST 3H: Average distance -");
        System.out.println("Average distance for \"Treadmill\" activities (should be 10.0): " + antonTracker.getAverageDistance("Treadmill"));
        System.out.println("---------------------------------------------------------------------");

        // Testing a user with an updated tracker
        System.out.println("-- TEST 4: Updated user tracker --");
        System.out.println("\n- TEST 4A: Updated user -");
        anton.print();
        System.out.println("\n- TEST 4B: Updated tracker, accessed via user -");
        anton.getTracker().print();
        System.out.println("---------------------------------------------------------------------");

        // Testing the nextSerialNumber system
        System.out.println("-- TEST 5: Multiple trackers --");

        // New users with new trackers
        User dad = new User("Dad", LocalDate.of(1974, 2, 22));
        Tracker dadTracker = new Tracker(dad);
        User mum = new User("Mum", LocalDate.of(1975, 8, 11));
        Tracker mumTracker = new Tracker(dad);
        User sis = new User("Sis", LocalDate.of(2006, 6, 5));
        Tracker sisTracker = new Tracker(dad);
        User bro = new User("Bro", LocalDate.of(2009, 11, 10));
        Tracker broTracker = new Tracker(dad);

        // Testing the family members trackers' serial numbers
        System.out.println("antonTracker's serial number (should be 1): " + antonTracker.getSerialNumber());
        System.out.println("dadTracker's serial number (should be 2): " + dadTracker.getSerialNumber());
        System.out.println("mumTracker's serial number (should be 3): " + mumTracker.getSerialNumber());
        System.out.println("sisTracker's serial number (should be 4): " + sisTracker.getSerialNumber());
        System.out.println("broTracker's serial number (should be 5): " + broTracker.getSerialNumber());
    }
}