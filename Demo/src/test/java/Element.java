import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Element {
    WebDriver driver;

    By emailTextbox = By.id("email");
    By ageUnderRadioBy = By.id("under_18");
    By educationTextbox = By.id("edu");
    By user5TextBy = By.xpath("//h5[text()='Name: User5']");
    By passwordTextbox = By.id("password");
    By bioTextAreaBy = By.id("bio");
    By javaCheckbox = By.id("java");

    By email1Textbox = By.xpath("//input[@id='email']");
    By userTextbox = By.xpath("//input[@id='new_username']");
    By password1Textbox = By.xpath("//input[@id='new_password']");
    By maketingTextbox = By.id("marketing_newsletter");
    By signupButton = By.xpath("//button[@id='create-account']");

    @BeforeClass
    public void beforeClass() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();


    }

    @Test
    public void TC_04_PasswordIsNum() {
        driver.get("https://login.mailchimp.com/signup/");

        if(isElementEnable(signupButton)) {
            sendKeyToElement(email1Textbox,"thu@mailinator.com");
            sendKeyToElement(userTextbox,"thu");
            sendKeyToElement(password1Textbox,"1");
        }

    }

    @Test
    public void TC_05_PasswordIsLower() {
        driver.get("https://login.mailchimp.com/signup/");

        if(isElementEnable(signupButton)) {
            sendKeyToElement(email1Textbox,"thu@mailinator.com");
            sendKeyToElement(userTextbox,"thu");
            sendKeyToElement(password1Textbox,"thu");
        }
    }

    @Test
    public void TC_06_PasswordIsUpper() {
        driver.get("https://login.mailchimp.com/signup/");

        if(isElementEnable(signupButton)) {
            sendKeyToElement(email1Textbox,"thu@mailinator.com");
            sendKeyToElement(userTextbox,"thu");
            sendKeyToElement(password1Textbox,"Thu");
        }
    }

    @Test
    public void TC_07_PasswordIsSpecial() {
        driver.get("https://login.mailchimp.com/signup/");

        if(isElementEnable(signupButton)) {
            sendKeyToElement(email1Textbox,"thu@mailinator.com");
            sendKeyToElement(userTextbox,"thu");
            sendKeyToElement(password1Textbox,"!@#");
        }
    }

    @Test
    public void TC_08_PasswordIs9char() {
        driver.get("https://login.mailchimp.com/signup/");

        if(isElementEnable(signupButton)) {
            sendKeyToElement(email1Textbox,"thu@mailinator.com");
            sendKeyToElement(userTextbox,"thu");
            sendKeyToElement(password1Textbox,"trungthu97");
        }
    }

    @Test
    public void TC_09_iSelected() {
        driver.get("https://login.mailchimp.com/signup/");

        clicktoElement(maketingTextbox);
        Assert.assertTrue(isElementSelected(maketingTextbox));
    }

    @Test
    public void TC_01_isDisplay() {
        driver.get("https://automationfc.github.io/basic-form/");

        if(isElementDisplay(emailTextbox)) {
            sendKeyToElement(emailTextbox,"automation testing");
        }

        if(isElementDisplay(ageUnderRadioBy)) {
            clicktoElement(ageUnderRadioBy);
        }

        if(isElementDisplay(educationTextbox)) {
            sendKeyToElement(educationTextbox,"automation testing");
        }

        Assert.assertFalse(isElementDisplay(user5TextBy));
    }

    @Test
    public void TC_02_isEnable() {
        driver.get("https://automationfc.github.io/basic-form/");

        driver.navigate().refresh();

        //Expected is True
        Assert.assertTrue(isElementEnable(emailTextbox));
        Assert.assertTrue(isElementEnable(ageUnderRadioBy));
        Assert.assertTrue(isElementEnable(educationTextbox));

        //Expected is False
        Assert.assertFalse(isElementEnable(passwordTextbox));
        Assert.assertFalse(isElementEnable(bioTextAreaBy));


    }

    @Test
    public void TC_03_isSelected() {
        driver.navigate().refresh();

        clicktoElement(ageUnderRadioBy);
        Assert.assertTrue(isElementSelected(ageUnderRadioBy));

        clicktoElement(javaCheckbox);
        clicktoElement(javaCheckbox);
        Assert.assertFalse(isElementSelected(javaCheckbox));

    }


    public boolean isElementDisplay(By by) {
        WebElement element = driver.findElement(by);
        if(element.isDisplayed()) {
            System.out.println("Element is display" + by);
            return true;
        } else {
            System.out.println("Element is not display" + by);
            return false;
        }
    }

    public boolean isElementEnable(By by) {
        WebElement element = driver.findElement(by);
        if(element.isEnabled()) {
            System.out.println("Element is Enable " + by);
            return true;
        } else {
            System.out.println("Element is not Enable " + by);
            return false;
        }
    }

    public boolean isElementSelected(By by) {
        WebElement element = driver.findElement(by);
        if(element.isSelected()) {
            System.out.println("Element is selected" + by);
            return true;
        } else {
            System.out.println("Element is not Selected " + by);
            return false;
        }
    }

    public void sendKeyToElement(By by, String value) {
        WebElement element = driver.findElement(by);
        element.clear();
        element.sendKeys(value);
    }

    public void clicktoElement(By by) {
        WebElement element = driver.findElement(by);
        element.click();
    }


    @AfterClass
    public void cleanData() {
        // close browser after run all test case
        driver.quit();

    }
}
