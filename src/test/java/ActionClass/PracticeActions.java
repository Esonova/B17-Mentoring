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

public class PracticeActions {

    @Test
    public void practiceDragAndDrop(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");
        Actions actions = new Actions(driver);
        WebElement draggable = driver.findElement(By.cssSelector("#draggable"));
        WebElement dropBox = driver.findElement(By.xpath("//div[@class='drop-box ui-droppable']"));
        WebElement dropHereText = driver.findElement(By.xpath("//div[@id='simpleDropContainer']//p[contains(text(),'Drop here')]"));
        String actualDropHereText = BrowserUtils.getText(dropHereText);
        String expectedDropHereText = "Drop here";
        Assert.assertEquals(actualDropHereText,expectedDropHereText);
        actions.dragAndDrop(draggable,dropBox).perform();
        WebElement droppedText = driver.findElement(By.xpath("//div[@id='simpleDropContainer']//p[contains(text(),'Dropped')]"));
        String actualDroppedText = BrowserUtils.getText(droppedText);
        String expectedDroppedText = "Dropped!";
        Assert.assertEquals(actualDroppedText,expectedDroppedText);
        WebElement DropBoxColor = driver.findElement(By.xpath("//div[@class='drop-box ui-droppable ui-state-highlight']"));
        String actualBoxColor = DropBoxColor.getCssValue("background-color");
        String expectedBoxColor = "rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualBoxColor,expectedBoxColor);
    }

    @Test
    public void clickAndHoldPractice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");
        Actions actions = new Actions(driver);
        WebElement clickAccept = driver.findElement(By.xpath("//a[@id='droppableExample-tab-accept']"));
        actions.click(clickAccept).perform();
        WebElement Draggable = driver.findElement(By.xpath("//div[@id='notAcceptable']"));
        WebElement dropHereText = driver.findElement(By.xpath("//div[@class='accept-drop-container']//div[@class='drop-box ui-droppable']//p[contains(text(),'Drop here')]"));
        String actualDropText = BrowserUtils.getText(dropHereText);
        String expectedDropText = "Drop here";
        Assert.assertEquals(actualDropText,expectedDropText);
        WebElement DropBox = driver.findElement(By.xpath("//div[@class='accept-drop-container']//div[@class='drop-box ui-droppable']"));
        actions.clickAndHold(Draggable).moveToElement(DropBox).release().perform();
        dropHereText = driver.findElement(By.xpath("//div[@class='accept-drop-container']//div[@class='drop-box ui-droppable']//p[contains(text(),'Drop here')]"));
        String actualDropTextAfter = BrowserUtils.getText(dropHereText);
        String expectedDropTextAfter = "Drop here";
        Assert.assertEquals(actualDropTextAfter,expectedDropTextAfter);

    }


}
