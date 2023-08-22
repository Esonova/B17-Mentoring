package ActionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class DragAndDrop {

    @Test
    public void DragAndDropMethod() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        WebElement orangeBox = driver.findElement(By.xpath("//div[@class='test2']"));
        String actualOrangeBox = BrowserUtils.getText(orangeBox);
        String expectedOrangeBox = "... Or here.";
        Assert.assertEquals(actualOrangeBox,expectedOrangeBox);
        String actualOrangeBoxColor = orangeBox.getCssValue("background-color");
        String expectedOrangeBoxColor = "rgba(238, 111, 11, 1)";
        Assert.assertEquals(actualOrangeBoxColor,expectedOrangeBoxColor);
        WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable,orangeBox).perform();
        Thread.sleep(3000);
        orangeBox = driver.findElement(By.xpath("//div[@class='test2']"));
        String actualOrangeBoxTextAfter = BrowserUtils.getText(orangeBox);
        String expectedOrangeBoxTextAfter = "You did great!";
        Assert.assertEquals(actualOrangeBoxTextAfter,expectedOrangeBoxTextAfter);
    }

    @Test
    public void DragAndDropPractice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        WebElement blueBox = driver.findElement(By.xpath("//div[@class='test1']"));
        String actualBlueBox = BrowserUtils.getText(blueBox);
        String expectedBlueBox = "Drag the small circle here ...";
        Assert.assertEquals(actualBlueBox,expectedBlueBox);
        String actualBlueBoxColor = blueBox.getCssValue("background-color");
        String expectedBlueBoxColor = "rgba(63, 81, 181, 1)";
        Assert.assertEquals(actualBlueBoxColor,expectedBlueBoxColor);
        WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable,blueBox).perform();
        blueBox = driver.findElement(By.xpath("//div[@class='test1']"));
        String actualBlueBoxTextAfter = BrowserUtils.getText(blueBox);
        String expectedBlueBoxTextAfter = "You did great!";
        Assert.assertEquals(actualBlueBoxTextAfter,expectedBlueBoxTextAfter);
    }

    @Test
    public void ClickAndHoldMethod(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        Actions actions = new Actions(driver);
        actions.scrollByAmount(300,300);
        WebElement blueBox = driver.findElement(By.xpath("//div[@class='test1']"));
        String actualBlueBox = BrowserUtils.getText(blueBox);
        String expectedBlueBox = "Drag the small circle here ...";
        Assert.assertEquals(actualBlueBox,expectedBlueBox);
        String actualBlueBoxColor = blueBox.getCssValue("background-color");
        String expectedBlueBoxColor = "rgba(63, 81, 181, 1)";
        Assert.assertEquals(actualBlueBoxColor,expectedBlueBoxColor);
        WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
        actions.clickAndHold(draggable).moveToElement(blueBox).release().perform();
        blueBox = driver.findElement(By.xpath("//div[@class='test1']"));
        String actualBlueBoxTextAfter = BrowserUtils.getText(blueBox);
        String expectedBlueBoxTextAfter = "You did great!";
        Assert.assertEquals(actualBlueBoxTextAfter,expectedBlueBoxTextAfter);

    }




}
