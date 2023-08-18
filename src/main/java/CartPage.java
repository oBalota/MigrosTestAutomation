import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage{
    By cartPageButtonLocator = By.xpath("//*[@class='confirm-button mdc-button mdc-button--unelevated mat-mdc-unelevated-button mat-primary mat-mdc-button-base']");
    By invoiceSameLocator = By.id("mat-mdc-checkbox-1-input");
    By hourSelectionLocator = By.id("mat-radio-21-input");
    By onBilKos = By.id("mat-mdc-checkbox-4-input");
    By mesSatSoz = By.id("mat-mdc-checkbox-5-input");
    By assertCardLocator = By.id("mat-mdc-error-0");
    By returnHomeLocator = By.cssSelector("div[class='logo-container sanalmarket']");
    By hoverMenuLocator = By.id("homepage-cart-button");
    By trashCanLocator = By.cssSelector("svg[data-icon='trash-can']");

    By sepetIconLocator = By.id("update-cart");
    By jsScrollLocator = By.xpath("//fe-line-checkout-summary-desktop/fe-line-checkout-price-summary/mat-card/div[2]/button/span[2]");

    //WebElement elementAction = find(By.xpath("//div[@class='mdc-form-field']//input[@id='mat-mdc-checkbox-3-input']"));
    //WebElement elementAction1 = find(By.xpath("//div[@class='mdc-form-field']//input[@id='mat-mdc-checkbox-4-input']"));

    JavascriptExecutor jsExecutor = (JavascriptExecutor)  driver;
    public CartPage(WebDriver driver) {
        super(driver);
    }
    public void cartPageButton() throws InterruptedException {
        //Thread.sleep(1000);
        //WebElement element = find(cartPageButtonLocator);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(cartPageButtonLocator));
        jsExecutor.executeScript("arguments[0].scrollIntoView();", element);
        Thread.sleep(1000);
       // clickElement(cartPageButtonLocator);
    }
    /*public void cardWaitAct (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(sepetIconLocator));
    }*/

    public void devamEtButton(){
        clickElement(cartPageButtonLocator);
    }
    public void invoiceSame(){
        clickElement(invoiceSameLocator);
    }
    public void hourSelection(){
        clickElement(hourSelectionLocator);
    }

   /* public void tick() {
        WebElement element = find(jsScrollLocator);
        jsExecutor.executeScript("arguments[0].scrollIntoView();", element );
        clickElementWithAction(elementAction);

    }*/

    /*public void assertCardInfo(String elementText){
        assertCard(assertCardLocator,elementText);
    }*/
    public void returnHome(){
        clickElement(returnHomeLocator);
    }
    public void rtrnHomeCart(){
        hoverElement(hoverMenuLocator);
    }
    public void menuTrashCan(){
        clickElement(trashCanLocator);
    }
}
