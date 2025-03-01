
import org.example.Browser.BrowserSetup;
import org.example.Pages.LumaHomePage;
import org.example.Pages.LumaSignInPage;
import org.example.Pages.LumaSingUpPage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class MyTest {
    private WebDriver driver;
    private LumaHomePage lumaHomePage;
    private LumaSingUpPage lumaSingUpPage;
    private LumaSignInPage lumaSignInPage;

    @Before
    public void setUp() {
        driver = BrowserSetup.getDriver();
        lumaHomePage = new LumaHomePage(driver);
        lumaSingUpPage = new LumaSingUpPage(driver);
        lumaSignInPage = new LumaSignInPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

