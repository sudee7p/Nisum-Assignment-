package org.example.assignment;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoggleSearchTest {

    public static void main(String[] args) {

        // Automatically setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Open Google
            driver.get("https://www.google.com");

            // Enter "BDD in Selenium"
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("BDD in Selenium");

            // Submit search
            searchBox.submit();

            // Wait (bad practice — use WebDriverWait in real projects)
            Thread.sleep(2000);

            // Validate results
            boolean resultsVisible = driver.findElements(By.id("search")).size() > 0;
            System.out.println(resultsVisible ? "✅ Search results found!" : "❌ No results!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
