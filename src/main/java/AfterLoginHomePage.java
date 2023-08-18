import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class AfterLoginHomePage extends BasePage{
        static By afterLoginNavLocator = By.xpath("//span[@class='account-menu-button--text account-menu-button--text--email ng-star-inserted']");
        By teslimatAdresLocator = By.cssSelector("div[class='location-row']");
        By differentAddressLocator = By.id("delivery-options-address--1");

       // By jsScrollLocator = By.id("fav-add-button-20000024010013");

        By addToCartLocator = By.id("product-actions-add-to-cart-button--kuzu-pirzola-kg-p-16e5d1d");
        By hoverMenuLocator = By.id("homepage-cart-button");
        By hoverMenuButtonLocator = By.xpath("//button[@class='subtitle-2']");
        By jsScrollLocator = By.id("fav-add-button-20000024010013");

    JavascriptExecutor jsExecutor = (JavascriptExecutor)  driver;

    public AfterLoginHomePage(WebDriver driver) {
        super(driver);
    }
     public void assertLoginNavbar(String elementText){
         assertVisibilityOfElement(afterLoginNavLocator,elementText);
    }

    public void teslimatAdres(){
        clickElement(teslimatAdresLocator);
    }

    public void newAdressSelection(){
        clickElement(differentAddressLocator);
    }

    public void addToCart() throws InterruptedException {
        Thread.sleep(1000);
        WebElement element = find(jsScrollLocator);
        jsExecutor.executeScript("arguments[0].scrollIntoView();", element );
        clickElement(addToCartLocator);
    }
    public void goToCart(){
        hoverElement(hoverMenuLocator);
        clickElement(hoverMenuButtonLocator);
    }

    }
