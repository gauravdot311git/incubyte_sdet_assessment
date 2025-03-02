import org.example.Browser.BrowserSetup;
import org.example.Pages.LumaHomePage;
import org.example.Pages.LumaSignInPage;
import org.example.Pages.LumaUserAccountPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SignInTest {
    WebDriver driver;
    LumaSignInPage lumaSignInPage;
    LumaHomePage lumaHomePage;
    LumaUserAccountPage lumaUserAccountPage;

    @BeforeAll
    void setupPage() {
        driver = BrowserSetup.getDriver();
        lumaSignInPage = new LumaSignInPage(driver);
        lumaUserAccountPage = new LumaUserAccountPage(driver);
        lumaHomePage = new LumaHomePage(driver);
    }

    @Test
    @Order(3)
    @DisplayName("Given I am on the login page, When I enter valid credentials, Then I should be redirected to the dashboard")
    void testUserSignInPage() {
        lumaHomePage.openWebUrl();
        Assertions.assertTrue(lumaHomePage.verifyHomePageText(), "having problem in opening home page");
        lumaHomePage.clickOnSignIn();
        lumaSignInPage.setEmail("dummy1gk@gmail.com");
        lumaSignInPage.setPassword("$Dummy125");
        lumaSignInPage.clickOnSignInButton();
        Assertions.assertTrue(lumaUserAccountPage.verifyWelcomeText("dummy1gk", "dummy1gk"), "Failed to login");
    }

    @AfterAll
    void tearDown() {
        BrowserSetup.quitDriver();
    }
}
