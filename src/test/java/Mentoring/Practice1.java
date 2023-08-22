package Mentoring;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice1 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        WebElement search = driver.findElement(By.id("APjFqb"));
        search.sendKeys("Indian Food"+ Keys.ENTER);

        WebElement indianFood = driver.findElement(By.xpath("//h3[contains(text(),'THE BEST 10 Indian Restaurants in Des Plaines, IL')]"));
        indianFood.click();
        driver.getCurrentUrl();








    }
}
