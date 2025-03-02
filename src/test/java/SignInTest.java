import org.example.Browser.BrowserSetup;
import org.example.Pages.LumaSignInPage;
import org.example.Pages.LumaUserAccountPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SignInTest {
    WebDriver driver;
    LumaSignInPage lumaSignInPage;
    LumaUserAccountPage lumaUserAccountPage;
    String password = "Abc@1234";

    @BeforeAll
    void setup() {
        driver = BrowserSetup.getDriver();
        lumaSignInPage = new LumaSignInPage(driver);
        lumaUserAccountPage = new LumaUserAccountPage(driver);
    }

    @Test
    @DisplayName("Test for SignInPage")
    void testUserSignInPage() {
        lumaSignInPage.setEmail("email");
        lumaSignInPage.setPassword(password);
        lumaSignInPage.clickOnSignInButton();
        Assertions.assertTrue(lumaUserAccountPage.verifyWelcomeText("firstName", "lastName"), "Failed to login");
    }

    @AfterAll
    void tearDown() {
        driver.quit();
    }
}
