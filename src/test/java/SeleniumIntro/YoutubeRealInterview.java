package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class YoutubeRealInterview {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.youtube.com/");

        WebElement search = driver.findElement(By.xpath("//input[@id='search']"));
        search.sendKeys("Justin Bieber");
        search.sendKeys(Keys.ENTER);


        List<WebElement> allSongs = driver.findElements(By.xpath("//a[@id='video-title']"));

        for (WebElement song : allSongs){
            if (song.getAttribute("title").equals("Justin Bieber - Baby ft. Ludacris")){
                Thread.sleep(2000);
                song.sendKeys(Keys.ARROW_DOWN);
                song.click();
                break;
            }
        }









    }
}
