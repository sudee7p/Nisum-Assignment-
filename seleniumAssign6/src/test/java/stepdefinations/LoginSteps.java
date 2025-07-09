package stepdefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.*;

public class LoginSteps {
    WebDriver driver;

    @Given("the user is on the login page")
    public void openLoginPage() {
        driver = new ChromeDriver();
        driver.get("https://yourapp.com/login"); // Update with actual URL
    }

    @When("the user enters valid username {string} and password {string}")
    public void enterValidCredentials(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @When("the user enters invalid username {string} and password {string}")
    public void enterInvalidCredentials(String username, String password) {
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("clicks the login button")
    public void clickLoginButton() {
        driver.findElement(By.id("loginButton")).click();
    }

    @Then("the user should be redirected to the dashboard")
    public void checkDashboardRedirect() {
        assertTrue(driver.getCurrentUrl().contains("dashboard"));
        driver.quit();
    }

    @Then("an error message should be displayed")
    public void checkErrorMessage() {
        assertTrue(driver.findElement(By.id("errorMsg")).isDisplayed());
        driver.quit();
    }
}
