import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class MainTest {

    WebDriver driver;
    @BeforeTest
    public void setUP() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver","/Users/abhi.sakthivel/Downloads/geckodriver");
        driver = new FirefoxDriver();
//        System.setProperty("webdriver.chrome.driver","/Users/abhi.sakthivel/Downloads/chromedriver_mac64/chromedriver");
//        driver = new ChromeDriver();
        driver.get("https://www.mall.cz/");
        driver.manage().window().maximize();
        driver.navigate().refresh();
        Thread.sleep(3000);
        System.out.println(driver.getTitle());
    }

    @Test
    public void verify() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.checkFirstCorousel();
        homePage.checkSecondCorousel();
        homePage.checkThirdCorousel();
        homePage.checkFourthCorousel();
        homePage.checkFifthhCorousel();
        homePage.checkSixthCorousel();
        homePage.checkSeventhCorousel();
    }

    @AfterTest
    public void exitbrowser() throws InterruptedException {
        driver.quit();
    }


}
