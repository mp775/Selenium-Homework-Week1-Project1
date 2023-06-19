package nopcommer_url;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowserTest {
    static String browser = "Firefox";
    static String baseUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F\n";
    static WebDriver driver;

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else {
            System.out.println(" wrong browser name.");
        }

        //Open the URL in Browser
        driver.get(baseUrl);
        //maximise browser
        driver.manage().window().maximize();
        //we give implicit wait to drive
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //get the Title of the page
        String title = driver.getTitle();
        System.out.println("Page Title is " + title);
        //get the current url
        System.out.println("Current URL " + driver.getCurrentUrl());
        //get the page source
        System.out.println("Page source " + driver.getPageSource());
        //find login link element
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        // find the Email element
        WebElement emailfield = driver.findElement(By.id("Email"));
        emailfield.sendKeys("prime123@gmail.com");
        //find the password element
        WebElement Passwordlfield = driver.findElement(By.id("Password"));
        Passwordlfield.sendKeys("Prime123");
        //close url
        driver.close();

    }
}




