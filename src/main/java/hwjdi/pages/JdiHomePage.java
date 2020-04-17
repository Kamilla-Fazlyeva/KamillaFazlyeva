package hwjdi.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import hwjdi.entities.User;
import hwjdi.forms.LoginForm;

public class JdiHomePage extends WebPage {

    @Css("#user-name")
    public Text userName;

    @Css("#user-icon")
    private Button userIcon;

    private LoginForm loginForm;

    public void login(User user) {
        userIcon.click();
        loginForm.login(user);
    }

    public String getUsername() {
        return userName.getValue();
    }
}
