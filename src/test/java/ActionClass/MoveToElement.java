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
import java.util.Arrays;
import java.util.List;

public class MoveToElement {

    @Test
    public void MoveToElementMethod() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/hovers");
        List<WebElement> allImg = driver.findElements(By.xpath("//img[@alt='User Avatar']"));
        List<WebElement> allNames = driver.findElements(By.xpath("//h5"));
        Actions actions = new Actions(driver);
        List<String> expectedNames = Arrays.asList("name: user1","name: user2","name: user3");
        for (int i = 0; i < allNames.size(); i++) {
            Thread.sleep(2000);
            actions.moveToElement(allImg.get(i)).perform(); //hover over the element
            Assert.assertEquals(BrowserUtils.getText(allNames.get(i)), expectedNames.get(i));
            System.out.println(BrowserUtils.getText(allNames.get(i))); //get the elements
        }


    }


}
