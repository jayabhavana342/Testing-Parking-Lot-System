package parkinglot.model;

public class FrequentParkingUser {

    private int id;
    private String lastName;
    private String firstName;
    private String email;
    private String address;
    private int phone;
    private String license_id;
    private int rewards;

    public FrequentParkingUser(String lastName, String firstName, String email, String address, int phone, String license_id, int rewards) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.license_id = license_id;
        this.rewards = rewards;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getLicense_id() {
        return license_id;
    }

    public void setLicense_id(String license_id) {
        this.license_id = license_id;
    }

    public int getRewards() {
        return rewards;
    }

    public void setRewards(int rewards) {
        this.rewards = rewards;
    }

    @Override
    public String toString() {
        return String.format("FrequentParkingUser [id=%s, lastName=%s, firstName=%s, email=%s, address=%s, phone=%s, license_id=%s, rewards=%s]",
                id, lastName, firstName, email, address, phone, license_id, rewards);
    }


}

