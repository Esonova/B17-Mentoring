package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class RealLifeExample {
    /*
      //  Test Case - Open Godaddy.com and validate it's Page title and the url.
//    Steps to Automate:
//            1. Launch browser of your choice say., Firefox, chrome etc.
//            2. Open this URL - https://www.godaddy.com/
//3. Get Title of page and validate it.(if conditions) expected title from website
//3. Get URL of current page and validate it.          expected url from website
//            4. Close browser.
     */

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.godaddy.com/");
        driver.getTitle();
        String expectedTitle = driver.getTitle();
        String actualTitle = "Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy";
        if (expectedTitle.equals(actualTitle)){
            System.out.println("Correct title");
        }else{
            System.out.println("Wrong title");
        }
        driver.getCurrentUrl();
        String expectedURL = driver.getCurrentUrl();
        String actualURL = "https://www.godaddy.com/";
        if (expectedURL.equals(actualURL)){
            System.out.println("URl Passed");
        }else{
            System.out.println("URL Failed");
        }
        driver.close();



    }





}
