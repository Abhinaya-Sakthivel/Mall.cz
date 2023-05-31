import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HomePage {
     WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    static String navigationSection1 = "(//button[@type='button'])[3]";
    static String navigationSection2 = "(//button[@type='button'])[5]";
    static String navigationSection3 = "(//button[@type='button'])[7]";
    static String navigationSection4 = "(//button[@type='button'])[9]";
    static String navigationSection5 = "(//button[@type='button'])[11]";
    static String navigationSection6 = "(//button[@type='button'])[13]";
    static String navigationSection7 = "(//button[@type='button'])[15]";

//    public static void main(String[] args) throws InterruptedException {
//        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//
//        // Create ChromeOptions object
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        options.addArguments("--disable-extensions");
//        options.addArguments("--disable-popup-blocking");
//        options.addArguments("--disable-infobars");
//        options.addArguments("--no-sandbox");
//        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--disable-browser-side-navigation");
//        options.addArguments("--disable-blink-features=AutomationControlled");
//        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
//        options.setExperimentalOption("useAutomationExtension", false);


        public void checkFirstCorousel() throws InterruptedException {
            System.out.println("Testcase1 - Check Section 1 15 items, if not fail test case");
            int result1 = getAllProductCount(navigationSection1);
            Assert.assertEquals(result1, 15);
        }
        public void checkSecondCorousel() throws InterruptedException {
            System.out.println("Testcase2 - Check Section 2 contains 15 items, if not fail test case");
            int result2 = getAllProductCount(navigationSection2);
            Assert.assertEquals(result2, 15);
        }

        public void checkThirdCorousel() throws InterruptedException {
            System.out.println("Testcase3 - Check Section 3 contains 15 items, if not fail test case");
            int result3 = getAllProductCount(navigationSection3);
            Assert.assertEquals(result3, 15);
        }
        public void checkFourthCorousel() throws InterruptedException {
            System.out.println("Testcase4 - Check Section 4 contains 15 items, if not fail test case");
            int result4 = getAllProductCount(navigationSection4);
            Assert.assertEquals(result4, 15);
            }

        public void checkFifthhCorousel() throws InterruptedException {
            System.out.println("Testcase5 - Check Section 5 contains 15 items, if not fail test case");
            int result5 = getAllProductCount(navigationSection5);
            Assert.assertEquals(result5, 15);
        }
        public void checkSixthCorousel() throws InterruptedException {
            System.out.println("Testcase6 - Check Section 6 contains 15 items, if not fail test case");
            int result6 = getAllProductCount(navigationSection6);
            Assert.assertEquals(result6, 15);
        }
        public void checkSeventhCorousel() throws InterruptedException {
            System.out.println("Testcase7 - Check Section 7 contains 15 items, if not fail test case");
            int result7 = getAllProductCount(navigationSection7);
            Assert.assertEquals(result7, 15);
        }



    public  int getAllProductCount(String goToSection) throws InterruptedException {
        //get the corousel section to test
        selectSection(goToSection);
        return getProductCount(goToSection);
    }

    public  void selectSection(String goToSection) throws InterruptedException {
            //Scroll to each corousel section
        Actions action = new Actions(driver);
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        do {
            try {
                WebElement ele_Section = driver.findElement(By.xpath(goToSection));
                executor.executeScript("arguments[0].scrollIntoView(true);", ele_Section);
                break;
            } catch (NoSuchElementException e) {
                action.sendKeys(Keys.PAGE_DOWN).perform();
                Thread.sleep(1000);
            }
        }
        while (true);
    }


    public  int getProductCount(String getItem) throws InterruptedException {
        // after reaching the section, get the items count
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        List<String> itemsToAdd = new ArrayList<>();

        do {
            List<WebElement> allItems = driver.findElements(By.xpath("//div[@class='product-box-simple__body']/h3"));
            allItems.stream().filter(WebElement::isDisplayed).forEach(element -> itemsToAdd.add(element.getText()));
            if (driver.findElement(By.xpath(navigationSection1)).getAttribute("class").contains("disabled")) {
                break;
            }
            executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(getItem)));
            Thread.sleep(1000);
        }
        while (true);
        int total_items = (int) itemsToAdd.stream().distinct().count();
        System.out.println("count of items"+total_items);
        return total_items;
    }
}