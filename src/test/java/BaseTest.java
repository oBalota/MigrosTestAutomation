import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    WebDriver driver;
    @BeforeAll
    public void setUp(){

        System.setProperty("webdriver.chrome.driver","properties/chromedriver.exe");
        //driver  = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver  = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.migros.com.tr/");
    }

    @AfterAll
    public void testDown(){
        //driver.close();
        //driver.quit();
    }
}
