import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class HomePage extends BasePage {
    By loginMenuLocator = By.xpath("//div[@class='inner text-color-white']");
    By acceptCookiesLocator = By.cssSelector("button[class='mat-caption btn accept-all']");
    public HomePage(WebDriver driver){
        super(driver);
    }

    public void loginMenu() {
        clickElement(loginMenuLocator);
    }

    public void acceptCookies() {
        if (isDisplayed(acceptCookiesLocator)){
            clickElement(acceptCookiesLocator);
        }


    }
}
