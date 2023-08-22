package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathRealHealthProject {
       /*
//THESE PARTS SHOULD BE DONE BY XPATH:
1-Navigate to the https://katalon-demo-cura.herokuapp.com/
2-Click Make an Appointment
3-Login the username and password provided and Login successfully
4-Choose the facility either HongKong or Seoul -->send keys
5-Click apply for hospital admission box if it is displayed and validate it is selected
6-Healthcare program 'Medicaid'
7-Visit date should be provided -->send keys
8-Put your comment for this box -->send keys
9-Book your appointment
THESE PARTS SHOULD BE DONE BY CONTAINS or . XPATH METHOD
10-Validate the header is "Appointment confirmation" (if statement)
11-Print out the headers and values(only values) on your console.
12)Click go to homepage and print out url
13)Driver.quit or close.
           */
       public static void main(String[] args) throws InterruptedException {
           WebDriverManager.chromedriver().setup();
           WebDriver driver = new ChromeDriver();
           driver.get("https://katalon-demo-cura.herokuapp.com/");
           WebElement makeApp = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
           Thread.sleep(2000);
           makeApp.click();
           WebElement name = driver.findElement(By.xpath("//input[@id='txt-username']"));
           name.sendKeys("John Doe");
           WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
           password.sendKeys("ThisIsNotAPassword");
           WebElement button = driver.findElement(By.xpath("//button[@id='btn-login']"));
           button.click();
           WebElement facility = driver.findElement(By.xpath("//select[@id='combo_facility']"));
           facility.sendKeys("Hongkong CURA Healthcare Center");
           WebElement applyButton = driver.findElement(By.xpath("//input[@id='chk_hospotal_readmission']"));
           applyButton.click();
           WebElement medicaid = driver.findElement(By.xpath("//input[@id='radio_program_medicaid']"));
           medicaid.click();
           WebElement date = driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
           date.sendKeys("9/8/2023");
           WebElement comment = driver.findElement(By.xpath("//textarea[@id='txt_comment']"));
           comment.sendKeys("Selenium is Great");
           Thread.sleep(2000);
           WebElement bookApp = driver.findElement(By.xpath("//button[@id='btn-book-appointment']"));
           bookApp.click();
           WebElement header = driver.findElement(By.xpath("//h2[contains(text(),'Appointment Confirmation')]"));
           String actualHeader = header.getText();
           String expectedHeader = "Appointment Confirmation";
           System.out.println(actualHeader.equals(expectedHeader) ? "Header Passed" : "Header Failed");
           System.out.println(header.getText());
           WebElement facilityPrint = driver.findElement(By.xpath("//p[@id='facility']"));
           System.out.println(facilityPrint.getText());
           WebElement readmission = driver.findElement(By.xpath("//p[@id='hospital_readmission']"));
           System.out.println(readmission.getText());
           WebElement medical = driver.findElement(By.xpath("//p[@id='program']"));
           System.out.println(medical.getText());
           WebElement datePrint = driver.findElement(By.xpath("//p[@id='visit_date']"));
           System.out.println(datePrint.getText());
           WebElement commentPrint = driver.findElement(By.xpath("//p[@id='comment']"));
           System.out.println(commentPrint.getText());
           WebElement homePage = driver.findElement(By.xpath("//a[contains(text(),'Go to Homepage')]"));
           homePage.click();
           System.out.println(driver.getCurrentUrl());
           driver.close();








       }
}
