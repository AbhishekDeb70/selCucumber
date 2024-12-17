package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "customer_email")
    @CacheLookup
    WebElement txtEmail;

    @FindBy(id = "customer_password")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(xpath = "//input[@value='Sign In']")
    @CacheLookup
    WebElement btnSignIn;

    @FindBy(xpath = "//input[@value='Sign In']")
    @CacheLookup
    WebElement btnLogout;

    public void setUsername(String usrName) {
        txtEmail.clear();
        txtEmail.sendKeys(usrName);
    }

    public void setPwd(String pwd) {
        txtPassword.clear();
        txtPassword.sendKeys(pwd);
    }

    public void clickSignIn() {
        btnSignIn.click();
    }

    public void clickLogOut() {
        btnLogout.click();
    }

}

