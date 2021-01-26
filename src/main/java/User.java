import java.sql.Timestamp;

public class User {

    private String firstName;
    private String lastName;
    private int SSN;
    private String address;
    private Timestamp ExpirationTimestmp;

    public void setExpirationTimestmp(Timestamp timestamp) {
        this.ExpirationTimestmp = timestamp;
    }

    public Timestamp getExpirationTimestmp() {
        return ExpirationTimestmp;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSSN() {
        return SSN;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSSN(int SSN) {
        this.SSN = SSN;
    }

    public User(String firstName, String lastName, String address, int SSN) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = SSN;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("Full Name = ");
        sb.append(this.firstName).append(" ")
        .append(this.lastName)
        .append(", Address: ")
        .append(this.address)
        .append(", SSN#")
        .append(this.SSN);

        return sb.toString();
    }

    public Timestamp getExpirationTimestamp() {
        return this.ExpirationTimestmp;
    }
}
