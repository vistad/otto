// UI-test-1
// 1)Go to www.otto.de
// 2)Search for "Jeans"
// 3)Open the first product
// 4)Validate, that the product detail page contains the string "Artikelbeschreibung"


import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class Jeans {


        public static void main(String[] args) throws IOException, InterruptedException {
                System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");


                ChromeOptions options = new ChromeOptions();
                //options.addArguments("--headless");
                //options.addArguments("start-maximized");
                //options.addArguments("lang=de");
 
                //initialize the driver
                WebDriver driver = new ChromeDriver(options);

                //open the page
                driver.get("https://www.otto.de");
                Thread.sleep(3000);

                //press the OK button to accept cookies 
                driver.findElement(By.cssSelector(".cookieBanner__button")).click();
                Thread.sleep(3000);

                //the method find_element lets us find the element - the main search field
                WebElement textarea =
                driver.findElement(By.cssSelector(".squirrel_searchbar__input"));
                Thread.sleep(3000);

                //the text I am searching
                textarea.sendKeys("Jeans");
                Thread.sleep(3000);

                //find the submit button
                WebElement submitButton =
                driver.findElement(By.cssSelector(".squirrel_searchbar__submit"));

                //press the submit button
                submitButton.click();
                Thread.sleep(3000);

                //search for the 1st element in the output field and click to choose it
                driver.findElement(By.cssSelector("#san_resultSection > article.product")).click();
                Thread.sleep(3000);
 
                if (driver.getPageSource().contains("Artikelbeschreibung")) {
                        System.out.println("Found it!");
                } else {
                        System.out.println("Failed");
                }
                driver.quit();
        }


}




