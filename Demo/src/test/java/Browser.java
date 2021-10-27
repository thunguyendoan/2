import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Browser {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void getCurrentURL() {
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();

        String getURL = driver.getCurrentUrl();
        Assert.assertEquals(getURL,"http://live.techpanda.org/index.php/customer/account/login/");
        System.out.println(getURL);

        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();

        String getCreateURL = driver.getCurrentUrl();
        Assert.assertEquals(getCreateURL,"http://live.techpanda.org/index.php/customer/account/create/");
        System.out.println(getCreateURL);
    }

    @Test
    public void getTitle() {
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();

        String getAccountTitle = driver.getTitle();
        Assert.assertEquals(getAccountTitle,"Customer Login");
        System.out.println(getAccountTitle);

        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();

        String getCreateTitle = driver.getTitle();
        Assert.assertEquals(getCreateTitle,"Create New Customer Account");
        System.out.println(getCreateTitle);
    }

    @Test
    public void navigation() {
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();

        String getCreateURL = driver.getCurrentUrl();
        Assert.assertEquals(getCreateURL,"http://live.techpanda.org/index.php/customer/account/create/");
        System.out.println(getCreateURL);

        driver.navigate().back();
        String getLoginURL = driver.getCurrentUrl();
        Assert.assertEquals(getLoginURL,"http://live.techpanda.org/index.php/customer/account/login/");
        System.out.println(getLoginURL);

        driver.navigate().forward();
        String getRegisterURL = driver.getTitle();
        Assert.assertEquals(getRegisterURL,"Create New Customer Account");
        System.out.println(getRegisterURL);

    }


    @AfterClass
    public void cleanData() {
        // close browser after run all test case
        driver.quit();

    }
}
