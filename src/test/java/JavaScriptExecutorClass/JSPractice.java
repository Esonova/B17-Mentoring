package JavaScriptExecutorClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.channel.pool.FixedChannelPool;
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

public class JSPractice {
    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/radio-button");
        WebElement impressiveButton = driver.findElement(By.xpath("//input[@id='impressiveRadio']"));
        //impressiveButton.click();
        Actions actions = new Actions(driver);
        //actions.click(impressiveButton).perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()" , impressiveButton);
        WebElement validationText = driver.findElement(By.xpath("//span[@class='text-success']"));
        String actualText = BrowserUtils.getText(validationText);
        String expectedText = "Impressive";
        Assert.assertEquals(actualText,expectedText);

        WebElement NoButton = driver.findElement(By.cssSelector("#noRadio"));
        Assert.assertFalse(NoButton.isEnabled());









    }


}
