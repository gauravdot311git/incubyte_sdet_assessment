import org.example.Browser.BrowserSetup;

import org.example.Pages.LumaHomePage;
import org.example.Pages.LumaSignInPage;
import org.example.Pages.LumaSingUpPage;
import org.example.Pages.LumaUserAccountPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

//this test is to perform sign up, log out and sign in as asked in assessment
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BaseTest {
    WebDriver driver;
    LumaSingUpPage lumaSingUpPage;
    LumaHomePage lumaHomePage;
    LumaUserAccountPage lumaUserAccountPage;
    LumaSignInPage lumaSignInPage;
    String password = "$Dummy125";
    String firstName = "dummy3gk";
    String lastName = "dummy3gk";
    String email = "dummy3gk@gmail.com";

    @BeforeAll
    void setup() {
        driver = BrowserSetup.getDriver();
        lumaHomePage = new LumaHomePage(driver);
        lumaSingUpPage = new LumaSingUpPage(driver);
        lumaUserAccountPage = new LumaUserAccountPage(driver);
        lumaSignInPage = new LumaSignInPage(driver);
    }

    @Test
    @Order(1)
    @DisplayName("Given I am on the signup page, When I enter valid details, Then I should be registered successfully")
    void testUserSingUpPage() {
        lumaHomePage.openWebUrl();
        Assertions.assertTrue(lumaHomePage.verifyHomePageText(), "having problem in opening home page");
        lumaHomePage.clickOnCreateAccount();
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertTrue(currentUrl.contains("https://magento.softwaretestingboard.com/customer/account/create/"), "Having problem in opening sign up page");
        lumaSingUpPage.setFirstName(firstName);
        lumaSingUpPage.setLastName(lastName);
        lumaSingUpPage.setEmail(email);
        lumaSingUpPage.setPassword(password);
        lumaSingUpPage.setConfirmationPassword(password);
        lumaSingUpPage.clickOnCreateAccount();
        Assertions.assertTrue(lumaUserAccountPage.verifyWelcomeText(firstName, lastName), "Failed to create account, please check email and password again");
    }

    @Test
    @Order(2)
    @DisplayName("Given I am on the user account page, When I click on sign out, Then I should be redirected to the home page")
    void testUserForSignOut() {
        lumaUserAccountPage.clickOnWelcomeDropdown();
        lumaUserAccountPage.clickOnSignOut();
        Assertions.assertTrue(lumaHomePage.verifyHomePageText(), "Failed to sign out");
    }

    @Test
    @Order(3)
    @DisplayName("Given I am on the login page, When I enter valid credentials, Then I should be redirected to the dashboard")
    void testUserSignInPage() {
        lumaHomePage.clickOnSignIn();
        lumaSignInPage.setEmail(email);
        lumaSignInPage.setPassword(password);
        lumaSignInPage.clickOnSignInButton();
        Assertions.assertTrue(lumaUserAccountPage.verifyWelcomeText(firstName, lastName), "Failed to login");
    }

    @AfterAll
    static void tearDown() {
        BrowserSetup.quitDriver();
    }
}

