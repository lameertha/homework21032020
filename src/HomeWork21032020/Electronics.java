package HomeWork21032020;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Electronics {
    private String baseUrl = "https://demo.nopcommerce.com/";
    private WebDriver driver;


    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        driver = new ChromeDriver(options);
        driver.manage().window().setPosition(new Point(2000, 0));//display 2
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void cameraAndPhotos() throws InterruptedException {

        Actions actions = new Actions(driver);
        WebElement subElement = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Electronics')]"));
        actions.moveToElement(subElement).perform();

        WebElement clickOnCamera = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Camera & photo')]"));
        actions.moveToElement(clickOnCamera).click().perform();

        WebElement position = driver.findElement(By.xpath("//select[@id='products-orderby']"));
        position.click();

        WebElement Sortby = driver.findElement(By.xpath("//option[contains(text(),'Price: Low to High')]"));
        Sortby.click();
    }
    @After
    public void closeBrowser(){
        driver.quit();

    }
}