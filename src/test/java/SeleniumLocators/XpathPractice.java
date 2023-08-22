package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathPractice {
    /*
1-Navigate to the website http://tutorialsninja.com/demo/index.php?route=account/register
2-Provide First name,LastName,Email,Telephone,password,confirm password
and click privacy policy button.(isDisplayed and notSelected then click)
3-Click Continue Button
4-Validate message (Your Account Has Been Created!) -->if statement
5-Click Continue Button
6-Validate the url https://tutorialsninja.com/demo/index.php?route=account/account
7-Close your browser
NOTE:Please USE ALL XPATH TO LOCATE THE ELEMENT
 */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");

        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.sendKeys("Guli");
        WebElement lastName = driver.findElement(By.xpath("//input[@id='input-lastname']"));
        lastName.sendKeys("Esonova");
        WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
        email.sendKeys("Guli123@Gmail.com");
        WebElement phone = driver.findElement(By.xpath("//input[@id='input-telephone']"));
        phone.sendKeys("123546789");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("123456");
        WebElement passwordC = driver.findElement(By.xpath("//input[@id='input-confirm']"));
        passwordC.sendKeys("123456");
        WebElement box = driver.findElement(By.xpath("//input[@name='agree']"));
        box.click();
        WebElement continueButton = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
        continueButton.click();
        WebElement successMessage = driver.findElement(By.xpath("//h1[contains(text(),'Your Account')]"));
        String actualMessage = successMessage.getText();
        String expectedMessage = "Your Account Has Been Created!";
        System.out.println(actualMessage.equals(expectedMessage) ? "Passed" : "Failed");
        driver.getCurrentUrl();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://tutorialsninja.com/demo/index.php?route=account/success";
        System.out.println(actualUrl.equals(expectedUrl) ? "Passed" : "Failed");
        driver.close();




    }
}
