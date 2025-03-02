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
    void setupPage() {
        driver = BrowserSetup.getDriver();
        lumaHomePage = new LumaHomePage(driver);
        lumaSingUpPage = new LumaSingUpPage(driver);
        lumaUserAccountPage = new LumaUserAccountPage(driver);
    }

    @Test
    @DisplayName("Given I am on the signup page, When I enter valid details, Then I should be registered successfully")
    void testUserSingUpPage() {
        lumaHomePage.openWebUrl();
        Assertions.assertTrue(lumaHomePage.verifyHomePageText(), "having problem in opening home page");
        lumaHomePage.clickOnCreateAccount();
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertTrue(currentUrl.contains("https://magento.softwaretestingboard.com/customer/account/create/"), "Having problem in opening sign up page");
        lumaSingUpPage.setFirstName("Gaurav");
        lumaSingUpPage.setLastName("Kumar");
        lumaSingUpPage.setEmail("gaurav.kumar@gmail.com");
        lumaSingUpPage.setPassword(password);
        lumaSingUpPage.setConfirmationPassword(password);
        lumaSingUpPage.clickOnCreateAccount();
        Assertions.assertTrue(lumaUserAccountPage.verifyWelcomeText("Gaurav", "Kumar"), "Failed to create account, please check email and password again");
    }

    @AfterAll
    void tearDown() {
        BrowserSetup.quitDriver();
    }
}
