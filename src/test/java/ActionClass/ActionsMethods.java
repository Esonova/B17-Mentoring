package ActionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionsMethods {

    @Test
    public void contectClick(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement box = driver.findElement(By.cssSelector("#hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(box).perform();
    }

    @Test
    public void practiceContextClick(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        WebElement clickButton = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
        Actions actions = new Actions(driver);
        actions.contextClick(clickButton).perform();
    }

    @Test
    public void doubleClick(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        WebElement doubleClickBox = driver.findElement(By.xpath("//button"));
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickBox).perform();
    }





}
