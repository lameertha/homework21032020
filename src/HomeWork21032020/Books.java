package HomeWork21032020;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;



public class Books {
    String baseUrl = "https://demo.nopcommerce.com/";
    WebDriver driver;


    @Before

    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test

    public void verifyUserShouldNavigateToBooksPage(){
        WebElement bookslink = driver.findElement(By.linkText("Books"));
        bookslink.click();
        WebElement welcomeText = driver.findElement(By.xpath("//div[@class=\"page-title\"]//h1"));

        String expectedText = "Books";
        String actualText = welcomeText.getText();
        Assert.assertEquals(expectedText,actualText);
    }

    @Test
    public void booksPage() throws InterruptedException {

        WebElement books = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Books')]"));
        books.click();

        WebElement sortBy = driver.findElement(By.xpath("//option[contains(text(),'Name: A to Z')]"));
        sortBy.click();

        WebElement dropDown = driver.findElement(By.xpath("//select[@name='products-orderby']"));
        dropDown.click();
        Thread.sleep(3000);

        WebElement wishList = driver.findElement(By.xpath(" //div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//input[3]"));
        wishList.click();

        WebElement wishListText = driver.findElement(By.xpath("//p[@class='content']"));
        String expectedText = "The product has been added to your wishlist";
        String actualText = wishListText.getText();
        Assert.assertEquals(expectedText,actualText);
        System.out.println(wishListText.getText());

    }
    @After
    public void closeBrowser(){

        driver.quit();
    }

}

