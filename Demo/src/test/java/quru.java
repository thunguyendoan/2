import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class quru {
    WebDriver driver;
    String loginPageURL, getUserID, getPasswordID;

    //Login page
    By userName = By.xpath("//input[@name='uid']");
    By passwordTexbox = By.xpath("//input[@name='password']");
    By btnLogin = By.xpath("//input[@name='btnLogin']");

    //Register Page
    By loginPage = By.xpath("//a[text()='here']");
    By emailTextbox = By.xpath("//input[@name='emailid']");
    By btnSubmit = By.xpath("//input[@name='btnLogin']");
    By userID = By.xpath("//td[text()='User ID :']/following-sibling::td");
    By passwordID = By.xpath("//td[text()='Password :']/following-sibling::td");

    // Managerome page
    By getWelcomeText = By.xpath("//marquee[@class='heading3']");

    // Create New Account
    By goNewAccountPage = By.xpath("//a[text()='New Customer']");
    By nameTextbox = By.name("name");
    By DOBTextbox = By.name("dob");
    By addressTextbox = By.name("addr");
    By cityTextbox = By.name("city");
    By stateTextbox = By.name("state");
    By pinTextbox = By.name("pinno");
    By phoneTextbox = By.name("telephoneno");
    By email1Textbox = By.name("emailid");
    By passwordTextbox = By.name("password");
    By btnSubmit1 = By.name("sub");
    By getMessage = By.xpath("//p[@class='heading3']");

    // Get Output
    By locatorCustomerName = By.xpath("//td[text()='Customer Name']/following-sibling::td");
    By locatorDayofBirth = By.xpath("//td[text()='Birthdate']/following-sibling::td");
    By locatorAddress = By.xpath("//td[text()='Address']/following-sibling::td");
    By locatorCity = By.xpath("//td[text()='City']/following-sibling::td");
    By locatorState = By.xpath("//td[text()='State']/following-sibling::td");
    By locatorPin = By.xpath("//td[text()='Pin']/following-sibling::td");
    By locatorPhone = By.xpath("//td[text()='Mobile No.']/following-sibling::td");
    By locatorEmail = By.xpath("//td[text()='Email']/following-sibling::td");


    // input data in Create new account page
    String customerName = "trung thu";
    String date = "10";
    String month = "03";
    String year = "1997";
    String dateOfBirthInput = month + "/" + date + "/" + year;
    String DateOfBirthOutput = year + "-" + date + "-" + month;
    String addressInput = "434 le loi\nHai Chau\nDa Nang";
    String addressOutput = addressInput.replace("\n", " ");
    String city = "Da nang";
    String state = "Hai Chau";
    String pin = "123456";
    String phone = "0988889999";
    String email = "thu" + getRamdomNuber() + "@mailinator.com";


    @BeforeClass
    public void beforeClass() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void TC_01_Register() {
        driver.get("https://demo.guru99.com/v4/");

        loginPageURL = driver.getCurrentUrl();

        driver.findElement(loginPage).click();
        driver.findElement(emailTextbox).sendKeys("thu@mailinator.com");
        driver.findElement(btnSubmit).click();

        // get text UserID and Password
        getUserID = driver.findElement(userID).getText();
        getPasswordID = driver.findElement(passwordID).getText();

    }

    @Test
    public void TC_02_Login() {
        driver.get(loginPageURL);

        driver.findElement(userName).sendKeys(getUserID);
        driver.findElement(passwordTexbox).sendKeys(getPasswordID);

        driver.findElement(btnLogin).click();

        String getWelcome = driver.findElement(getWelcomeText).getText();
        Assert.assertEquals(getWelcome, "Welcome To Manager's Page of Guru99 Bank");

    }

    @Test
    public void TC_03_Create_New_Account() throws InterruptedException {
        driver.findElement(goNewAccountPage).click();

        driver.findElement(nameTextbox).sendKeys(customerName);
        driver.findElement(DOBTextbox).sendKeys(dateOfBirthInput);
        driver.findElement(addressTextbox).sendKeys(addressInput);
        driver.findElement(cityTextbox).sendKeys(city);
        driver.findElement(stateTextbox).sendKeys(state);
        driver.findElement(pinTextbox).sendKeys(pin);
        driver.findElement(phoneTextbox).sendKeys(phone);
        driver.findElement(email1Textbox).sendKeys(email);
        driver.findElement(passwordTextbox).sendKeys(getPasswordID);

        driver.findElement(btnSubmit1).click();


        String getMessageSuccess = driver.findElement(getMessage).getText();
        Assert.assertEquals(getMessageSuccess,"Customer Registered Successfully!!!");


        //Get Output
        String getCustomeName = driver.findElement(locatorCustomerName).getText();
        String getBrithday = driver.findElement(locatorDayofBirth).getText();
        String getAddress = driver.findElement(locatorAddress).getText();
        String getCity = driver.findElement(locatorCity).getText();
        String getState = driver.findElement(locatorState).getText();
        String getPin = driver.findElement(locatorPin).getText();
        String getPhone = driver.findElement(locatorPhone).getText();
        String getEmail = driver.findElement(locatorEmail).getText();

        // Verify Output
        Assert.assertEquals(getCustomeName,customerName);
        Assert.assertEquals(getBrithday,DateOfBirthOutput);
        Assert.assertEquals(getAddress,addressOutput);
        Assert.assertEquals(getCity,city);
        Assert.assertEquals(getState,state);
        Assert.assertEquals(getPin,pin);
        Assert.assertEquals(getPhone,phone);
        Assert.assertEquals(getEmail,email);


    }

    public int getRamdomNuber() {
        Random rand = new Random();
        return rand.nextInt(9999);
    }

    @AfterClass
    public void cleanData() {
        // close browser after run all test case
        driver.quit();

    }

}
