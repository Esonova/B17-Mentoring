package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDriverMethods {
    //driver.get()
    //driver.manage.window.maximize()
    //driver.getTitle()
    //driver.GetCurrentURL()
    //driver.navigate.to()
    //driver.nagvigate.refresh()
    //driver,navigate.forward()
    //driver.nagivate.back()
    //driver.getPageSourse()
    //driver.close()
    //driver.quit()


    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();//It maximizes your screen
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(3000);// we use this to pause This will wait for 3 seconds
        driver.navigate().to("https://www.facebook.com/");
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        driver.navigate().back();//google
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000);
        driver.navigate().forward();//facebook
        System.out.println(driver.getTitle());
        System.out.println(driver.getPageSource()); //This will give you html structure of the page
        driver.quit();






    }


}
