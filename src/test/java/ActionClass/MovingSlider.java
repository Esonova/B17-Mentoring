package ActionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class MovingSlider {

    @Test
    public void validateSliderFunctionality() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        Actions actions = new Actions(driver);
        WebElement slider = driver.findElement(By.xpath("//input"));
        WebElement value = driver.findElement(By.xpath("//span"));
        String expectedValue = "4.5";

        while(!BrowserUtils.getText(value).equals(expectedValue)){
            Thread.sleep(1000);
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
        Assert.assertEquals(BrowserUtils.getText(value),expectedValue);


    }



}
