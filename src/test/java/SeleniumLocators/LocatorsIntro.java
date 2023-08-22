package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro {
    //LOCATORS: Is a way to locate(find) the element and manipulate on it
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("file:///C:/Users/esono/Downloads/Techtorialhtml.html");
        WebElement header = driver.findElement(By.id("techtorial1"));
        System.out.println(header.getText());//Techtorial Academy
        String actualHeader = header.getText();
        String expectedHeader = "Techtorial Academy";
        System.out.println(actualHeader.equals(expectedHeader) ? "Passed" : "Failed");

        WebElement paragraph = driver.findElement(By.id("details2"));
        System.out.println(paragraph.getText());


        //NAME LOCATOR
        WebElement firstName = driver.findElement(By.name("firstName"));
        firstName.sendKeys("Guli");
        WebElement lastname = driver.findElement(By.name("lastName"));
        lastname.sendKeys("Esonova");
        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys("123456789");
        WebElement email = driver.findElement(By.id("userName"));
        email.sendKeys("guli123@gmail.com");
        WebElement address = driver.findElement(By.name("address1"));
        address.sendKeys("1234 W 22 Street");
        WebElement city = driver.findElement(By.name("city"));
        city.sendKeys("Des Plaines");
        WebElement state = driver.findElement(By.name("state"));
        state.sendKeys("IL");
        WebElement zip = driver.findElement(By.name("postalCode"));
        zip.sendKeys("123546");


        //CLASSNAME LOCATOR:
        WebElement allTools = driver.findElement(By.className("group_checkbox"));
        System.out.println(allTools.getText());

        WebElement javaBox = driver.findElement(By.id("cond1"));
        if (javaBox.isDisplayed() && !javaBox.isSelected()){
            javaBox.click();
        }
        System.out.println(javaBox.isSelected() ? "Selected" : "Not Selected");

        WebElement seleniumBox = driver.findElement(By.id("cond2"));
        if (seleniumBox.isDisplayed() && !seleniumBox.isSelected()){
            seleniumBox.click();
        }
        System.out.println(seleniumBox.isSelected() ? "Selected" : "Not Selected");

        WebElement testNG = driver.findElement(By.id("cond3"));
        if (testNG.isDisplayed() && !testNG.isSelected()){
            testNG.click();
        }
        System.out.println(testNG.isSelected() ? "Selected" : "Not Selected");

        WebElement cucumber = driver.findElement(By.id("cond4"));
        if (cucumber.isDisplayed() && !cucumber.isSelected()){
            cucumber.click();
        }
        System.out.println(cucumber.isSelected() ? "Selected" : "Not Selected");



        //










    }





}
