package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class FindElementsMethod {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("file:///C:/Users/esono/Downloads/Techtorialhtml.html");
        List<WebElement> allBox = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for(WebElement box : allBox){
            if (box.isDisplayed() && !box.isSelected() && box.isEnabled()){
                Thread.sleep(2000); //we put sleep method to see. it is not necessary
                box.click();

            }
            System.out.println(box.isSelected() ? "Checked" : "Failed");
        }


    }
}
