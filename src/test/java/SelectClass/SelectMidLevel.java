package SelectClass;

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

public class SelectMidLevel {
    /*
1-Navigate to the website
2-Select one way trip button
3-Choose 4 passangers
4-Validate the depart from is default "Acapulco"
5-Choose the depart from is Paris
6-Choose the date August 15th
7-Choose the arrive in is San Francisco
8-Choose the date December 15th
10-Click first class option.
11-Validate All the options from Airline
12-Choose the Unified option from airline list
13-Click Continue
14-Validate the message from header which should be "After flight finder - No Seats Available"


 NOTE:Your test should fail and say available is not matching with Available.
 NOTE2:You can use any select method value,visibleText
     */
    @Test
    public void validateOrderFunctionality(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement oneWayButton = driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWayButton.click();
        WebElement passengerCount = driver.findElement(By.xpath("//select[@name='passCount']"));
        Select passenger = new Select(passengerCount);
        passenger.selectByValue("4");
        WebElement departFromOptions = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select depart = new Select(departFromOptions);
        String actualFirstOption = depart.getFirstSelectedOption().getText().trim();
        String expectedFirstOption = "Acapulco";
        Assert.assertEquals(actualFirstOption,expectedFirstOption);
        depart.selectByValue("Paris");
        WebElement month = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select monthOption = new Select(month);
        monthOption.selectByValue("8");
        WebElement day = driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select daySelect = new Select(day);
        daySelect.selectByValue("15");
        WebElement arriving = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select arriceOption = new Select(arriving);
        arriceOption.selectByValue("San Francisco");
        WebElement ArrivalMonth = driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select months = new Select(ArrivalMonth);
        months.selectByValue("12");
        WebElement arrivalDay = driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select ArrivalDaySelect = new Select(arrivalDay);
        daySelect.selectByValue("15");
        WebElement firstClassOption = driver.findElement(By.xpath("//input[@value='First']"));
        firstClassOption.click();
        List<WebElement> allOptions = driver.findElements(By.xpath("//select[@name='airline']"));
        for (int i = 0; i < allOptions.size(); i++) {
            Assert.assertTrue(allOptions.get(i).isDisplayed());
        }
        WebElement unifiedOption = driver.findElement(By.xpath("//select[@name='airline']"));
        Select unifiedSelect = new Select(unifiedOption);
        unifiedSelect.selectByVisibleText("Unified Airlines");
        WebElement continuButton = driver.findElement(By.xpath("//input[@name='findFlights']"));
        continuButton.click();

        WebElement validateMessage = driver.findElement(By.xpath("//font[@size='4']"));
        String actualMessage = validateMessage.getText().trim();
        String expectedMessage = "After flight finder - No Seats Available";
        Assert.assertEquals(actualMessage,expectedMessage);

    }



    @Test
    public void shortCutAutomation(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement oneWayButton = driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWayButton.click();
        WebElement passengerCount = driver.findElement(By.xpath("//select[@name='passCount']"));
        BrowserUtils.selectBy(passengerCount,"4","value");
//        Select passenger = new Select(passengerCount);
//        passenger.selectByValue("4");
        WebElement departFromOptions = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select depart = new Select(departFromOptions);
        String actualFirstOption = depart.getFirstSelectedOption().getText().trim();
        String expectedFirstOption = "Acapulco";
        Assert.assertEquals(actualFirstOption,expectedFirstOption);
        BrowserUtils.selectBy(departFromOptions,"Paris","value");
//        depart.selectByValue("Paris");
        WebElement month = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select monthOption = new Select(month);
        monthOption.selectByValue("8");
        WebElement day = driver.findElement(By.xpath("//select[@name='fromDay']"));
        BrowserUtils.selectBy(day,"15","value");
//        Select daySelect = new Select(day);
//        daySelect.selectByValue("15");
        WebElement arriving = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select arriceOption = new Select(arriving);
        arriceOption.selectByValue("San Francisco");
        WebElement ArrivalMonth = driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select months = new Select(ArrivalMonth);
        months.selectByValue("12");
        WebElement arrivalDay = driver.findElement(By.xpath("//select[@name='fromDay']"));
        BrowserUtils.selectBy(arrivalDay,"15","value");
        //Select ArrivalDaySelect = new Select(arrivalDay);
        //daySelect.selectByValue("15");
        WebElement firstClassOption = driver.findElement(By.xpath("//input[@value='First']"));
        firstClassOption.click();
        List<WebElement> allOptions = driver.findElements(By.xpath("//select[@name='airline']"));
        for (int i = 0; i < allOptions.size(); i++) {
            Assert.assertTrue(allOptions.get(i).isDisplayed());
        }
        WebElement unifiedOption = driver.findElement(By.xpath("//select[@name='airline']"));
        Select unifiedSelect = new Select(unifiedOption);
        unifiedSelect.selectByVisibleText("Unified Airlines");
        WebElement continuButton = driver.findElement(By.xpath("//input[@name='findFlights']"));
        continuButton.click();

        WebElement validateMessage = driver.findElement(By.xpath("//font[@size='4']"));
        String actualMessage = BrowserUtils.getText(validateMessage);
                //validateMessage.getText().trim();
        String expectedMessage = "After flight finder - No Seats Available";
        Assert.assertEquals(actualMessage,expectedMessage);
    }



}
