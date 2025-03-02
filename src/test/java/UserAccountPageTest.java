import org.example.Browser.BrowserSetup;
import org.example.Pages.LumaHomePage;
import org.example.Pages.LumaUserAccountPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserAccountPageTest {
    WebDriver driver;
    LumaHomePage lumaHomePage;
    LumaUserAccountPage lumaUserAccountPage;

    @BeforeAll
    void setup() {
        driver = BrowserSetup.getDriver();
        lumaUserAccountPage = new LumaUserAccountPage(driver);
        lumaHomePage = new LumaHomePage(driver);
    }

    @Test
    @DisplayName("Test for SignInPage")
    void testUserForSignOut() {
        lumaUserAccountPage.clickOnWelcomeDropdown();
        lumaUserAccountPage.clickOnSignOut();
        Assertions.assertTrue(lumaHomePage.verifyHomePageText(), "Failed to sign out");
    }

    @AfterAll
    void tearDown() {
        driver.quit();
    }
}
