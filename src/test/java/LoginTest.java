
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTest extends BaseTest {
    HomePage homePage ;
    LoginPage loginPage;

    AfterLoginHomePage afterHome;

    CartPage cartPageAct;
    AfterLoginHomePage addToTheCart;




    @Test
    @Order(1)
    public void login_Page (){
        homePage = new HomePage(driver);
        homePage.acceptCookies();
        homePage.loginMenu();
    }


    @Test
    @Order(2)
    public void input_a_Login() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.telInput("061370241");
        loginPage.loginButton();
        Thread.sleep(15000);
    }

    @Test
    @Order(3)
    public void assertLoginNav() throws InterruptedException {
        afterHome = new AfterLoginHomePage(driver);
        afterHome.assertLoginNavbar("balotaonur@gmail.com");
        afterHome.teslimatAdres();
        afterHome.newAdressSelection();
        afterHome.addToCart();
        afterHome.goToCart();
    }
    @Test
    @Order(4)
    public void cartPage() throws InterruptedException {
        cartPageAct = new CartPage(driver);
        cartPageAct.tutarAssert();
        cartPageAct.cartPageButton();
        //cartPageAct.cardWaitAct();
        cartPageAct.devamEtButton();
        cartPageAct.invoiceSame();
        cartPageAct.cartPageButton();
        cartPageAct.devamEtButton();
        cartPageAct.hourSelection();
        cartPageAct.cartPageButton();
        cartPageAct.devamEtButton();
        //assertion
        cartPageAct.checkPrice(By.xpath("//fe-line-checkout-summary-desktop/fe-line-checkout-price-summary/mat-card/div[1]/div[5]"));
        cartPageAct.cartPageButton();
        cartPageAct.devamEtButton();
        cartPageAct.returnHome();
        cartPageAct.rtrnHomeCart();
        cartPageAct.menuTrashCan();
    }

}

