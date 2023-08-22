package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SelectBasicPractice {
    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("file:///C:/Users/esono/Downloads/Techtorialhtml.html");
        WebElement country = driver.findElement(By.xpath("//select[@name='country']"));
        Select countryselect = new Select(country);
        String actualSelect = countryselect.getFirstSelectedOption().getText().trim();
        String expectedSelect = "UNITED STATES";
        Assert.assertEquals(actualSelect,expectedSelect);
        int counter = 0;
        List<WebElement> allCountries = countryselect.getOptions();//driver.findElements(By.xpath("//select[@class='select']"));
        for (WebElement eachCountry : allCountries){
            System.out.println(eachCountry.getText().trim());
            counter++;

        }
        System.out.println(counter);

        //Task
        //Choose your own country with visible text method
        //choose your favorite country with value
        //choose your travel country with index
        //use thread.sleep between them to see how it changes

        countryselect.selectByVisibleText("KYRGYZSTAN");
        Thread.sleep(2000);
        countryselect.selectByValue("215");
        countryselect.selectByIndex(5);





    }




}
