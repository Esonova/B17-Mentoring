package JavaScriptExecutorClass;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaScriptMethods {

    @Test
    public void getTitle(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://codefish.io/");
        System.out.println(driver.getTitle() + " This is from driver method");
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        System.out.println(js.executeScript("return document.title ")+" This is from JS method");

        System.out.println(BrowserUtils.getTitleWithJS(driver));
    }

    @Test
    public void ClickJS() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://codefish.io/");
        WebElement aboutUsButton = driver.findElement(By.xpath("//button[.='About us']"));
        aboutUsButton.click();
        driver.navigate().back();
        Actions actions = new Actions(driver);
        actions.click(aboutUsButton).perform();
        driver.navigate().back();
        Thread.sleep(5000);
        //IF NONE OF THEM WORK USE JS CLICK
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click()" , aboutUsButton);
        BrowserUtils.clickWithJS(driver,aboutUsButton);

    }

    @Test
    public void ScrollIntoView() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://codefish.io/");
        WebElement address = driver.findElement(By.xpath("//p[contains(text(),'2200')]"));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true)",address);
        BrowserUtils.scrollIntoView(driver,address);
        Thread.sleep(3000);
        WebElement contactUs = driver.findElement(By.xpath("//button[.='Contact Us']"));
        //js.executeScript("arguments[0].scrollIntoView(true)",contactUs);
        BrowserUtils.scrollIntoView(driver,contactUs);
    }

    @Test
    public void practiceAll(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techtorialacademy.com/");

    }
/*
EVERYTHING (BrowserUtil)
scroll down and print validate "copyright c 2023"
scroll back up to "LAUNCH A NEW TECH CAREER"
click apply now with js method.
validate the title is "apply now"
validate the 3 boxes with  "as list method"
 */
    /*
1-Navigate to the website
2-Scroll All the way down to the "CopyRight 2023" and validate "Copyright © 2023
3-Scroll All the way up to the "Launch a new tech Career".
4-Click Apply Now button with JS.
5-Validate the title with JS "Apply Now"
6-Validate the information at the middle which are "info@...etc","+ 1 (224) 570 91 91","Chicago & Houston"
7-close all of your browsers(driver.quit)
 */

    @Test
    public void homework(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techtorialacademy.com/");
        WebElement copyRightText = driver.findElement(By.cssSelector("#el_1666192783854_462"));
        BrowserUtils.scrollIntoView(driver,copyRightText);
        String actualText = copyRightText.getText();
        String expectedText = "Copyright © 2023";
        Assert.assertEquals(actualText,expectedText);
        WebElement header = driver.findElement(By.xpath("//b[contains(text(),'LAUNCH A NEW TECH CAREER')]"));
        BrowserUtils.scrollIntoView(driver,header);
        WebElement applyButton = driver.findElement(By.xpath("//a[@id='menuItem_1594985863854_2']"));
        BrowserUtils.clickWithJS(driver,applyButton);
        WebElement applyText = driver.findElement(By.xpath("//h1"));
        String actualApplyText = BrowserUtils.getTitleWithJS(driver);
        String expectedApplyText = "Apply Now";
        Assert.assertEquals(actualApplyText,expectedApplyText);
        List<WebElement> allInfo = driver.findElements(By.xpath("//div[@id='el_1658248667273_2359']//h3"));
        List<String> expectedInfo = Arrays.asList("info@techtorialacademy.com","+ 1 (224) 570 91 91","Chicago & Houston");
        List<String> actualInfo = new ArrayList<>();
        for (WebElement info : allInfo){
            actualInfo.add(info.getText().trim());
        }
        Assert.assertEquals(actualInfo,expectedInfo);
        driver.quit();

    }




}
