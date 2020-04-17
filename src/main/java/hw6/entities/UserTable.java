package hw6.entities;

public class UserTable {

    private String number;
    private String user;
    private String description;

    public UserTable(String number, String user, String description) {
        this.number = number;
        this.user = user;
        this.description = description;
    }

    public String getNumber() {
        return number;
    }

    public String getUser() {
        return user;
    }

    public String getDescription() {
        return description;
    }

}
