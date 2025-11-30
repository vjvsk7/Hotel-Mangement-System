import java.util.HashMap;
import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private Map<String, User> userMap = new HashMap<>();
    private HotelManager hotelManager;

    public UserManager(HotelManager hotelManager) {
        this.hotelManager = hotelManager;
        this.userMap = new HashMap<>();

    }

    public boolean adduser(User user) {
        if (user == null || user.getUserMail() == null) {
            System.out.println("Please enter valid mail and ");
            return false;
        }
        if (userMap.containsKey(user.getUserMail())) {
            System.out.println("The mail id" + user.getUserMail() + "already exist");
            return false;
        }
        userMap.put(user.getUserMail(), user);
        return true;
    }

    public boolean signup(User user) {
        if (user == null || user.getUserMail() == null || user.getUserMail().isEmpty()) {
            System.out.println("Invalid user or email.");
            return false;
        }
        if (!userMap.containsKey(user.getUserMail())) {
            userMap.put(user.getUserMail(), user);
            System.out.println("Signup successful for " + user.getUserMail());
            return true;
        } else {
            System.out.println("User already exists with email: " + user.getUserMail());
        }
        return false;
    }


    public User login(String mailId, String password) {
        if (mailId == null || password == null) {
            System.out.println("Invalid login credentials");
            return null;
        }
        User user = userMap.get(mailId);
        if (user != null && user.authenticate(password)) {
            System.out.println("Login successful");
            return user;
        } else {
            System.out.println("Invalid login credentials");
            return null;
        }
    }

    public boolean removeuser(String email) {
        User user = userMap.get(email);
        if (user == null) {
            return false;
        }

        userMap.remove(email);
        return true;
    }

    public User getUserByMailId(String mailId) {
        if (mailId == null) return null;
        return userMap.get(mailId);
    }

    public boolean isuserexists(String email) {
        if (userMap.containsKey(email)) {
            return true;
        }
        return false;
    }
}

