import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VotingTest {

    VoterRoll voterRoll = new VoterRoll();

    @Test
    public void checkAddingUsertoVoterRoll(){

        User user = new User("AAAAA","AAAAA","Texas",123456);

        voterRoll.add(user);
        User result = voterRoll.get(user);
        assertEquals(result, user);

    }

    @Test
    public void checkAddingUserWithSameSSN(){

        User user1 = new User("AAAAA","BBBBB","Texas",123456);
        User user2 = new User("CCCCC","DDDDD","New York",123456);

        voterRoll.add(user1);
        String result = voterRoll.add(user2);

        assertTrue(result.equalsIgnoreCase("That Voter Is Already Registered, Please Contact\n" +
                "Admin To Update Information If Needed"));
    }

    @Test
    public void checkUserprofileBySSN(){
        User user1 = new User("AAAAA","BBBBB","Texas",123456);
        voterRoll.add(user1);
        String result = voterRoll.search(123456);
        String expected = "Full Name = AAAAA BBBBB, Address: Texas, SSN#123456";
        assertTrue(expected.equals(result));
    }

    @Test
    public void checkEditUserProfile(){
        User user1 = new User("AAAAA","BBBBB","Texas",123456);
        voterRoll.add(user1);
        Timestamp result =  voterRoll.edit(user1,"firstName","EEEEE");
        assertTrue(result != null);
    }

    @Test
    public void checkRetriveListofPorfilesWithNullExpirationTimestamp(){
        User user1 = new User("AAAAA","BBBBB","Texas",123456);
        User user2 = new User("CCCCC","DDDDD","New York",123457);

        User user3 = new User("CCCCC","DDDDD","New York",123458);

        voterRoll.add(user1);
        voterRoll.add(user2);
        voterRoll.add(user3);

        voterRoll.edit(user1,"firstName","WWWWW");
        List<User> result = voterRoll.getVotersWithNoExpiration();

        List<User> expected = new ArrayList<>();
        expected.add(user2);
        expected.add(user3);

        assertEquals(expected,result);


    }


}
