package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class FindElementsPractice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/");
        List<WebElement> allLinks = driver.findElements(By.xpath("//li"));
        int counter = 0;
        for (WebElement link : allLinks){
            System.out.println(link.getText());
            counter++;
        }
        System.out.println(counter);




        //TASK 2
        //print out word that its size is more than equal to 12
        int count2 = 0;
        for (WebElement link2 : allLinks){
            if (link2.getText().trim().length() >= 12){
                System.out.println(link2.getText().trim());
                count2++;
            }
        }
        System.out.println(count2);





    }
}
