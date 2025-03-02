import org.example.Browser.BrowserSetup;
import org.example.Pages.LumaHomePage;
import org.example.Pages.LumaSingUpPage;
import org.example.Pages.LumaUserAccountPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SignUpTest {
    WebDriver driver;
    LumaSingUpPage lumaSingUpPage;
    LumaHomePage lumaHomePage;
    LumaUserAccountPage lumaUserAccountPage;
    String password = "Abc@1234";

    @BeforeAll
    void setup() {
        driver = BrowserSetup.getDriver();
        lumaHomePage = new LumaHomePage(driver);
        lumaSingUpPage = new LumaSingUpPage(driver);
        lumaUserAccountPage = new LumaUserAccountPage(driver);
    }

    @Test
    @DisplayName("Test User SingUpPage")
    void testUserSingUpPage() {
        lumaHomePage.openWebUrl();
        Assertions.assertTrue(lumaHomePage.verifyHomePageText(), "having problem in opening home page");
        lumaHomePage.clickOnCreateAccount();
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertTrue(currentUrl.contains("https://magento.softwaretestingboard.com/customer/account/create/"), "Having problem in opening sign up page");
        lumaSingUpPage.setFirstName("firstName");
        lumaSingUpPage.setLastName("lastName");
        lumaSingUpPage.setEmail("first.last@gmail.com");
        lumaSingUpPage.setPassword(password);
        lumaSingUpPage.setConfirmationPassword(password);
        lumaSingUpPage.clickOnCreateAccount();
        Assertions.assertTrue(lumaUserAccountPage.verifyWelcomeText("firstName", "lastName"));
    }

    @AfterAll
    void tearDown() {
        driver.quit();
    }
}
