import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.apache.log4j.Logger;


public class BasePage {
    private static final Logger logger = Logger.getLogger(BasePage.class);
    WebDriver driver;
    WebDriverWait wait;

    String istenenText;
    public String selectedPrice;
    static String homePrice;

    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Varsayılan olarak 5 saniye beklemeyi ayarladık.
    }


    // find methodu element tıklanabilir olduğu zamana kadar bekle tıklanabilir olduğunda locate et.
    public WebElement find(By locator) throws org.openqa.selenium.TimeoutException {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }


    // clickElement methodu find metodunu kullanarak elementi locate edip tıklamaya yarıyor.
    public void clickElement(By locator) {
        find(locator).click();
        logger.info(locator + " " + "Element tıklandı");
    }

    public Boolean isDisplayed(By locator) {
        return find(locator).isDisplayed();
    }

    // sendText methodu find metodunu kullanarak elementi locate edip elementin içine bir text göndermemize yarıyor.
    public void sendText(By locator, String text) {
        find(locator).sendKeys(text);
        logger.info("Element'e" + " " + text + " " + "değeri girildi");
    }

    // assertVisibilityOfElement metodu elementin içindeki texti alıp LoginTest.java class'ında bulunan elementText ile karşılaştırıyor.
    public void assertVisibilityOfElement(By locator, String elementText) {
        WebElement element = find(locator);
        istenenText = element.getText();
        Assertions.assertEquals(elementText, istenenText, "istenen e-posta uyuşmuyor.");
        logger.info(elementText + " " + "Elementinin içerik text'i kontrol edildi");
    }

    //hoverElement metodu elementi find ile locate edip Action kullanarak mouse ile hover ediyor.
    public void hoverElement(By locator) {
        WebElement webElement = find(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).build().perform();
    }

    //Adres sayfasındaki Ödenecek Tutar = ürün fiyatını string ile tutuyor daha sonrasında ödeme sayfasında karşılaştırmasını yapabilmek için
    public void tutarAssert() {
        String expandedXPath = "//div[@class='subtitle-1 text-align-right']";
        WebElement selectedCartElement = find(By.xpath(expandedXPath));
        selectedPrice = selectedCartElement.getText();
        logger.info("Seçilen ürünün tutarı alındı.");
    }

   /* public void checkPriceWithExtraAmount(By locator, float extraAmount) throws InterruptedException {
        Thread.sleep(2000);
        WebElement odenecekTutarElement = find(locator);
        String odenecekTutarPrice = odenecekTutarElement.getText();
        logger.info("Ödenecek tutar fiyatı alındı.");

        // Ödenecek tutar metnini float değere çevirme (örnekteki parseAmount methodunu kullanabilirsiniz)
        float originalPrice = parseAmount(odenecekTutarPrice);

        // Ekstra miktarı ekleyerek beklenen fiyatı hesaplama
        float expectedPrice = originalPrice + extraAmount;

        // Fiyatları karşılaştırma
        logger.info("Fiyatlar karşılaştırıldı.");
        if (Math.abs(expectedPrice - parseAmount(selectedPrice)) <= 0.001) {
            System.out.println("Fiyatlar birbirlerine eşit.");
        } else {
            logger.info("Fiyatlar birbirlerini tutmuyor.");
        }
    }

    public float parseAmount(String amountText) {
        String numericPart = amountText.replaceAll("[^\\d.]", "");
        return Float.parseFloat(numericPart);
    }*/


    public void checkPrice(By locator) throws InterruptedException {
        Thread.sleep(2000);
        WebElement odenecekTutarElement = find(locator);
        String odenecekTutarPrice = odenecekTutarElement.getText();
        logger.info("Ödenecek tutar fiyatı alındı.");


        logger.info("Fiyatlar karşılaştırıldı.");

        if (selectedPrice.equals(odenecekTutarPrice)) {
            System.out.println("Fiyatlar birbirlerine eşit.");
        } else {
            logger.info("Fiyatlar birbirlerini tutmuyor.");
        }
   /* public void jsScroll(By locator) throws InterruptedException {
        //Thread.sleep(1000);
        jsExecutor.executeScript("arguments[0].scrollIntoView();", find(locator) );
    }*/
   /* public void assertCard(By locator, String elementText) {
        WebElement element = find(locator);
        istenenText = element.getText();
        Assertions.assertEquals(elementText, istenenText, "kart bilgileri girilmemiş.");
        logger.info(elementText + " " + "Elementinin içerik text'i kontrol edildi");
    }*/
    /*public void clickElementWithAction(WebElement element) {
        Actions actions = new Actions(driver);
        actions.click(element).perform();
        logger.info(element + ": elementine tıklandı...");
    }*/


    /*sepettekiTutar
            sontutar*/


    }
}
