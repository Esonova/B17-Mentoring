package TestNG;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class OpenCartTestNGPractice {

    @Test
    public void validateSuccessfulLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement username = driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement loginButton = driver.findElement(By.xpath("//button"));
        loginButton.click();
        Thread.sleep(1000);
        String actualTitle = driver.getTitle();
        String expectedTitle = "Dashboard";
        Assert.assertEquals(actualTitle,expectedTitle);



    }

    @Test
    public void validateNegativeScenario() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement username = driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demos");
        WebElement loginButton = driver.findElement(By.xpath("//button"));
        loginButton.click();
        Thread.sleep(1000);

        WebElement alert = driver.findElement(By.id("alert"));
        String actualAlert = alert.getText().trim();
        String expectedAlert = "No match for Username and/or Password.";
        Assert.assertEquals(actualAlert,expectedAlert);

    }



    @Test
    public void validateProductButton() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement username = driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement loginButton = driver.findElement(By.xpath("//button"));
        loginButton.click();
        Thread.sleep(1000);

        WebElement adminButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        adminButton.click();
        WebElement catalog = driver.findElement(By.xpath("//a[@class='parent collapsed']"));
        catalog.click();
        WebElement productButton = driver.findElement(By.xpath("//a[contains(text(),'Products')]"));

        Assert.assertTrue(productButton.isDisplayed());
        Assert.assertTrue(productButton.isEnabled());
        driver.close();

    }

    @Test
    public void validateBoxesFunctionalityProducts() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement username = driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement loginButton = driver.findElement(By.xpath("//button"));
        loginButton.click();
        Thread.sleep(1000);

        WebElement adminButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        adminButton.click();
        WebElement catalog = driver.findElement(By.xpath("//a[@class='parent collapsed']"));
        catalog.click();
        WebElement productButton = driver.findElement(By.xpath("//a[contains(text(),'Products')]"));
        productButton.click();

        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (int i = 1; i < checkboxes.size(); i++) {
            Assert.assertTrue(checkboxes.get(i).isDisplayed());
            Assert.assertTrue(checkboxes.get(i).isEnabled());
            Assert.assertFalse(checkboxes.get(i).isSelected());
            Thread.sleep(1000);
            checkboxes.get(i).click();
            Thread.sleep(1000);
            checkboxes.get(i).sendKeys(Keys.ARROW_DOWN);
            Assert.assertTrue(checkboxes.get(i).isSelected());
            checkboxes.get(i).sendKeys(Keys.ARROW_DOWN);
        }
    }
/*
TASK 2:
//1-you click Products button
//2-You click ProductName Button
//3-You validate that the All product Name are listed as DESCENDING ORDER
//TIPS:Collections.sort and Collections.reverse() method will help
//TIPS:One loop will be enough to complete this task.
NOTE:We will do task 1 and task2 in class together on TUESDAY. (edited)
 */
    @Test
    public void homework() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement username = driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement loginButton = driver.findElement(By.xpath("//button"));
        loginButton.click();
        Thread.sleep(1000);
        WebElement adminButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        adminButton.click();
        WebElement catalog = driver.findElement(By.xpath("//a[@class='parent collapsed']"));
        catalog.click();
        WebElement productButton = driver.findElement(By.xpath("//a[contains(text(),'Products')]"));
        productButton.click();
        WebElement clickProductName = driver.findElement(By.xpath("//a[@class='asc']"));
        clickProductName.click();
        WebElement orderList = driver.findElement(By.xpath("//a[@class='desc']"));


        Assert.assertTrue(orderList.getAttribute("class").equals("desc"));
        Assert.assertFalse(orderList.getAttribute("class").equals("asc"));

        List<WebElement> allProducts = driver.findElements(By.xpath("//a[.='Products']"));
        List<String> expectedProduct = new ArrayList<>();
        List<String> actualProduct = new ArrayList<>();

        for (int i = 1; i < allProducts.size()  ; i++) {
            actualProduct.add(allProducts.get(i).getText().toLowerCase().trim());
            expectedProduct.add(allProducts.get(i).getText().toLowerCase().trim());
        }
        Collections.sort(expectedProduct);
        Assert.assertEquals(actualProduct,expectedProduct);

    }

    @Test
    public void ValidateDescendingOrder () throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement username = driver.findElement(By.cssSelector("#input-username"));
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("demo");
        WebElement loginButton = driver.findElement(By.xpath("//button"));
        loginButton.click();
        Thread.sleep(1000);
        WebElement adminButton = driver.findElement(By.xpath("//button[@class='btn-close']"));
        adminButton.click();
        WebElement catalog = driver.findElement(By.xpath("//a[@class='parent collapsed']"));
        catalog.click();
        WebElement productButton = driver.findElement(By.xpath("//a[contains(text(),'Products')]"));
        productButton.click();
        WebElement productNameButton = driver.findElement(By.xpath("//a[@class='asc']"));
        productNameButton.click();
        List<WebElement> allProducts = driver.findElements(By.xpath("//a[.='Products']"));
        List<String> expectedProduct = new ArrayList<>();
        List<String> actualProduct = new ArrayList<>();

        for (int i = 1; i < allProducts.size()  ; i++) {
            actualProduct.add(allProducts.get(i).getText().toLowerCase().trim());
            expectedProduct.add(allProducts.get(i).getText().toLowerCase().trim());
        }

        Collections.sort(expectedProduct); //ascending order
        Collections.reverse(expectedProduct); //descending order
        Assert.assertEquals(actualProduct,expectedProduct);




    }










}
