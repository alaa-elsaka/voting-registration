import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VoterRoll {

    List<User> users = new ArrayList<>();

    public String add(User user) {
        for(User u: users){
            if(u.getSSN() == user.getSSN())
                return "That Voter Is Already Registered, Please Contact\n" +
                        "Admin To Update Information If Needed";
        }
        users.add(user);
        return "Successfully Added";
    }

    public User get(User user) {
        int index = users.indexOf(user);
        return users.get(index);
    }

    public String search(int ssn) {
        for(User user: users){
            if(user.getSSN() == ssn)
                return user.toString();
        }
        return "User Not Found";
    }

    public Timestamp edit(User user, String editType, String editValue) {
        user.setLastName("EEEEE");
        switch (editType){
            case "firstName":
                user.setFirstName(editValue);
                break;

            case "lastName":
                user.setLastName(editValue);
                break;


            // To be added the rest of the editing types


        }
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        user.setExpirationTimestmp(timestamp);
        return user.getExpirationTimestamp();
    }

    public List<User> getVotersWithNoExpiration() {
        List<User> results = users.stream()
                .filter(user -> user.getExpirationTimestamp() == null)
                .collect(Collectors.toList());

        return results;


    }
}
