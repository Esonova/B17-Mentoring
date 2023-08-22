package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorPractice {
      /*
1-Open this link - https://www.techlistic.com/p/selenium-practice-form.html
2-Enter first and last name (textbox).
3-Select gender (radio button).
4-Select years of experience (radio button).
5-Enter date.(send keys)
6-Select Profession (Checkbox). -->choose Both
7-Select Automation tools you are familiar with (multiple checkboxes). --> Choose Selenium
8-Select Continent(Send Keys).
9-Click on Submit button.
10-Validate the url https://www.techlistic.com/p/selenium-practice-form.html
10-Close the webpage
Try your own logic and automate it without any help.
     */

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Guli");
        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Nova");
        Thread.sleep(2000);
        WebElement gender = driver.findElement(By.id("sex-1"));
        gender.click();
        Thread.sleep(3000);
        WebElement experience = driver.findElement(By.id("exp-3"));
        experience.click();
        Thread.sleep(3000);
        WebElement date = driver.findElement(By.id("datepicker"));
        date.sendKeys("8/8/23");
        WebElement profession1 = driver.findElement(By.id("profession-0"));
        profession1.click();
        Thread.sleep(3000);
        WebElement profession2 = driver.findElement(By.id("profession-1"));
        profession2.click();
        Thread.sleep(3000);
        WebElement tools = driver.findElement(By.id("tool-0"));
        tools.click();
        Thread.sleep(3000);
        WebElement tools2 = driver.findElement(By.id("tool-2"));
        tools2.click();
        Thread.sleep(3000);
        WebElement continent = driver.findElement(By.id("continents"));
        continent.sendKeys("Asia");
        WebElement button = driver.findElement(By.id("submit"));
        button.click();
        Thread.sleep(3000);

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.techlistic.com/p/selenium-practice-form.html";
        System.out.println(actualUrl.equals(expectedUrl) ? "Passed" : "Failed");
        driver.close();












    }
}

