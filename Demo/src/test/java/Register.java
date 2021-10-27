import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Register {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void TC_01_Empty_FirstName() {

        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.id("txtFirstname")).sendKeys("");

        driver.findElement(By.id("txtEmail")).sendKeys("abc@mailinator.com");

        driver.findElement(By.id("txtCEmail")).sendKeys("abc@mailinator.com");

        driver.findElement(By.id("txtPassword")).sendKeys("123456");

        driver.findElement(By.id("txtCPassword")).sendKeys("123456");

        driver.findElement(By.id("txtPhone")).sendKeys("0323456789");

        driver.findElement(By.xpath("//div[@class='field_btn']/button[@type='submit']")).click();

        String emailError = driver.findElement(By.xpath("//label[@id='txtFirstname-error']")).getText();
        Assert.assertEquals(emailError,"Vui lòng nhập họ tên");
        System.out.println(emailError);

    }

    @Test
    public void TC_02_Empty_Field() {

        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.xpath("//div[@class='field_btn']/button[@type='submit']")).click();

        String firstNameError = driver.findElement(By.xpath("//label[@id='txtFirstname-error']")).getText();
        Assert.assertEquals(firstNameError,"Vui lòng nhập họ tên");
        System.out.println(firstNameError);

        String emailError = driver.findElement(By.xpath("//label[@id='txtEmail-error']")).getText();
        Assert.assertEquals(emailError,"Vui lòng nhập email");
        System.out.println(emailError);

        String confirmEmailError = driver.findElement(By.xpath("//label[@id='txtCEmail-error']")).getText();
        Assert.assertEquals(confirmEmailError,"Vui lòng nhập lại địa chỉ email");
        System.out.println(confirmEmailError);

        String passError = driver.findElement(By.xpath("//label[@id='txtPassword-error']")).getText();
        Assert.assertEquals(passError,"Vui lòng nhập mật khẩu");
        System.out.println(passError);


        String confirmPassError = driver.findElement(By.xpath("//label[@id='txtCPassword-error']")).getText();
        Assert.assertEquals(confirmPassError,"Vui lòng nhập lại mật khẩu");
        System.out.println(confirmPassError);


        String phoneError = driver.findElement(By.xpath("//label[@id='txtPhone-error']")).getText();
        Assert.assertEquals(phoneError,"Vui lòng nhập số điện thoại.");
        System.out.println(phoneError);

    }

    @Test
    public void invalidEmail() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.id("txtFirstname")).sendKeys("thu");

        driver.findElement(By.id("txtEmail")).sendKeys("thu@");

        driver.findElement(By.id("txtCEmail")).sendKeys("thu@");

        driver.findElement(By.id("txtPassword")).sendKeys("123456");

        driver.findElement(By.id("txtCPassword")).sendKeys("123456");

        driver.findElement(By.id("txtPhone")).sendKeys("0323456789");

        driver.findElement(By.xpath("//div[@class='field_btn']/button[@type='submit']")).click();

        String emailError = driver.findElement(By.xpath("//label[@id='txtEmail-error']")).getText();
        Assert.assertEquals(emailError,"Vui lòng nhập email hợp lệ");
        System.out.println(emailError);

        String confirmEmailError = driver.findElement(By.xpath("//label[@id='txtCEmail-error']")).getText();
        Assert.assertEquals(confirmEmailError,"Email nhập lại không đúng");
        System.out.println(confirmEmailError);

    }

    @Test
    public void invalidConfirmEmail() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.id("txtFirstname")).sendKeys("thu");

        driver.findElement(By.id("txtEmail")).sendKeys("thu@mailinator.com");

        driver.findElement(By.id("txtCEmail")).sendKeys("thu1@mailinator.com");

        driver.findElement(By.id("txtPassword")).sendKeys("123456");

        driver.findElement(By.id("txtCPassword")).sendKeys("123456");

        driver.findElement(By.id("txtPhone")).sendKeys("0323456789");

        driver.findElement(By.xpath("//div[@class='field_btn']/button[@type='submit']")).click();

        String confirmEmailError = driver.findElement(By.xpath("//label[@id='txtCEmail-error']")).getText();
        Assert.assertEquals(confirmEmailError,"Email nhập lại không đúng");
        System.out.println(confirmEmailError);


    }

    @Test
    public void invalidPassword() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.id("txtFirstname")).sendKeys("thu");

        driver.findElement(By.id("txtEmail")).sendKeys("thu@mailinator.com");

        driver.findElement(By.id("txtCEmail")).sendKeys("thu@mailinator.com");

        driver.findElement(By.id("txtPassword")).sendKeys("12345");

        driver.findElement(By.id("txtCPassword")).sendKeys("12345");

        driver.findElement(By.id("txtPhone")).sendKeys("0323456789");

        driver.findElement(By.xpath("//div[@class='field_btn']/button[@type='submit']")).click();

        String passError = driver.findElement(By.xpath("//label[@id='txtPassword-error']")).getText();
        Assert.assertEquals(passError,"Mật khẩu phải có ít nhất 6 ký tự");
        System.out.println(passError);


        String confirmPassError = driver.findElement(By.xpath("//label[@id='txtCPassword-error']")).getText();
        Assert.assertEquals(confirmPassError,"Mật khẩu phải có ít nhất 6 ký tự");
        System.out.println(confirmPassError);
    }

    @Test
    public void invalidConfirmPassword() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.id("txtFirstname")).sendKeys("thu");

        driver.findElement(By.id("txtEmail")).sendKeys("thu@mailinator.com");

        driver.findElement(By.id("txtCEmail")).sendKeys("thu@mailinator.com");

        driver.findElement(By.id("txtPassword")).sendKeys("123456");

        driver.findElement(By.id("txtCPassword")).sendKeys("123457");

        driver.findElement(By.id("txtPhone")).sendKeys("0323456789");

        driver.findElement(By.xpath("//div[@class='field_btn']/button[@type='submit']")).click();


        String confirmPassError = driver.findElement(By.xpath("//label[@id='txtCPassword-error']")).getText();
        Assert.assertEquals(confirmPassError,"Mật khẩu bạn nhập không khớp");
        System.out.println(confirmPassError);
    }

    @Test
    public void invalidPhone() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.id("txtFirstname")).sendKeys("thu");

        driver.findElement(By.id("txtEmail")).sendKeys("thu@mailinator.com");

        driver.findElement(By.id("txtCEmail")).sendKeys("thu@mailinator.com");

        driver.findElement(By.id("txtPassword")).sendKeys("123456");

        driver.findElement(By.id("txtCPassword")).sendKeys("123457");

        driver.findElement(By.id("txtPhone")).sendKeys("03234567");

        driver.findElement(By.xpath("//div[@class='field_btn']/button[@type='submit']")).click();

        String phoneError = driver.findElement(By.xpath("//label[@id='txtPhone-error']")).getText();
        Assert.assertEquals(phoneError,"Số điện thoại phải từ 10-11 số.");
        System.out.println(phoneError);
    }

    @Test
    public void invalidStartPhone() {
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        driver.findElement(By.id("txtFirstname")).sendKeys("thu");

        driver.findElement(By.id("txtEmail")).sendKeys("thu@mailinator.com");

        driver.findElement(By.id("txtCEmail")).sendKeys("thu@mailinator.com");

        driver.findElement(By.id("txtPassword")).sendKeys("123456");

        driver.findElement(By.id("txtCPassword")).sendKeys("123457");

        driver.findElement(By.id("txtPhone")).sendKeys("13234567");

        driver.findElement(By.xpath("//div[@class='field_btn']/button[@type='submit']")).click();

        String phoneError = driver.findElement(By.xpath("//label[@id='txtPhone-error']")).getText();
        Assert.assertEquals(phoneError,"Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019");
        System.out.println(phoneError);
    }



    @AfterClass
    public void cleanData() {
        // close browser after run all test case
        driver.quit();

    }
}
