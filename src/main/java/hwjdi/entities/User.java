package hwjdi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {

    public static User ROMAN = new User(UserProperties.getUserProperties().getProperty("username"),
            UserProperties.getUserProperties().getProperty("password"),
            UserProperties.getUserProperties().getProperty("expectedName"));

    private String name;
    private String password;
    private String fullName;

}
