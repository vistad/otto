// UI-test-2
// 1)Go to www.otto.de
// 2)Click in the navigation menu on "multimedia"
// 3)Click in the left navigation on "Blu-Ray-Player"
// 4)Open the first product
// 5)Validate, that the product detail page contains the string "Artikelbeschreibung"


import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class BlueRayPlayer {


        public static void main(String[] args) throws IOException, InterruptedException {
                System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");


                ChromeOptions options = new ChromeOptions();
                //options.addArguments("--headless");
                //clearoptions.addArguments("start-maximized");
                //options.addArguments("lang=de");
 
                //initialize the driver
                WebDriver driver = new ChromeDriver(options);

                //open the page
                driver.get("https://www.otto.de");
                Thread.sleep(3000);

                //press the OK button to accept cookies 
                driver.findElement(By.cssSelector(".cookieBanner__button")).click();
                Thread.sleep(3000);

                // the method find_element lets us find the multimedia link, the method click lets us click it
                driver.findElement(By.linkText("Multimedia")).click();
                Thread.sleep(3000);

                // the method xpath lets us find an element by xpath
                driver.findElement(By.xpath("//* [contains(text(), 'Blu-ray-Player')]")).click();
                Thread.sleep(3000);

                // search for the 1st element in the output field and click to choose it
                driver.findElement(By.cssSelector("[data-qa='ftfind-product-1']")).click();
                Thread.sleep(3000);


                if (driver.getPageSource().contains("Artikelbeschreibung")) {
                        System.out.println("Found it!");
                } else {
                        System.out.println("Failed");
                }
                driver.quit();
        }


}




