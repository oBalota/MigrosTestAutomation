import com.google.errorprone.annotations.InlineMeValidationDisabled;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    By telInputLocator =By.id("mat-input-0");
    By loginButtonClickLocator = By.id("login__submit-button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void telInput(String text){
        clickElement(telInputLocator);
        sendText(telInputLocator,text);
    }
    public void loginButton(){
        clickElement(loginButtonClickLocator);
    }

}
