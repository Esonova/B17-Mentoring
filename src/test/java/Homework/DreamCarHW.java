package Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class DreamCarHW {
    /*
choose your dream car

click lowest price
validate prices are showing from lowest to highest
replace $ and , with nothing
click highest price
validate highest to lowest
 */
    @Test
    public void homework(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.cars.com/");
        WebElement newOption = driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']"));
        newOption.click();
        BrowserUtils.selectBy(newOption,"new","value");
        WebElement makeOptions = driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.selectBy(makeOptions,"mercedes_benz","value");
        WebElement chooseModel = driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.selectBy(chooseModel,"-mercedes_benz-glc_all","value");
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



    }


}
