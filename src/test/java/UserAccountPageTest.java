import org.example.Browser.BrowserSetup;
import org.example.Pages.LumaHomePage;
import org.example.Pages.LumaSignInPage;
import org.example.Pages.LumaUserAccountPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserAccountPageTest {
    LumaHomePage lumaHomePage;
    LumaSignInPage lumaSignInPage;
    WebDriver driver;
    LumaUserAccountPage lumaUserAccountPage;

    @BeforeAll
    void setupPage() {
        driver = BrowserSetup.getDriver();
        lumaUserAccountPage = new LumaUserAccountPage(driver);
        lumaHomePage = new LumaHomePage(driver);
        lumaSignInPage = new LumaSignInPage(driver);
    }

    @Test
    @Order(2)
    @DisplayName("Given I am on the user account page, When I click on sign out, Then I should be redirected to the home page")
    void testUserForSignOut() {
        lumaHomePage.openWebUrl();
        Assertions.assertTrue(lumaHomePage.verifyHomePageText(), "having problem in opening home page");
        lumaHomePage.clickOnSignIn();
        lumaSignInPage.setEmail("dummy1gk@gmail.com");
        lumaSignInPage.setPassword("$Dummy125");
        lumaSignInPage.clickOnSignInButton();
        lumaUserAccountPage.verifyWelcomeText("dummy1gk", "dummy1gk");
        lumaUserAccountPage.clickOnWelcomeDropdown();
        lumaUserAccountPage.clickOnSignOut();
        Assertions.assertTrue(lumaHomePage.verifyHomePageText(), "Failed to sign out");
    }

    @AfterAll
    void tearDown() {
        BrowserSetup.quitDriver();
    }
}
