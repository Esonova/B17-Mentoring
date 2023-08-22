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
import java.util.*;

public class MoveToElementPractice {
    /*
    1-Navigate to the website
    2-If you have cookies pop-up then click
    3-Hover over each pictures and get the names and store it in List<String> allNames
    4-Hover over each pictures and get the prices and store it in List<String> all prices
    5-Put them all of the names as key of map, and all of the prices as value of map
    6-Print out map

    CLUES:You can use 1 regular(indexing) loop for adding the name and prices into the lists
    CLUES:You can use same loop for putting into the map
    CLUES:TO ab ele to get names and prices you need to hover over first
    CLUES:DO not forget perform
     */
    //handle popup with automation, hover over each picture,
    // get all the names and store in the list and also the prices and store in the list
    // put all the name sand price as a map format.
    // you can use regular loop just one loop

    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/fx/expand");
        Actions actions = new Actions(driver);
        List<WebElement> allPics = driver.findElements(By.xpath("//div[@class='product k-listview-item']"));
        List<WebElement> allName = driver.findElements(By.xpath("//h3"));
        List<WebElement> allPrice = driver.findElements(By.xpath("//div[@class='product-description']//p"));
        Map<String,String> productInfo = new HashMap<>();

        for (int i = 0; i < allPics.size(); i++) {
            actions.moveToElement(allPics.get(i)).perform();
            productInfo.put(BrowserUtils.getText(allName.get(i)),BrowserUtils.getText(allPrice.get(i)));

        }
        System.out.println(productInfo);


    }



}
