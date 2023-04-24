package automation_test.php_travel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ScreenCapture;
public class TestNGWebDriver {
    WebDriver driver;
    @BeforeMethod
    public void browserInitialization() {
        WebDriverManager.chromedriver().setup();
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-orgins=*");
        driver = new ChromeDriver();
        driver.get("https://phptravels.com/demo/");
        driver.manage().window().maximize();

    }
    @Test
    public void verifyHomePageTitle(){

        String expectedTitle = "Book Your Free Demo Now - Phptravels";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);


    }
    @AfterMethod
    public void closeBrowser(ITestResult result) {
        if(ITestResult.FAILURE == result.getStatus()){
            try {
                ScreenCapture.getScreenShot(driver);
            }catch(Exception e ) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
        driver.quit();
    }
}
