package StepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;
import test.java.UtilityClasses.BrowserUtil;

import static test.java.UtilityClasses.BrowserUtil.*;

public class MultiBrowserStepDefinitions {
    WebDriver driver;
    LoginPage lp;

    @Given("I launch the {string} browser")
    public void iLaunchTheBrowser(String browser) {
        driver = getDriver(browser);
        lp= new LoginPage(driver);
        System.out.println(browser + " browser launched!");
        driver.manage().window().maximize();
    }

    @When("User opens URL {string}")
    public void iOpenTheApplication(String url) {
        driver.get(url);
        System.out.println("Application opened!");
    }

    @And("User enters Email as {string} and Password as {string}")
    public void user_enters_Email_as_and_Password_as(String email, String password) {
        lp.setUsername(email);
        lp.setPwd(password);
    }

    @And("Clicks on SignIn")
    public void click_on_signin() {
        lp.clickSignIn();
    }

    @Then("Page Title should be {string}")
    public void page_title_should_be(String title) {
        if(driver.getPageSource().contains("Incorrect email or password.")) {
            driver.close();
        }else
        {
            String currentPageTitle = driver.getTitle();
            if(currentPageTitle == title)
                System.out.println("The title is correct");
        }
    }

    @When("User Clicks on logout button")
    public void user_clicks_on_logout() throws InterruptedException {
        lp.clickLogOut();
    }

    @And("closes the browser")
    public void close_browser() {
        closeDriver();
        System.out.println("Browser closed!");
    }
}
