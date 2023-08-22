package SelectClass;

import com.github.dockerjava.api.model.Link;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.List;

public class DreamCar {

    @Test
    public void SearchFunctionality() throws InterruptedException {
         /*
        /*
NOTE: Please use browser utils for the select classes if it is needed or getText.
1-Navigate to the website
2-Choose the "New" from the New/used option
3-Choose "Lexus" for Make part
4-Choose "RX-350"
5-Validate the Price is selected "No max price"-->getFirstSelectedOption -->regular select
6-Choose the distance 40 mil
7-Put your Zip code-->Before that Clear it.60056 element.clear()
8-Click Search Button
9-Validate the header "New Lexus RX 350 for sale"
10-Click Sort by and choose the Lowest Price
11-Validate the all titles has Lexus RX 350
     */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.cars.com/");
        WebElement newOption = driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']"));
        newOption.click();
        BrowserUtils.selectBy(newOption,"new","value");
        WebElement makeOptions = driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.selectBy(makeOptions,"lexus","value");
        WebElement chooseModel = driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.selectBy(chooseModel,"lexus-rx_350","value");
        WebElement selectPrice = driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        Select selectNoPrice = new Select(selectPrice);
        selectNoPrice.getFirstSelectedOption();
        WebElement selectMiles = driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowserUtils.selectBy(selectMiles,"40","value");
        WebElement zipcode = driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        zipcode.clear();
        zipcode.sendKeys("60056");
        WebElement searchButton = driver.findElement(By.xpath("//button[@data-linkname='search-new-make']"));
        searchButton.click();
        Thread.sleep(2000);
        WebElement header = driver.findElement(By.xpath("//h1[@class='sds-heading--1 sds-page-section__title']"));
        String actualHeader = header.getText().trim();
        String expectedHeader = "New Lexus RX 350 for sale";
        Assert.assertEquals(actualHeader,expectedHeader);
        WebElement sortBy = driver.findElement(By.xpath("//select[@id='sort-dropdown']"));
        Thread.sleep(3000);
        BrowserUtils.selectBy(sortBy,"list_price","value");
        Thread.sleep(2000);
        List<WebElement> allCarTitles = driver.findElements(By.xpath("//a[@class='vehicle-card-link js-gallery-click-link']"));
        for (int i = 0; i < allCarTitles.size(); i++) {
            Assert.assertTrue(allCarTitles.get(i).getText().trim().contains("Lexus RX 350"));

        }



    }

/*
choose your dream car

click lowest price
validate prices are showing from lowest to highest
replace $ and , with nothing
click highest price
validate highest to lowest



 */


}
