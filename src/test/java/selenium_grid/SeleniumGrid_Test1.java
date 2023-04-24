package selenium_grid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utilities.DriverFactory;
public class SeleniumGrid_Test1 {
    private static final Logger LOGGER = LogManager.getLogger(SeleniumGrid_Test1.class);

    @Test
    public void executeInAwsDocker() {
        WebDriver driver = DriverFactory.getInstance().getDriver();
        driver.get("https://www.mortgagecalculator.org/");
        driver.manage().window().maximize();
        LOGGER.info(driver.getTitle());
        driver.quit();
    }
}
