package Homework;

import SelectClass.SelectBasics;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Homework1 {
    /*
Navigate to
"http://secure.smartbearsoftware.com/samples/Te
stComplete11/WebOrders/Login.aspx?"
Validate the title is equals to "Web Orders Login"
Input username "Tester"
Input password "test"
Click login button
Validate the title is equals to "Web Orders"
Validate header is equals to "List of All Orders"
Test Scenario
Test Case -1
 */

    @Test
    public void testCase1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        String actualTitle = driver.getTitle().trim();
        String expectedTitle = "Web Orders Login";
        Assert.assertEquals(actualTitle,expectedTitle);
        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        loginButton.click();
        WebElement title2 = driver.findElement(By.xpath("//h1"));
        String actualTitle2 = title2.getText().trim();
        String expectedTitle2 = "Web Orders";
        Assert.assertEquals(actualTitle2,expectedTitle2);
        WebElement header = driver.findElement(By.xpath("//h2"));
        String actualHeader = header.getText().trim();
        String expectedHeader = "List of All Orders";
    }
/*
Navigate to
"http://secure.smartbearsoftware.com/samples/TestCo
mplete11/WebOrders/Login.aspx?"
Input username "Tester"
Input password "Test"
Click login button
Click "View all products" button
Validate "View all products" is selected
Validate header is equals to "List of Products"
Validate the url has "Products" keyword
 */
    @Test
    public void testCase2(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        loginButton.click();
        WebElement viewAllProducts = driver.findElement(By.linkText("View all products"));
        viewAllProducts.click();
        WebElement header2 = driver.findElement(By.xpath("//h2"));
        String actualheader2 = header2.getText().trim();
        String expectedheader2 = "List of Products";
        Assert.assertEquals(actualheader2,expectedheader2);
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Products.aspx";
        Assert.assertTrue(actualURL.contains("Products"));
    }
/*
Find the links for
View all orders
View all products
Orders
Validate their href values are equals to :
"Default.aspx"
"Products.aspx"
"Process.aspx"
 */
    @Test
    public void testCase3(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        loginButton.click();
        WebElement viewOrders = driver.findElement(By.linkText("View all orders"));
        viewOrders.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("Default.aspx"));
        driver.navigate().back();
        WebElement viewProducts = driver.findElement(By.linkText("View all products"));
        viewProducts.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("Products.aspx"));
        driver.navigate().back();
        WebElement orders = driver.findElement(By.xpath("//a[.='Order']"));
        orders.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("Process.aspx"));
        driver.navigate().back();
    }
/*
Click "Order" button
Select product "Screen Saver"
Input quantity 5
Input Customer name "CodeFish IT School"
Input Street "2200 E devon"
Input City "Des Plaines"
Input State "Illinois"
Input Zip "60018"
Select MasterCard
Input card number "444993876233"
Input expiration date "03/24"
Click Process button
Validate text "New order has been successfully
added." is displayed below the Process button.
Click View all orders button
Validate new order is added and all inputs are
matching with new order
 */
    @Test
    public void testCase4(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        loginButton.click();
        WebElement orders = driver.findElement(By.xpath("//a[.='Order']"));
        orders.click();
        WebElement screenSaver = driver.findElement(By.xpath("//option[@value='ScreenSaver']"));
        screenSaver.click();
        WebElement quantity = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        quantity.sendKeys("5");
        WebElement customerName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"));
        customerName.sendKeys("CodeFish IT School");
        WebElement street = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']"));
        street.sendKeys("2200 E devon");
        WebElement city = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']"));
        city.sendKeys("Des Plaines");
        WebElement state = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']"));
        state.sendKeys("Illinois");
        WebElement zip = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']"));
        zip.sendKeys("60018");
        WebElement masterCard = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_1']"));
        masterCard.click();
        WebElement cardNum = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"));
        cardNum.sendKeys("444993876233");
        WebElement expiration = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']"));
        expiration.sendKeys("03/24");
        WebElement processButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton"));
        processButton.click();
        WebElement validateText = driver.findElement(By.xpath("//strong"));
        Assert.assertTrue(validateText.isDisplayed());
        WebElement viewOrders = driver.findElement(By.linkText("View all orders"));
        viewOrders.click();


        List<WebElement> orderInfo = driver.findElements(By.xpath("html/body/form/table/tbody/tr/td[2]/div[2]/div[3]/table/tbody/tr[2]/td"));
        List<String> actualOrder = new ArrayList<>();
        for (int i = 1; i < orderInfo.size()-1; i++){
            actualOrder.add(orderInfo.get(i).getText().trim());
        }
        List<String> expectedOrder = new ArrayList<>();
        expectedOrder.add("CodeFish IT School");
        expectedOrder.add("ScreenSaver");
        expectedOrder.add("5");
        expectedOrder.add("08/16/2023");
        expectedOrder.add("2200 E devon");
        expectedOrder.add("Des Plaines");
        expectedOrder.add("Illinois");
        expectedOrder.add("60018");
        expectedOrder.add("MasterCard");
        expectedOrder.add("444993876233");
        expectedOrder.add("03/24");

        Assert.assertEquals(actualOrder,expectedOrder);
        System.out.println(expectedOrder);
        System.out.println(actualOrder);

        driver.close();













    }
}
