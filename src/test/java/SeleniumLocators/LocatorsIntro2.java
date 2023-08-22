package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro2 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("file:///C:/Users/esono/Downloads/Techtorialhtml.html");

        //TAG NAME LOCATOR
        WebElement version = driver.findElement(By.tagName("u"));
        String actualVersion = version.getText();
        String expectedVersion = "Use Java Version";
        System.out.println(actualVersion.equals(expectedVersion) ? "Passed" : "Failed");

        //LINK TEXT LOCATOR
        WebElement javaLink = driver.findElement(By.linkText("Java"));
        javaLink.click();
        WebElement header = driver.findElement(By.tagName("h1"));
        String actualHeader = header.getText();
        String expectedHeader = "Java";
        System.out.println(actualHeader.equals(expectedHeader) ? "Passed" : "Failed");

        driver.navigate().back();

        WebElement selenium = driver.findElement(By.linkText("Selenium"));
        selenium.click();
        WebElement header2 = driver.findElement(By.tagName("h1"));
        String actualHeader2 = header2.getText();
        String expectedHeader2 = "Selenium automates browsers. That's it!";
        System.out.println(actualHeader2.equals(expectedHeader2) ? "Passed" : "Failed");

        driver.navigate().back();

        WebElement cucumber = driver.findElement(By.linkText("Cucumber"));
        cucumber.click();
        WebElement paragraph = driver.findElement(By.linkText("h1"));
        String actualParagraph = paragraph.getText();
        String expectedParagraph = "Tools & techniques that elevate teams to greatness";
        System.out.println(actualParagraph.equals(expectedParagraph) ? "Passed" : "Failed");

        driver.navigate().back();

        // PARTIAL LINK TEXT
        WebElement rest_api = driver.findElement(By.partialLinkText("Rest"));
        rest_api.click();
        System.out.println(driver.getTitle());
















    }
}
