
import java.util.HashMap;
import java.util.Map;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

class Reservation {
    private int pnrNumber;
    private String trainNumber;
    private String journeyDate;

    public Reservation(int pnrNumber, String trainNumber, String journeyDate) {
        this.pnrNumber = pnrNumber;
        this.trainNumber = trainNumber;
        this.journeyDate = journeyDate;
    }

    public int getPNRNumber() {
        return pnrNumber;
    }

    // Other getters and setters
}

class OnlineReservationSystem {
    private static Map<String, User> usersDatabase = new HashMap<>();
    private static Map<Integer, Reservation> reservations = new HashMap<>();
    private static int pnrCounter = 1;

    public static void main(String[] args) {
        // Simulate adding users to the database
        usersDatabase.put("user1", new User("user1", "pass123"));
        usersDatabase.put("user2", new User("user2", "pass456"));

        // Simulate user login
        String username = "user1";
        String password = "pass123";
        if (authenticateUser(username, password)) {
            System.out.println("Login successful!");

            // Simulate reservation creation
            String trainNumber = "12345";
            String journeyDate = "2023-08-27";
            createReservation(trainNumber, journeyDate);
        } else {
            System.out.println("Login failed. Invalid credentials.");
        }
    }

    private static boolean authenticateUser(String username, String password) {
        User user = usersDatabase.get(username);
        return user != null && user.getPassword().equals(password);
    }

    private static void createReservation(String trainNumber, String journeyDate) {
        int pnrNumber = generatePNR();
        Reservation reservation = new Reservation(pnrNumber, trainNumber, journeyDate);
        reservations.put(pnrNumber, reservation);
        System.out.println("Reservation created: PNR " + pnrNumber);
    }

    private static int generatePNR() {
        return pnrCounter++;
    }
}

